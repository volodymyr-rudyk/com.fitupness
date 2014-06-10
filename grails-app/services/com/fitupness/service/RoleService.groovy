package com.fitupness.service

import com.fitupness.domain.Role
import grails.transaction.Transactional

@Transactional
class RoleService {

    public static final String ROLE_ADMIN = 'ROLE_ADMIN'
    public static final String ROLE_TRAINER = 'ROLE_TRAINER'
    public static final String ROLE_SPORTSMAN = 'ROLE_SPORTSMAN'

    def init() {
        new Role(authority: ROLE_SPORTSMAN).save()
        new Role(authority: ROLE_ADMIN).save()
        new Role(authority: ROLE_TRAINER).save()
    }
}
