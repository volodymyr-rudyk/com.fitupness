package com.fitupness.domain

class SpGroup {

    String name

    Profile profile

    static hasMany = [sportPrograms: SportProgram]
    static belongsTo = [SportProgram]
    static constraints = {
    }
}
