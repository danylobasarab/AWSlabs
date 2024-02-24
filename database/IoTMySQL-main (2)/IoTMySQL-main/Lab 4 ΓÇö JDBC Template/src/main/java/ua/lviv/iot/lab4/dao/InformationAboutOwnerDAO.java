package ua.lviv.iot.lab4.dao;

import ua.lviv.iot.lab4.model.Establishment;
import ua.lviv.iot.lab4.model.InformationAboutOwner;

import java.util.Optional;

public interface InformationAboutOwnerDAO extends GeneralDAO<InformationAboutOwner, Integer>{
    Optional<InformationAboutOwner> findByName(String name);
}
