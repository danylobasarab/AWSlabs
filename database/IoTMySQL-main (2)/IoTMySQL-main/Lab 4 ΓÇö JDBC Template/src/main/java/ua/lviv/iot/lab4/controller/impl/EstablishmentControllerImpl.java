package ua.lviv.iot.lab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.controller.EstablishmentController;
import ua.lviv.iot.lab4.model.Establishment;
import ua.lviv.iot.lab4.service.EstablishmentService;

import java.util.List;
import java.util.Optional;

@Service
public class EstablishmentControllerImpl implements EstablishmentController {
    private final EstablishmentService establishmentService;

    @Autowired
    public EstablishmentControllerImpl(EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }

    @Override
    public Optional<Establishment> findByName(String name) {
        return establishmentService.findByName(name);
    }

    @Override
    public List<Establishment> findAll() {
        return establishmentService.findAll();
    }

    @Override
    public Optional<Establishment> findById(Integer id) {
        return establishmentService.findById(id);
    }

    @Override
    public int create(Establishment establishment) {
        return establishmentService.create(establishment);
    }

    @Override
    public int update(Integer id, Establishment establishment) {
        return establishmentService.update(id, establishment);
    }

    @Override
    public int delete(Integer id) {
        return establishmentService.delete(id);
    }
}
