package ua.lviv.iot.lab4.controller;

import ua.lviv.iot.lab4.model.InformationAboutOwner;

import java.util.Optional;

public interface InformationAboutOwnerController extends GeneralController<InformationAboutOwner, Integer> {
    Optional<InformationAboutOwner> findByName(String name);
}
