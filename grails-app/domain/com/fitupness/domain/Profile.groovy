package com.fitupness.domain

class Profile {

    String firstname
    String lastname
    String phone

    static belongsTo = [User]
    /* ..... */

    static constraints = {
    }
}
