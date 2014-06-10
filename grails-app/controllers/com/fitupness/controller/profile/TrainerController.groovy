package com.fitupness.controller.profile

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_TRAINER'])
class TrainerController {

    def profileService

    def index() {
        def trainer = profileService.getTrainer()
        println trainer
        [trainer: trainer]
    }
}
