import com.fitupness.domain.Role

class BootStrap {

    def profileTypeService
    def programStatusService

    def authService

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

//        def sportsman = new User(username: 'vova.rudyk@gmail.com', password: '123456',
//                profile: new Profile(firstname : 'Vova', lastname : 'Rudyk', phone: '0631788565',
//                profileType: profileTypeService.getSportsmanType()))
//        sportsman.save(flush: true)

//        def admin = new User(username: 'admin@gmail.com', password: '123456',
//                profile: new Profile(firstname : 'admin', lastname : 'admin_lastnae', phone: '11111111111',
//                profileType: profileTypeService.getSportsmanType()))
//        admin.save(flush: true)

//        def trainer = new User(username: 'trainer@gmail.com', password: '123456',
//                profile: new Profile(firstname : 'trainer', lastname : 'trainer_lastnae', phone: '555555555',
//                profileType: profileTypeService.getTrainerType()))
//        trainer.save(flush: true)

//        UserRole.create(sportsman, roleUser)
//        UserRole.create(admin, roleAdmin)
//        UserRole.create(trainer, roleTrainer)


        def p1 = [phone: '00000000', username: 'user@gmail.com', lastname: 'UserLast', firstname: 'UserFirst', type: '1', password: '123456']

        authService.signup(p1)

        def p2 = [phone: '00000000', username: 'trainer@gmail.com', lastname: 'TrainerLast', firstname: 'TrainerFirst', type: '2', password: '123456']

        authService.signup(p2)


    }
    def destroy = {
    }
}
