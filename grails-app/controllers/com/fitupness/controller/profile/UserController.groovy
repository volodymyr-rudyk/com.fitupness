package com.fitupness.controller.profile

import com.fitupness.domain.SportProgram
import com.fitupness.domain.SportProgramStatus
import com.fitupness.domain.Trainer
import com.fitupness.service.ProgramStatusService
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_SPORTSMAN'])
class UserController {

    def claimService

    def profileService

    def index() {
        def sportsman = profileService.sportsman
        def tr = Trainer.list()
        [sportsman: sportsman, trainers: tr]
    }

    def trainerList() {
        def claim = claimService.myClaim()
        def sportsman = profileService.sportsman

        [sportsman: sportsman,
         trainers : Trainer.list(),
         claim    : claim]
    }

    def addClaim() {
        claimService.create(params.to)
        redirect action: 'index'
    }

    def programs() {
        def trainer = profileService.sportsman.trainer
        def sportPrograms = SportProgram.findAllByTrainerAndRunner(trainer, profileService.sportsman)
        def sportProgramsToDo = sportPrograms.findAll {
            sp -> sp.status?.status != ProgramStatusService.DONE
        }
        [sportPrograms: sportProgramsToDo]
    }

    def history() {
        def trainer = profileService.sportsman.trainer
        def sportPrograms = SportProgram.findAllByTrainerAndRunnerAndStatus(trainer, profileService.sportsman, SportProgramStatus.get(2))
        [sportPrograms: sportPrograms]
    }

}
