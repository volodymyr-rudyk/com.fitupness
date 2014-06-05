package com.fitupness.controller.authentication

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured

@Secured('permitAll')
class AuthController {

    /**
     * Dependency injection for the springSecurityService.
     */
    def springSecurityService

    def authService

    def index() {
        println springSecurityService.getAuthentication().isAuthenticated()

        println "$controllerName, $actionName"
        if (springSecurityService.isLoggedIn()) {
            redirect uri: SpringSecurityUtils.securityConfig.successHandler.defaultTargetUrl
        }
        else {
            redirect action: 'login', params: params
        }
    }

    /**
     * Show the login page.
     */
    def login() {
        println springSecurityService.getAuthentication().isAuthenticated()
        def config = SpringSecurityUtils.securityConfig

        if (springSecurityService.isLoggedIn()) {
            redirect uri: config.successHandler.defaultTargetUrl
            return
        }

        String view = 'login'
        String postUrl = "${request.contextPath}${config.apf.filterProcessesUrl}"
        println "post url = $postUrl"
        render view: view, model: [postUrl: postUrl,
                                   rememberMeParameter: config.rememberMe.parameter]
    }

    def signup() {

    }

    def doSignup() {
        authService.signup(params)
        render view: 'login'
    }

    def authfail() {

    }

    def doLogin() {
    }

    def doLogout() {

    }

    def logout() {
        println 'logout'
    }
}
