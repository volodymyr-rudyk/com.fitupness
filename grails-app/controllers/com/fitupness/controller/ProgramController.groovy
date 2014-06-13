package com.fitupness.controller

import com.fitupness.domain.SpGroup

class ProgramController {


    def profileService

    def sportProgramService

    def index() {

        def groups = SpGroup.where {
            profile == profileService.profile
        }

        [programs: profileService.profile.sportPrograms, groups: groups]
    }

    def create() {
        sportProgramService.addProgram(params)

        redirect action: 'index'
    }

    def delete() {
        sportProgramService.deleteProgram(params.id)
        redirect action: 'index'
    }

    def update() {

    }

    def createGroup() {
        sportProgramService.addGroup(params.name)
        redirect action: 'groups'
    }

    def deleteGroup() {
        sportProgramService.deleteGroup(params.id)
        redirect action: 'groups'
    }

    def groups() {
        render view: 'group', model: [groups: sportProgramService.listGroup()]
    }
}
