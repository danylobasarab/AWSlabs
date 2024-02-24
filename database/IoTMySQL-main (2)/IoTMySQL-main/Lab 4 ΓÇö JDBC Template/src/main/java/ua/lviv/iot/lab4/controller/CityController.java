package ua.lviv.iot.lab4.controller;

import ua.lviv.iot.lab4.model.City;

import java.util.Optional;

public interface CityController extends GeneralController<City, Integer> {
    Optional<City> findByName(String name);
}
