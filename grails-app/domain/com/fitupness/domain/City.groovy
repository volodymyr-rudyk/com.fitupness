package com.fitupness.domain

class City {

    String city

    static constraints = {
        city nullable: false, blank: false, unique: true
    }
}
