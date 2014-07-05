package com.fitupness.controller

class ProgramController {

    def profileService

    def sportProgramService

    def index() {

        [programs: profileService.trainer.sportPrograms,
         groups  : profileService.trainer.sportProgramGroups]
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

    def groups(Long id) {
        if (id) {
            render view: 'group', model: [group: sportProgramService.getGroup(id)]
            return
        }
        render view: 'groups', model: [groups: sportProgramService.listGroup()]
    }
}
