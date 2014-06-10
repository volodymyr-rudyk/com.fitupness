package com.fitupness.controller

import grails.plugin.springsecurity.annotation.Secured

@Secured('permitAll')
class AboutController {

    def index() {}
}
