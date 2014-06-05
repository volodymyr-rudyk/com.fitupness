package com.fitupness.service

import com.fitupness.domain.Profile
import com.fitupness.domain.Role
import com.fitupness.domain.User
import com.fitupness.domain.UserRole
import grails.transaction.Transactional

@Transactional
class AuthService {

    def signup(params) {
        def user = new User(params)
        def profile = new Profile(params)
        if(user.validate() && profile.validate()){
            user.profile = profile
            user.save(flush: true)
            def role = Role.findByAuthority("ROLE_USER")
            UserRole.create(user, role, true)
            return user
        }else {
            throw new RuntimeException('Error signup...')
        }
    }
}
