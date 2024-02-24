package ua.lviv.iot.lab4.service;

import ua.lviv.iot.lab4.model.City;

import java.util.Optional;

public interface CityService extends GeneralService<City, Integer>{
    Optional<City> findByName(String name);
}
