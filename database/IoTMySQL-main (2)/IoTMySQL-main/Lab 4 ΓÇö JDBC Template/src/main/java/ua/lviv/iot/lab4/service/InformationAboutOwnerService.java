package ua.lviv.iot.lab4.service;

import ua.lviv.iot.lab4.model.InformationAboutOwner;

import java.util.Optional;

public interface InformationAboutOwnerService extends GeneralService<InformationAboutOwner, Integer>{
    Optional<InformationAboutOwner> findByName(String name);
}
