package com.fitupness.service

import com.fitupness.domain.Profile
import com.fitupness.domain.Sportsman
import com.fitupness.domain.Trainer
import grails.transaction.Transactional

@Transactional
class ProfileService {

    def springSecurityService

    def Trainer getTrainer() {
        Trainer.findByProfile springSecurityService.currentUser.profile
    }

    def Sportsman getSportsman() {
        Sportsman.findByProfile springSecurityService.currentUser.profile
    }

    def Profile getProfile() {
        springSecurityService.currentUser.profile
//        Profile.get(springSecurityService.currentUser.profile.id)
    }
}
