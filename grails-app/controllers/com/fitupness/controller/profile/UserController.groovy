package com.fitupness.controller.profile

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_SPORTSMAN'])
class UserController {

    def profileService

    def index() {
        def sportsman = profileService.getSportsman()
        println sportsman
        [sportsman: sportsman]
    }

    def index2() {

    }

}
