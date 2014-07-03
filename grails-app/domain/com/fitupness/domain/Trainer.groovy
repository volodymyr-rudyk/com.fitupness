package com.fitupness.domain

class Trainer {

    Profile profile
    Rating rating

    static hasMany = [sportsmans: Sportsman]

    static constraints = {
    }
}
