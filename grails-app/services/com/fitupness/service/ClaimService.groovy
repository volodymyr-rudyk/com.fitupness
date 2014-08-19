package com.fitupness.service

import com.fitupness.domain.Claim
import com.fitupness.domain.Profile
import com.fitupness.domain.Sportsman
import grails.transaction.Transactional

@Transactional
class ClaimService {

    def profileService

    /**
     * Create claim to trainer
     * @param to trainer id
     * @return created claim
     */
    def create(to) {
        def profileTo = Profile.get(to)
        if (profileTo) {
            def profileFrom = profileService.profile
            def claim = new Claim(from: profileFrom, to: profileTo)
            claim.save(flush: true)
            claim
        }
    }

    /**
     *
     * @return claims count for currently logged trainer
     */
    def count() {
        Claim.countByTo(profileService.profile);
    }

//    def accept(to){
//        def claim = claimTo(to)
//        if(claim) {
//            // TODO unidirectional or indirection claim
//            def trainer = profileService.trainer
//            if (trainer) {
//                trainer.addToSportsmans(claim.to)
//                trainer.save(flush: true)
//            } else {
//                def sportsman = profileService.sportsman
//                sportsman.trainer = claim.to
//                sportsman.save(flush: true)
//            }
//
//            claim.delete(flush: true)
//        }
//    }

    /**
     * accepts claim from sportsman
     * @param from id sportsman which sent the claim
     * @return
     */
    def accept(from) {
        def claim = claimFrom(from)
        if (claim) {
            def trainer = profileService.trainer
            if (trainer) {
                def sportsman = Sportsman.findByProfile(claim.from)
                trainer.addToSportsmans(sportsman)
                trainer.save(flush: true)
                claim.delete(flush: true)
            }
        }
    }

    /**
     * refuses claim from sportsman
     * @param from id sportsman to refuse claim from
     * @return
     */
    def refuse(from) {
        def claim = claimFrom(from)
        if (claim)
            claim.delete flush: true
    }

    /**
     * returns Claim object
     * @param from id profile the claim was sent from
     * @return claim object
     */
    def Claim claimFrom(from) {
        def profileFrom = Profile.get(from)
        def profileTo = profileService.profile
        def claim = Claim.findByFromAndTo(profileFrom, profileTo)
        claim
    }

    def Claim claimFrom(Profile profile) {
        def profileFrom = profile
        def profileTo = profileService.profile
        def claim = Claim.findByFromAndTo(profileFrom, profileTo)
        claim
    }

    def Claim myClaim() {
        def profile = profileService.profile
        def claim = Claim.findByFrom(profile)
        claim
    }

}
