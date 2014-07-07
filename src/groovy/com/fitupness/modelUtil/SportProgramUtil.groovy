package com.fitupness.modelUtil

import com.fitupness.domain.SportProgram
import com.fitupness.domain.SportProgramTemplate

/**
 * Created by light on 7/7/2014.
 */
class SportProgramUtil {

    def SportProgram(SportProgramTemplate template) {
        def sportProgram = new SportProgram(
                name: template.name,
                repetition: template.repetition,
                count: template.count,
                weight: template.weight,
                trainer: template.trainer
        )
        sportProgram
    }
}
