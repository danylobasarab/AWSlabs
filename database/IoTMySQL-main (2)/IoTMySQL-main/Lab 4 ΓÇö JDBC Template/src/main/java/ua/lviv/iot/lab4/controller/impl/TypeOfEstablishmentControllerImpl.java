package ua.lviv.iot.lab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.controller.TypeOfEstablishmentController;
import ua.lviv.iot.lab4.model.TypeOfEstablishment;
import ua.lviv.iot.lab4.service.TypeOfEstablishmentService;

import java.util.List;
import java.util.Optional;

@Service
public class TypeOfEstablishmentControllerImpl implements TypeOfEstablishmentController {
    private final TypeOfEstablishmentService typeOfEstablishmentService;

    @Autowired
    public TypeOfEstablishmentControllerImpl(TypeOfEstablishmentService typeOfEstablishmentService) {
        this.typeOfEstablishmentService = typeOfEstablishmentService;
    }

    @Override
    public List<TypeOfEstablishment> findAll() {
        return typeOfEstablishmentService.findAll();
    }

    @Override
    public Optional<TypeOfEstablishment> findById(Integer id) {
        return typeOfEstablishmentService.findById(id);
    }

    @Override
    public int create(TypeOfEstablishment typeOfEstablishment) {
        return typeOfEstablishmentService.create(typeOfEstablishment);
    }

    @Override
    public int update(Integer id, TypeOfEstablishment typeOfEstablishment) {
        return typeOfEstablishmentService.update(id, typeOfEstablishment);
    }

    @Override
    public int delete(Integer id) {
        return typeOfEstablishmentService.delete(id);
    }
}
