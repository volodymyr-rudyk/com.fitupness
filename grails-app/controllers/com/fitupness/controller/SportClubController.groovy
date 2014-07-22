package com.fitupness.controller

import com.fitupness.domain.SportClub

class SportClubController {

    static defaultAction = "list"

    def sportClubService

    def index() {
        redirect action: 'list'
    }

    def add() {
        def id = params.id
        if (id) {
            println "${id}"
        }
    }


    def view() {
        def id = params.id
        if (id) {
            render view: 'view', model: [club: SportClub.get(id)]
            return
        }
        redirect action: 'list'
    }

    def addClub() {
        println params

        def result = sportClubService.addClub(params)
        println "add club result esult $result"
        flash.message = "club add $result"
        redirect action: 'view'
    }

    def list() {
        render model: [clubs: SportClub.list()], view: 'list'
    }
}
