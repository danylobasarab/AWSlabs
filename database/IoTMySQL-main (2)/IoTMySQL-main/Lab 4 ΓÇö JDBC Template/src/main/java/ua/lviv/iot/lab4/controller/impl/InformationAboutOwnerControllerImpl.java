package ua.lviv.iot.lab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.controller.InformationAboutOwnerController;
import ua.lviv.iot.lab4.model.InformationAboutOwner;
import ua.lviv.iot.lab4.service.InformationAboutOwnerService;

import java.util.List;
import java.util.Optional;

@Service
public class InformationAboutOwnerControllerImpl implements InformationAboutOwnerController {
    private final InformationAboutOwnerService informationAboutOwnerService;

    @Autowired
    public InformationAboutOwnerControllerImpl(InformationAboutOwnerService informationAboutOwnerService) {
        this.informationAboutOwnerService = informationAboutOwnerService;
    }

    @Override
    public List<InformationAboutOwner> findAll() {
        return informationAboutOwnerService.findAll();
    }

    @Override
    public Optional<InformationAboutOwner> findById(Integer id) {
        return informationAboutOwnerService.findById(id);
    }

    @Override
    public int create(InformationAboutOwner informationAboutOwner) {
        return informationAboutOwnerService.create(informationAboutOwner);
    }

    @Override
    public int update(Integer id, InformationAboutOwner informationAboutOwner) {
        return informationAboutOwnerService.update(id, informationAboutOwner);
    }

    @Override
    public int delete(Integer id) {
        return informationAboutOwnerService.delete(id);
    }

    @Override
    public Optional<InformationAboutOwner> findByName(String name) {
        return informationAboutOwnerService.findByName(name);
    }
}
