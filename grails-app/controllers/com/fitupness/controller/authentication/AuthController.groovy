package com.fitupness.controller.authentication

import com.fitupness.domain.ProfileType
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.validation.Errors

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
        } else {
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
        render view: view, model: [postUrl            : postUrl,
                                   rememberMeParameter: config.rememberMe.parameter]
    }

    def signup() {
        render view: 'signup', model: [profileTypes: ProfileType.list()]
    }

    def doSignup() {
        def user = authService.signup(params)
        if (user.hasErrors()) {
            flash.errors = user.errors
            redirect action: 'signup'
            return Errors
        }
        flash.succed = 'Signup completed'
        redirect action: 'login'
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
