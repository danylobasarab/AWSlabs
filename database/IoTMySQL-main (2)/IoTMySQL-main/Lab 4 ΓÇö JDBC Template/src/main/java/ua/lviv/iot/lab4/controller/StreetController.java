package ua.lviv.iot.lab4.controller;

import ua.lviv.iot.lab4.model.Street;

import java.util.Optional;

public interface StreetController extends GeneralController<Street, Integer> {
    Optional<Street> findByName(String name);
}
