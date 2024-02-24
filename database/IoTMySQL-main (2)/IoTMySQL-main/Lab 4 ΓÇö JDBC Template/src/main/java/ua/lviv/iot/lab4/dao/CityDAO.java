package ua.lviv.iot.lab4.dao;

import ua.lviv.iot.lab4.model.City;

import java.util.Optional;

public interface CityDAO extends GeneralDAO<City, Integer>{
    Optional<City> findByName(String name);
}
