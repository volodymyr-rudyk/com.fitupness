package com.fitupness.domain

class Body {

    int weight
    int height
    int chest

    static belongsTo = Profile

    static constraints = {
    }
}
