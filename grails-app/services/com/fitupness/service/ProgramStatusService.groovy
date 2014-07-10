package com.fitupness.service

import com.fitupness.domain.SportProgramStatus
import grails.transaction.Transactional

@Transactional
class ProgramStatusService {

    public static final String RUNNING = 'running'
    public static final String STOPPED = 'stopped'
    public static final String DONE = 'done'
    public static final String SUSPENDED = 'suspended'

    def init() {
        def psRunning = new SportProgramStatus(status: RUNNING)
        psRunning.save()
        def psDone = new SportProgramStatus(status: DONE)
        psDone.save()
        def psStop = new SportProgramStatus(status: STOPPED)
        psStop.save()
        def psSuspend = new SportProgramStatus(status: SUSPENDED)
        psSuspend.save()
    }
}
