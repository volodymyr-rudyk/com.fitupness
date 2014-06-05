package com.fitupness.controller.profile

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class UserController {

    def index() {
        def logoutUrl = "${request.contextPath}${SpringSecurityUtils.securityConfig.logout.filterProcessesUrl}"

        [logoutUrl: logoutUrl]
    }
}
