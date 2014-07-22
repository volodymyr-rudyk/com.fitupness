package com.fitupness.service

import com.fitupness.domain.SportClub
import grails.transaction.Transactional

@Transactional
class SportClubService {

    def addClub(params) {
        def sportClub = new SportClub()
        sportClub.properties = params

        sportClub.save() != null

    }

    def list() {
        SportClub.list()

    }

}
