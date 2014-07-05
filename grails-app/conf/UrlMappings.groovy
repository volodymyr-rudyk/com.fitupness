class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

//        "/profile/$id?(.$format)?"{
//            action = 'index'
//            constraints {
//                // apply constraints here
//            }
//        }


        name profileLink: "/profile/$id" {
            controller = 'profile'
            action = 'view'
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/404')
	}
}
