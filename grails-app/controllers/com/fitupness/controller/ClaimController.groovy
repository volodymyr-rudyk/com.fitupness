package com.fitupness.controller

class ClaimController {

//    static allowedMethods = [POST]

    def claimService

    def profileService

//    def index() {
//
//        def trainer = profileService.trainer
//
////        def claims = Claim.list().collect {claim -> claim.to.id}
//        def claims = Claim.findAllWhere(to : profileService.profile);/*.list().collect {claim -> claim.to.id}*/
//        println "-------------------------"
//        println claims
//        def s = Sportsman.list().findAll {
//            trainer != null &&
//            !claims.contains(it.profile.id)
//        }
//
//        println s
//        [sportsmanList:s, trainer : trainer]
//    }

    def list() {

    }

    def acceptClaim() {
        claimService.accept(params.from)
        flash.message = 'Claim accepted'
        redirect controller: 'trainer', action: 'claimsList'
    }

    def addClaim() {
        println params
        claimService.create(params.to)
        redirect action: 'index'
    }

    def refuseClaim() {
        claimService.refuse(params.from)
        redirect controller: 'trainer', action: 'claimsList'
    }
}
