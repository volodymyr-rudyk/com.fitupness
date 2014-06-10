package com.fitupness.service

import com.fitupness.domain.ProfileType
import grails.transaction.Transactional

@Transactional
class ProfileTypeService {

    public static final String TYPE_SPORTSMAN = 'sportsman'
    public static final String TYPE_TRAINER = 'trainer'

    def init() {
        def sportsmanType = new ProfileType(type: TYPE_SPORTSMAN)
        sportsmanType.save(flush: true)
        def trainerType = new ProfileType(type: TYPE_TRAINER)
        trainerType.save(flush: true)
    }

    ProfileType get(id) {
        ProfileType.get(id)
    }

    ProfileType getSportsmanType() {
        ProfileType.where {
            type == TYPE_SPORTSMAN
        }.get()
    }

    ProfileType getTrainerType() {
        ProfileType.where {
            type == TYPE_TRAINER
        }.get()
    }
}
