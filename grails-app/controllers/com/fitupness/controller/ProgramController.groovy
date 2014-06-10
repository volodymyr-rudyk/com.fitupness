package com.fitupness.controller

import com.fitupness.domain.SpGroup
import com.fitupness.domain.SportProgram

class ProgramController {


    def profileService

    def sportProgramService

    def index() {
        def programs = SportProgram.where {
            owner == profileService.profile
        }

        def groups = SpGroup.where {
            profile == profileService.profile
        }

        def count = SportProgram.count()

        [programs: programs, groups: groups, count: count]
    }

    def create() {
        println params.group
        def sportProgram = new SportProgram(params)
        if (sportProgram)
            sportProgram.owner = profileService.getProfile()

        def spGroup = SpGroup.get(params.group)
        println spGroup
        if (spGroup)
            sportProgram.addToGroups(spGroup)

        sportProgram.save(flush: true)

        redirect action: 'index'
    }

    def update() {

    }

    def createGroup() {
        sportProgramService.addGroup(params.name)
        redirect action: 'groups'
    }

    def groups() {
        render view: 'group', model: [groups: sportProgramService.listGroup()]
    }
}
