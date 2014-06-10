import com.fitupness.domain.Role

class BootStrap {

    def profileTypeService
    def programStatusService

    def init = { servletContext ->

//        def psRunning = new ProgramStatus(status: 'running')
//        psRunning.save()
//        def psDone = new ProgramStatus(status: 'done')
//        psDone.save()
//        def psStop = new ProgramStatus(status: 'stop')
//        psStop.save()
//        def psSuspend = new ProgramStatus(status: 'suspend')
//        psSuspend.save()

        programStatusService.init()
        profileTypeService.init()
//        def sportsmanType = new ProfileType(type: 'sportsman')
//        sportsmanType.save(flush: true)
//        def trainerType = new ProfileType(type: 'trainer')
//        trainerType.save(flush: true)

        def roleUser = new Role(authority: "ROLE_SPORTSMAN")
        roleUser.save()
        def roleAdmin = new Role(authority: "ROLE_ADMIN")
        roleAdmin.save()
        def roleTrainer = new Role(authority: "ROLE_TRAINER")
        roleTrainer.save()

//        def user = new User(username: 'user@gmail.com', password: '123456',
//                profile: new Profile(firstname : 'user', lastname : 'user_lastnae', phone: '12300000',
//                profileType: profileTypeService.getSportsmanType()))
//        user.save(flush: true)
//
//        def admin = new User(username: 'admin@gmail.com', password: '123456',
//                profile: new Profile(firstname : 'admin', lastname : 'admin_lastnae', phone: '11111111111',
//                profileType: profileTypeService.getSportsmanType()))
//        admin.save(flush: true)
//
//        def trainer = new User(username: 'trainer@gmail.com', password: '123456',
//                profile: new Profile(firstname : 'trainer', lastname : 'trainer_lastnae', phone: '555555555',
//                profileType: profileTypeService.getTrainerType()))
//        trainer.save(flush: true)
//
//        UserRole.create(user, roleUser)
//        UserRole.create(admin, roleAdmin)
//        UserRole.create(trainer, roleTrainer)

    }
    def destroy = {
    }
}
