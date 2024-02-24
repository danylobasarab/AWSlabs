package ua.lviv.iot.lab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.EstablishmentDAO;
import ua.lviv.iot.lab4.model.Establishment;
import ua.lviv.iot.lab4.service.EstablishmentService;

import java.util.List;
import java.util.Optional;

@Service
public class EstablishmentServiceImpl implements EstablishmentService {
    private final EstablishmentDAO establishmentDAO;

    @Autowired
    public EstablishmentServiceImpl(EstablishmentDAO establishmentDAO) {
        this.establishmentDAO = establishmentDAO;
    }

    @Override
    public Optional<Establishment> findByName(String name) {
        return establishmentDAO.findByName(name);
    }

    @Override
    public List<Establishment> findAll() {
        return establishmentDAO.findAll();
    }

    @Override
    public Optional<Establishment> findById(Integer id) {
        return establishmentDAO.findById(id);
    }

    @Override
    public int create(Establishment establishment) {
        return establishmentDAO.create(establishment);
    }

    @Override
    public int update(Integer id, Establishment establishment) {
        return establishmentDAO.update(id, establishment);
    }

    @Override
    public int delete(Integer id) {
        return establishmentDAO.delete(id);
    }
}
