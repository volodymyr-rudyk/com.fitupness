package com.fitupness.domain

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Country)
class CountrySpec extends Specification {

    def setup() {
        mockDomain(Country)
    }

    def cleanup() {
    }


    def "validate constrains country"() {
        setup()

        when:
        def c = new Country()
        c.validate()
        then:
        c.hasErrors()

        when:
        c = new Country(country: country)
        c.validate()
        then:
        c.hasErrors() == false

        where:
        country = 'Ukraine'
    }

    def "validate unique country"() {
        setup()

        when:
        def c = new Country(country: country)
        c.save(flush: true)
        then:
        c.hasErrors() == false

        when:
        def c2 = new Country(country: country)
        c2.save(flush: true)
        then:
        c2.hasErrors()

        where:
        country = 'Ukraine'
    }

    def "create country domain"() {
        setup()

        when: 'creating model country'
        def c = new Country(country: country)
        c.save(flush: true)

        then: 'city list size > 0'
        Country.list().size() > 0

        when: 'get country'
        def c1 = Country.where {
            country == country
        }.get()

        then: '#country must exist'
        c1 != null

        where:
        country = 'Ukraine'
    }

    def "remove country domain"() {
        setup()

        when: 'creating model city'
        def c = new Country(country: country)
        c.save(flush: true)
        c.delete(flush: true)

        then: 'country must be null'
        Country.findByCountry(country) == null

        where:
        country = 'Ukraine'
    }

    def "test null constraint"() {
        setup()

        when:
        new Country().save()

        then:
        Country.count() == 0
    }

    def "test empty constraint"() {
        setup()

        when:
        new Country(country: '').save()

        then:
        Country.count() == 0
    }
}
