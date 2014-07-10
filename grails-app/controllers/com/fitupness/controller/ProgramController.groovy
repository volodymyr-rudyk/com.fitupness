package com.fitupness.controller

import com.fitupness.domain.SportProgram
import com.fitupness.domain.SportProgramStatus
import com.fitupness.domain.Sportsman

class ProgramController {

    def profileService

    def sportProgramService

    def index() {

        [programs : profileService.trainer.sportPrograms,
         groups   : profileService.trainer.sportProgramGroups,
         templates: profileService.trainer.sportProgramTemplates]
    }

    def create() {
        sportProgramService.addProgram(params)

        redirect action: 'index'
    }

    def delete() {
        sportProgramService.deleteProgram(params.id)
        redirect action: 'index'
    }

    def list() {

        def p = profileService.trainer.sportPrograms

        render(contentType: "text/json", {
            programs = array {
                p.each { pp ->
                    program(id: pp.id, name: pp.name)
                }
            }
        })
    }

    def update() {

    }

    def send(Long idProgram, Long idSportsman) {
        def sportProgram = profileService.trainer.sportPrograms.find { sp ->
            sp.id == idProgram
        }

        if (sportProgram) {
            sportProgram.runner = Sportsman.read(idSportsman)
            sportProgram.save(flush: true)
        }
        redirect action: 'index'
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

    def programStatus(Long idProgram, Long idStatus) {
        def program = SportProgram.get(idProgram)
        def status = SportProgramStatus.get(idStatus)
        if (program) {
            program.status = status
            program.save(flush: true)
        }
        render status.status

    }
}
