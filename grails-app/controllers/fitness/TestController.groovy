package fitness

class TestController {

    def index() {
    render view:'w', model: [x : 4]




    }
    def test(String name){

        def u = new User(name: name)
        u.save(flush: true)
        println u.id

    render User.findWhere(id: 20L).name
    }
}
