package com.fitupness.domain

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(City)
class CitySpec extends Specification {

    def setup() {
        mockDomain(City)
    }

    def cleanup() {
    }


    def "validate constrains city"() {
        setup()

        when:
        def city = new City()
        city.validate()
        then:
        city.hasErrors()

        when:
        city = new City(city: cityName)
        city.validate()
        then:
        city.hasErrors() == false

        where:
        cityName = 'Lviv'
    }

    def "validate unique city"() {
        setup()

        when:
        def city = new City(city: cityName)
        city.save(flush: true)
        then:
        city.hasErrors() == false

        when:
        def city2 = new City(city: cityName)
        city2.save(flush: true)
        then:
        city2.hasErrors()

        where:
        cityName = 'Lviv'
    }

    def "create city domain"() {
        setup()

        when: 'creating model city'
        def p = new City(city: cityName)
        p.save(flush: true)

        then: 'city list size > 0'
        City.list().size() > 0

        when: 'get city'
        def c = City.where {
            city == cityName
        }.get()

        then: '#cityName must exist'
        c != null

        where:
        cityName = 'Lviv'
    }

    def "remove city domain"() {
        setup()

        when: 'creating model city'
        def p = new City(city: cityName)
        p.save(flush: true)
        p.delete(flush: true)

        then: 'city must be null'
        City.findByCity(cityName) == null

        where:
        cityName = 'Lviv'
    }

    def "test null constraint"() {

        mockDomain(City)

        when:
        new City().save()

        then:
        City.count() == 0
    }

    def "test empty constraint"() {

        mockDomain(City)

        when:
        new City(city: '').save()

        then:
        City.count() == 0
    }

}
