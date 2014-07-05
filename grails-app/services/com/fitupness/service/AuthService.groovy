package com.fitupness.service

import com.fitupness.domain.*
import grails.transaction.Transactional

@Transactional
class AuthService {

    def signup(params) {
        println "type =  ${params.type}"
        def profileType = ProfileType.get(params.type)
        if (!profileType) {
            profileType = ProfileType.where {
                type == 'sportsman'
            }.get()
        }

        def user = new User(params)
        def profile = new Profile(params)
        profile.save(flush: true)
        profile.rating = new Rating(points: 0)
        profile.rating.validate()
        profile.profileType = profileType
        profile.save(flush: true)
        user.profile = profile
        if (user.validate() /*&& profile.validate()*/) {
            user.save(flush: true)

            if (profileType.type == 'trainer') {
                def trainer = new Trainer(profile: user.profile)
                trainer.save(flush: true)
                def roleTrainer = Role.findByAuthority("ROLE_TRAINER")
                UserRole.create(user, roleTrainer, true)
            } else { // sportsman
                def sportsman = new Sportsman(profile: user.profile)
                sportsman.save(flush: true)
                def roleSportsman = Role.findByAuthority("ROLE_SPORTSMAN")
                UserRole.create(user, roleSportsman, true)
            }
            return user
        } else {
            if (user.hasErrors()) {
                user.errors.each { error ->
                    println error
                }
            }
            //throw new RuntimeException('Error signup...')
        }
        return user
    }
}
