package com.fitupness.controller

import com.fitupness.domain.SportProgram
import com.fitupness.domain.SportProgramStatus
import com.fitupness.domain.Sportsman

class ProgramController {

    def profileService

    def sportProgramService

    def sportProgramTemplateService

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

    // Templates block

    def templates() {
        render view: 'templates', model: [templates: profileService.trainer.sportProgramTemplates]
    }

    def createTemplate() {
        sportProgramTemplateService.addTemplate(params)
        redirect action: 'templates'
    }

    def deleteTemplate() {
        sportProgramTemplateService.deleteTemplate(params.id)
        redirect action: 'templates'
    }

    def updateTemplate() {

    }

    def ajaxGetTemplate() {
        println params
        def t = sportProgramTemplateService.getTemplate(params.id)
        render(contentType: "text/json", {
            template(name: t.name,
                    repetition: t.repetition,
                    count: t.count,
                    weight: t.weight)
        })


    }

//    def createTemplateGroup() {
//        sportProgramService.addGroup(params.name)
//        redirect action: 'groups'
//    }
//
//    def deleteTemplateGroup() {
//        sportProgramService.deleteGroup(params.id)
//        redirect action: 'groups'
//    }
//
//    def templateGroups(Long id) {
//        if (id) {
//            render view: 'group', model: [group: sportProgramService.getGroup(id)]
//            return
//        }
//        render view: 'groups', model: [groups: sportProgramService.listGroup()]
//    }
}
