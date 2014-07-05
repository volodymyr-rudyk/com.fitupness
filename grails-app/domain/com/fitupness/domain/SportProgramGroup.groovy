package com.fitupness.domain

class SportProgramGroup {

    String name

    Trainer trainer

    static hasMany = [sportPrograms: SportProgram]
    static belongsTo = [SportProgram]
    static constraints = {
    }
}
