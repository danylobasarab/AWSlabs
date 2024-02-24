package ua.lviv.iot.lab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.InformationAboutOwnerDAO;
import ua.lviv.iot.lab4.model.InformationAboutOwner;
import ua.lviv.iot.lab4.service.InformationAboutOwnerService;

import java.util.List;
import java.util.Optional;

@Service
public class InformationAboutOwnerServiceImpl implements InformationAboutOwnerService {
    private final InformationAboutOwnerDAO informationAboutOwnerDAO;

    @Autowired
    public InformationAboutOwnerServiceImpl(InformationAboutOwnerDAO informationAboutOwnerDAO) {
        this.informationAboutOwnerDAO = informationAboutOwnerDAO;
    }

    @Override
    public List<InformationAboutOwner> findAll() {
        return informationAboutOwnerDAO.findAll();
    }

    @Override
    public Optional<InformationAboutOwner> findById(Integer id) {
        return informationAboutOwnerDAO.findById(id);
    }

    @Override
    public int create(InformationAboutOwner informationAboutOwner) {
        return informationAboutOwnerDAO.create(informationAboutOwner);
    }

    @Override
    public int update(Integer id, InformationAboutOwner informationAboutOwner) {
        return informationAboutOwnerDAO.update(id, informationAboutOwner);
    }

    @Override
    public int delete(Integer id) {
        return informationAboutOwnerDAO.delete(id);
    }

    @Override
    public Optional<InformationAboutOwner> findByName(String name) {
        return informationAboutOwnerDAO.findByName(name);
    }
}
