package com.fitupness.domain

class Rating {

    int points

    static belongsTo = [profile: Profile]

    static constraints = {
    }
}
