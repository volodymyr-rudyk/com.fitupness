package com.fitupness.controller.profile

import com.fitupness.domain.Profile

import javax.servlet.http.HttpServletResponse

class ProfileController {

    static defaultAction = "view"

    def profileService

    def view(Long id) {
        def profile = id ? Profile.get(id) : profileService.profile
        if (!profile) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND)
        }
        [profile: profile]
    }
}
