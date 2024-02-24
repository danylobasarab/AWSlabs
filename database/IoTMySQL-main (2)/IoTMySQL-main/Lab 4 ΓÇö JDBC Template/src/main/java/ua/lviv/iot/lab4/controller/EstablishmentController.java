package ua.lviv.iot.lab4.controller;

import ua.lviv.iot.lab4.model.Establishment;

import java.util.Optional;

public interface EstablishmentController extends GeneralController<Establishment, Integer> {
    Optional<Establishment> findByName(String name);
}
