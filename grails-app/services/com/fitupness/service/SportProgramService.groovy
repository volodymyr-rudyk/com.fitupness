package com.fitupness.service

import com.fitupness.domain.SpGroup
import grails.transaction.Transactional

@Transactional
class SportProgramService {

    def profileService

    def addGroup(String name) {
        def spGroup = new SpGroup(name: name, profile: profileService.profile)
        spGroup.save()
        spGroup
    }

    def listGroup() {
        def groups = SpGroup.where {
            profile == profileService.profile
        }.list()
        groups
    }
}
