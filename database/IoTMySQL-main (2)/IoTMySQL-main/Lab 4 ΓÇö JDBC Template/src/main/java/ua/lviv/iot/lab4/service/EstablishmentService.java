package ua.lviv.iot.lab4.service;

import ua.lviv.iot.lab4.model.Establishment;

import java.util.Optional;

public interface EstablishmentService extends GeneralService<Establishment, Integer>{
    Optional<Establishment> findByName(String name);
}
