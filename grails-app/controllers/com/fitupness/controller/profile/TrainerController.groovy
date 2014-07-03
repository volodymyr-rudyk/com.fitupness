package com.fitupness.controller.profile

import com.fitupness.domain.Claim
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_TRAINER'])
class TrainerController {

    def profileService

    def claimService

    def afterInterceptor = { model ->
        model.claimsCount = claimService.count()
    }

    def index() {
        def trainer = profileService.getTrainer()
        [trainer: trainer]
    }

    def sportsmanList() {
        def trainer = profileService.getTrainer()
        [sportsmans: trainer.sportsmans]
    }

    def claimsList() {
        def claims = Claim.findAllWhere(to: profileService.profile);
        [claims: claims]
    }

    def acceptClaim() {
        forward controller: 'claim', action: 'acceptClaim'
    }

    def refuseClaim() {
        forward controller: 'claim', action: 'refuseClaim'
    }
}
