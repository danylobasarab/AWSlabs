package ua.lviv.iot.lab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.controller.CityController;
import ua.lviv.iot.lab4.model.City;
import ua.lviv.iot.lab4.service.CityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityControllerImpl implements CityController {
    private final CityService cityService;

    @Autowired
    public CityControllerImpl(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public Optional<City> findByName(String name) {
        return cityService.findByName(name);
    }

    @Override
    public List<City> findAll() {
        return cityService.findAll();
    }

    @Override
    public Optional<City> findById(Integer id) {
        return cityService.findById(id);
    }

    @Override
    public int create(City city) {
        return cityService.create(city);
    }

    @Override
    public int update(Integer id, City city) {
        return cityService.update(id, city);
    }

    @Override
    public int delete(Integer id) {
        return cityService.delete(id);
    }
}
