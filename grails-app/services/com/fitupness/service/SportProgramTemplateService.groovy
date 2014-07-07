package com.fitupness.service

import com.fitupness.domain.SportProgramTemplate
import grails.transaction.Transactional

@Transactional
class SportProgramTemplateService {
    def profileService

    def addTemplate(params) {
        def trainer = profileService.trainer
        def sportProgramTemplate = new SportProgramTemplate(params)
        trainer.addToSportProgramTemplates(sportProgramTemplate)

//        def sportProgramTemplateGroup = SportProgramTemplateGroup.get(params.group)
//        if (sportProgramTemplateGroup) {
//            sportProgramTemplateGroup.addToSportPrograms(sportProgramTemplate)
//
//        }
    }

    def getTemplate(id) {
        def template = SportProgramTemplate.get(id)
        if (template.trainer == profileService.trainer)
            return template
        return null
    }

//    def addTemplate(SportProgram sportProgram){
//        def sportProgramTemplate = new SportProgramTemplate()
//        sportProgramTemplate.save(flush: true)
//    }

//    def deleteTemplate(id) {
//        def sportProgramTemplate = SportProgramTemplate.get(id)
//        if (sportProgramTemplate) {
//            def trainer = profileService.trainer
//            if (trainer.sportPrograms.contains(sportProgramTemplate)) {
//                sportProgramTemplate.groups.clear()
//                trainer.sportPrograms.remove(sportProgramTemplate)
//                sportProgramTemplate.delete(flush: true)
//            }
//        }
//    }
//
//    def addGroup(String name) {
//        def sportProgramGroup = new SportProgramTemplateGroup(name: name, trainer: profileService.trainer)
//        sportProgramGroup.save()
//        sportProgramGroup
//    }
//
//    def deleteGroup(id) {
//        def sportProgramGroup = SportProgramGroup.get(id)
//        if (sportProgramGroup) {
//            if (sportProgramGroup.trainer == profileService.trainer) {
//                println sportProgramGroup.sportPrograms*.name
//                sportProgramGroup.sportPrograms.each { sp ->
//                    sp.delete(flush: true)
//                }
//                sportProgramGroup.delete(flush: true)
//            }
//        }
//    }
//
//    def listGroup() {
//        def groups = SportProgramGroup.where {
//            trainer == profileService.trainer
//        }.list()
//        groups
//    }
//
//    def getGroup(id) {
//        def groups = SportProgramGroup.get(id)
//        groups
//    }
}
