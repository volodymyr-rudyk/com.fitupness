package com.fitupness.domain

class Rating {

    int points

    static belongsTo = [Trainer, Sportsman]

    static constraints = {
    }
}
