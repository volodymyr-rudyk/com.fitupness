package com.fitupness.domain

class SportProgramTemplate {

    String name
    int repetition
    int count
    int weight

    static belongsTo = [trainer: Trainer]

    static constraints = {

    }
}
