package ua.lviv.iot.lab4.service;

import ua.lviv.iot.lab4.model.Street;

import java.util.Optional;

public interface StreetService extends GeneralService<Street, Integer> {
    Optional<Street> findByName(String name);
}
