package com.fitupness.domain

class SportProgram {

    String name
    int repetition
    int count
    int weight

    SportProgramType sportProgramType

    static hasMany = [groups: SportProgramGroup]

    static belongsTo = [trainer: Trainer]

    static constraints = {
        sportProgramType nullable: true
    }
}
