package com.fitupness.domain

import org.apache.commons.lang.builder.HashCodeBuilder

class ProfileSportProgram implements Serializable {

    Profile profile
    SportProgram sportProgram

    boolean equals(other) {
        if (!(other instanceof ProfileSportProgram)) {
            return false
        }

        other.profile?.id == profile?.id &&
                other.sportProgram?.id == sportProgram?.id
    }

    int hashCode() {
        def builder = new HashCodeBuilder()
        if (profile) builder.append(profile.id)
        if (sportProgram) builder.append(sportProgram.id)
        builder.toHashCode()
    }

    static ProfileSportProgram get(long profileId, long sportProgramId) {
        ProfileSportProgram.where {
            profile == Profile.load(profileId) &&
                    sportProgram == SportProgram.load(sportProgramId)
        }.get()
    }

    static boolean exists(long profileId, long sportProgramId) {
        ProfileSportProgram.where {
            profile == Profile.load(profileId) &&
                    sportProgram == SportProgram.load(sportProgramId)
        }.count() > 0
    }

    static ProfileSportProgram create(Profile profile, SportProgram sportProgram, boolean flush = false) {
        def instance = new ProfileSportProgram(profile: profile, sportProgram: sportProgram)
        instance.save(flush: flush, insert: true)
        instance
    }

    static boolean remove(Profile profile, SportProgram sportProgram, boolean flush = false) {
        if (profile == null || sportProgram == null) return false

        int rowCount = ProfileSportProgram.where {
            profile == Profile.load(profile.id) &&
                    SportProgram == SportProgram.load(sportProgram.id)
        }.deleteAll()

        if (flush) {
            ProfileSportProgram.withSession { it.flush() }
        }

        rowCount > 0
    }

    static void removeAll(Profile profile, boolean flush = false) {
        if (profile == null) return

        ProfileSportProgram.where {
            profile == Profile.load(profile.id)
        }.deleteAll()

        if (flush) {
            ProfileSportProgram.withSession { it.flush() }
        }
    }

    static void removeAll(SportProgram sportProgram, boolean flush = false) {
        if (sportProgram == null) return

        ProfileSportProgram.where {
            sportProgram == SportProgram.load(sportProgram.id)
        }.deleteAll()

        if (flush) {
            ProfileSportProgram.withSession { it.flush() }
        }
    }

    static constraints = {
        profile validator: { Profile profile, ProfileSportProgram psp ->
            if (psp.profile == null) return
            boolean existing = false
            ProfileSportProgram.withNewSession {
                existing = ProfileSportProgram.exists(psp.profile.id, profile.id)
            }
            if (existing) {
                return 'profileSportProgram.exists'
            }
        }
    }

    static mapping = {
        id composite: ['profile', 'sportProgram']
        version false
    }
}
