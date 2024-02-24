package ua.lviv.iot.lab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.controller.CountryController;
import ua.lviv.iot.lab4.model.Country;
import ua.lviv.iot.lab4.service.CountryService;

import java.util.List;
import java.util.Optional;

@Service
public class CountryControllerImpl implements CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryControllerImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @Override
    public Optional<Country> findById(String name) {
        return countryService.findById(name);
    }

    @Override
    public int create(Country country) {
        return countryService.create(country);
    }

    @Override
    public int update(String name, Country country) {
        return countryService.update(name, country);
    }

    @Override
    public int delete(String name) {
        return countryService.delete(name);
    }
}
