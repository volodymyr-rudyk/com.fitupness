package com.fitupness.domain

class Address {

    Country country

    City city

    static belongsTo = Profile

    static constraints = {
    }
}
