package com.fitupness.domain

class Profile {

    String firstname
    String lastname
    String phone

    ProfileType profileType
    Address address
    Body body

    static belongsTo = User

    static constraints = {
//        phone nullable: true
        address nullable: true
        body nullable: true
    }
}
