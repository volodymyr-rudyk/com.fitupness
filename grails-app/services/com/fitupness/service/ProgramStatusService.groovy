package com.fitupness.service

import com.fitupness.domain.ProgramStatus
import grails.transaction.Transactional

@Transactional
class ProgramStatusService {

    public static final String RUNNING = 'running'
    public static final String STOP = 'stop'
    public static final String DONE = 'done'
    public static final String SUSPEND = 'SUSPEND'

    def init() {
        def psRunning = new ProgramStatus(status: RUNNING)
        psRunning.save()
        def psDone = new ProgramStatus(status: DONE)
        psDone.save()
        def psStop = new ProgramStatus(status: STOP)
        psStop.save()
        def psSuspend = new ProgramStatus(status: SUSPEND)
        psSuspend.save()
    }
}
