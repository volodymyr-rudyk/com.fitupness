package com.fitupness.domain

class SportProgram {

    String name
    int repetition
    int count
    int weight

    Profile profile
    SportProgramType sportProgramType

    static hasMany = [groups: SpGroup/*,
                      profiles: Profile*/]

    static belongsTo = [Profile]

    static constraints = {
        sportProgramType nullable: true
    }
}
