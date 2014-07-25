package com.fitupness.domain

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Address)
@Mock([Country, City, Address])
class AddressSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "create Address"() {

        when:
        new Address(
                country: new Country(country: 'UA'),
                city: new City(city: 'ZL')
        ).save()

        then:
        Address.list().size() > 0

    }

    def "create Address2"() {
        mockForConstraintsTests(Address)

        when:
        def address = new Address()
        address.validate()

        then:
        address.hasErrors() == true
    }

    def "create Address3"() {
        mockForConstraintsTests(Address)

        when:
        def address = new Address()
        address.country = countries
        address.city = cities
        address.validate()

        then:
        address.hasErrors() == !valid

        where:
        countries << [null, new Country(), null, new Country()]
        cities << [null, null, new City(), new City()]
        valid << [false, false, false, true]
    }
}
