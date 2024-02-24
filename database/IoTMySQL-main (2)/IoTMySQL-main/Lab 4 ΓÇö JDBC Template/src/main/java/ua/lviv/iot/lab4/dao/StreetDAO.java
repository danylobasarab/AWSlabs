package ua.lviv.iot.lab4.dao;

import ua.lviv.iot.lab4.model.Street;

import java.util.Optional;

public interface StreetDAO extends GeneralDAO<Street, Integer>{
    Optional<Street> findByName(String name);
}
