package ua.lviv.iot.lab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.controller.StreetController;
import ua.lviv.iot.lab4.model.Street;
import ua.lviv.iot.lab4.service.StreetService;

import java.util.List;
import java.util.Optional;

@Service
public class StreetControllerImpl implements StreetController {
    private final StreetService streetService;

    @Autowired
    public StreetControllerImpl(StreetService streetService) {
        this.streetService = streetService;
    }

    @Override
    public List<Street> findAll() {
        return streetService.findAll();
    }

    @Override
    public Optional<Street> findById(Integer id) {
        return streetService.findById(id);
    }

    @Override
    public int create(Street street) {
        return streetService.create(street);
    }

    @Override
    public int update(Integer id, Street street) {
        return streetService.update(id, street);
    }

    @Override
    public int delete(Integer id) {
        return streetService.delete(id);
    }

    @Override
    public Optional<Street> findByName(String name) {
        return streetService.findByName(name);
    }
}
