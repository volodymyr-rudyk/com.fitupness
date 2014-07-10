package com.fitupness.domain

class SportProgram {

    String name
    int repetition
    int count
    int weight
    Date dateCreated
    Date lastUpdated

    Sportsman runner
    SportProgramStatus status

    SportProgramType sportProgramType

    SportProgramGroup sportProgramGroup

//    static hasMany = [groups: SportProgramGroup]

    static belongsTo = [trainer: Trainer]

    static constraints = {
        sportProgramType nullable: true
        sportProgramGroup nullable: true
        runner nullable: true
        status nullable: true
    }
}
