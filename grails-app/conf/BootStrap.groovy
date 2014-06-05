import com.fitupness.domain.Role
import com.fitupness.domain.User
import com.fitupness.domain.UserRole

class BootStrap {

    def init = { servletContext ->
        def roleUser = new Role(authority: "ROLE_USER")
        roleUser.save()
        def roleAdmin = new Role(authority: "ROLE_ADMIN")
        roleAdmin.save()
        def roleTrainer = new Role(authority: "ROLE_TRAINER")
        roleTrainer.save()
        def roleSimple = new Role(authority: "ROLE_SIMPLE")
        roleSimple.save()


        def user = new User(username: 'user@gmail.com', password: '123456')
        user.save()
        def admin = new User(username: 'admin@gmail.com', password: '123456')
        admin.save()
        def trainer = new User(username: 'trainer@gmail.com', password: '123456')
        trainer.save()
        def simple = new User(username: 'simple@gmail.com', password: '123456')
        simple.save()

        UserRole.create(user, roleUser, true)
        UserRole.create(admin, roleAdmin, true)
        UserRole.create(trainer, roleTrainer, true)
        UserRole.create(simple, roleUser)

    }
    def destroy = {
    }
}
