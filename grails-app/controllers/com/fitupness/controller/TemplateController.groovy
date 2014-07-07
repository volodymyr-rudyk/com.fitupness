package com.fitupness.controller

class TemplateController {

    def profileService

    def sportProgramTemplateService

    def index() {

        [templates: profileService.trainer.sportProgramTemplates
         /*groups  : profileService.trainer.sportProgramTemlateGroups*/]
    }

    def create() {
        sportProgramTemplateService.addTemplate(params)

        redirect action: 'index'
    }

    def delete() {
        sportProgramTemplateService.deleteTemplate(params.id)
        redirect action: 'index'
    }

    def update() {

    }

    def ajaxGet() {
        println params
        def t = sportProgramTemplateService.getTemplate(params.id)
        render(contentType: "text/json", {
            template(name: t.name,
                    repetition: t.repetition,
                    count: t.count,
                    weight: t.weight)
        })


    }

//    def createGroup() {
//        sportProgramService.addGroup(params.name)
//        redirect action: 'groups'
//    }
//
//    def deleteGroup() {
//        sportProgramService.deleteGroup(params.id)
//        redirect action: 'groups'
//    }
//
//    def groups(Long id) {
//        if (id) {
//            render view: 'group', model: [group: sportProgramService.getGroup(id)]
//            return
//        }
//        render view: 'groups', model: [groups: sportProgramService.listGroup()]
//    }
}
