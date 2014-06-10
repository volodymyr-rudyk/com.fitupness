package com.fitupness.domain

class SportProgram {

    String name
    int repetition
    int count
    int weight

    Profile owner
    SportProgramType sportProgramType

    static hasMany = [groups: SpGroup]

    static constraints = {
        sportProgramType nullable: true
    }
}
