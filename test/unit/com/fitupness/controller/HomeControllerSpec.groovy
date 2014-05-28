package com.fitupness.controller

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(HomeController)
class HomeControllerSpec extends Specification {

    HomeController homeController
    def setup() {
        homeController = new HomeController()
    }

    def cleanup() {
    }

    void "test something"() {
        homeController.index()
        assertEquals(homeController.modelAndView.viewName, 'index')
    }
}
