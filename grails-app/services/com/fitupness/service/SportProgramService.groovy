package com.fitupness.service

import com.fitupness.domain.SpGroup
import com.fitupness.domain.SportProgram
import grails.transaction.Transactional

@Transactional
class SportProgramService {

    def profileService

    def addProgram(params) {
        def profile = profileService.getProfile()
        def sportProgram = new SportProgram(params)
        sportProgram.profile = profile
        sportProgram.save(flush: true)

        def spGroup = SpGroup.get(params.group)
        if (spGroup) {
            sportProgram.addToGroups(spGroup)
        }
        profile.addToSportPrograms(sportProgram)
        sportProgram.save(flush: true)
    }

    def deleteProgram(id) {
        def sportProgram = SportProgram.get(id)
        if (sportProgram) {
            def profile = profileService.getProfile()
            if (profile.sportPrograms.contains(sportProgram)) {
                sportProgram.groups.clear()
                profile.sportPrograms.remove(sportProgram)
                sportProgram.delete(flush: true)
            }
        }
    }

    def addGroup(String name) {
        def spGroup = new SpGroup(name: name, profile: profileService.profile)
        spGroup.save()
        spGroup
    }

    def deleteGroup(id) {
        def spGroup = SpGroup.get(id)
        if (spGroup.profile == profileService.profile) {
            println spGroup.sportPrograms*.name
            spGroup.sportPrograms.each { sp ->
                sp.delete(flush: true)
            }
            spGroup.delete(flush: true)
        }
    }

    def listGroup() {
        def groups = SpGroup.where {
            profile == profileService.profile
        }.list()
        groups
    }
}
