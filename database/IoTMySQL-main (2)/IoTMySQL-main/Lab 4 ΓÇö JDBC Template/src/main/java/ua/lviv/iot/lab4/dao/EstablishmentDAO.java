package ua.lviv.iot.lab4.dao;

import ua.lviv.iot.lab4.model.Establishment;

import java.util.Optional;

public interface EstablishmentDAO extends GeneralDAO<Establishment, Integer>{
    Optional<Establishment> findByName(String name);
}
