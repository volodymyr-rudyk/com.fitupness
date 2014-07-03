package com.fitupness.controller.profile

import com.fitupness.domain.Trainer
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_SPORTSMAN'])
class UserController {

    def claimService

    def profileService

    def index() {
        def sportsman = profileService.sportsman
        def tr = Trainer.list()
        [sportsman: sportsman, trainers: tr]
    }

    def trainerList() {
        def claim = claimService.myClaim()
        def sportsman = profileService.sportsman

        [sportsman: sportsman,
         trainers : Trainer.list(),
         claim    : claim]
    }

    def addClaim() {
        claimService.create(params.to)
        redirect action: 'index'
    }

}
