package com.fitupness.domain

class Trainer {

    Profile profile

    static hasMany = [sportsmans                : Sportsman,
                      sportPrograms             : SportProgram,
                      sportProgramGroups        : SportProgramGroup,
                      sportProgramTemplates     : SportProgramTemplate,
                      sportProgramTemplateGroups: SportProgramTemplateGroup]

    static constraints = {
    }
}