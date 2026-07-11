package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.repository.CountryRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        // @Transactional allows Spring to manage the Hibernate session and transaction.
        // Repository operations are executed inside the transaction.
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + countryCode);
        }
        Country country = result.get();
        return country;
    }

    @Transactional
    public void addCountry(Country country) {
        // save() inserts a new entity into the database.
        // Spring Data JPA automatically handles persistence.
        countryRepository.save(country);
    }

    @Transactional
    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Transactional(readOnly = true)
    public List<Country> getCountriesByName(String name) {
        return countryRepository.findByNameContaining(name);
    }

    @Transactional(readOnly = true)
    public List<Country> findCountriesContaining(String text) {
        return countryRepository.findByNameContaining(text);
    }

    @Transactional(readOnly = true)
    public List<Country> findCountriesContainingSorted(String text) {
        return countryRepository.findByNameContainingOrderByNameAsc(text);
    }

    @Transactional(readOnly = true)
    public List<Country> findCountriesStartingWith(String alphabet) {
        return countryRepository.findByNameStartingWith(alphabet);
    }

    @Transactional(readOnly = true)
    public Country getCountry(String code) {
        try {
            return findCountryByCode(code);
        } catch (CountryNotFoundException exception) {
            return null;
        }
    }
}