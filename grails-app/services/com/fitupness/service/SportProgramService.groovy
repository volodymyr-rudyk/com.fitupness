package com.fitupness.service

import com.fitupness.domain.SportProgram
import com.fitupness.domain.SportProgramGroup
import grails.transaction.Transactional

@Transactional
class SportProgramService {

    def profileService

    def addProgram(params) {
        def trainer = profileService.trainer
        def sportProgram = new SportProgram(params)
        trainer.addToSportPrograms(sportProgram)

        def sportProgramGroup = SportProgramGroup.get(params.group)
        if (sportProgramGroup) {
            sportProgramGroup.addToSportPrograms(sportProgram)
        }
    }

    def deleteProgram(id) {
        def sportProgram = SportProgram.get(id)
        if (sportProgram) {
            def trainer = profileService.trainer
            if (trainer.sportPrograms.contains(sportProgram)) {
                sportProgram.groups.clear()
                trainer.sportPrograms.remove(sportProgram)
                sportProgram.delete(flush: true)
            }
        }
    }

    def addGroup(String name) {
        def sportProgramGroup = new SportProgramGroup(name: name, trainer: profileService.trainer)
        sportProgramGroup.save()
        sportProgramGroup
    }

    def deleteGroup(id) {
        def sportProgramGroup = SportProgramGroup.get(id)
        if (sportProgramGroup) {
            if (sportProgramGroup.trainer == profileService.trainer) {
                println sportProgramGroup.sportPrograms*.name
                sportProgramGroup.sportPrograms.each { sp ->
                    sp.delete(flush: true)
                }
                sportProgramGroup.delete(flush: true)
            }
        }
    }

    def listGroup() {
        def groups = SportProgramGroup.where {
            trainer == profileService.trainer
        }.list()
        groups
    }

    def getGroup(id) {
        def groups = SportProgramGroup.get(id)
        groups
    }
}
