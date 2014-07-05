package com.fitupness.domain

class Sportsman {

    Profile profile

    Trainer trainer

    static constraints = {
        trainer nullable: true
    }

    static mapping = {

    }
}
