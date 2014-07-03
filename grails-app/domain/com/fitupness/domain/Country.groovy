package com.fitupness.domain

class Country {

    String country

    static constraints = {
        country nullable: false, blank: false, unique: true
    }
}
