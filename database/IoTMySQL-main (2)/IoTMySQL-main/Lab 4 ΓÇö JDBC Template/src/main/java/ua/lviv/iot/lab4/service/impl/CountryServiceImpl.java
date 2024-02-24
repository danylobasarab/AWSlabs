package ua.lviv.iot.lab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.CountryDAO;
import ua.lviv.iot.lab4.model.Country;
import ua.lviv.iot.lab4.service.CountryService;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryDAO countryDAO;

    @Autowired
    public CountryServiceImpl(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    @Override
    public List<Country> findAll() {
        return countryDAO.findAll();
    }

    @Override
    public Optional<Country> findById(String name) {
        return countryDAO.findById(name);
    }

    @Override
    public int create(Country country) {
        return countryDAO.create(country);
    }

    @Override
    public int update(String name, Country country) {
        return countryDAO.update(name, country);
    }

    @Override
    public int delete(String name) {
        return countryDAO.delete(name);
    }
}
