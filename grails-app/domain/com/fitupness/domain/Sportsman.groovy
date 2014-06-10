package com.fitupness.domain

class Sportsman {

    Profile profile
    Trainer trainer
    Rating rating

    static constraints = {
        trainer nullable: true
    }

    static mapping = {
        profile lazy: false
        rating lazy: false
    }
}
