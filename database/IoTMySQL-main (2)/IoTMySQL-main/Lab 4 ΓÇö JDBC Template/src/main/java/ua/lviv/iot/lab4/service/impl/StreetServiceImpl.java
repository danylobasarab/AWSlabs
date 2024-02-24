package ua.lviv.iot.lab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.StreetDAO;
import ua.lviv.iot.lab4.model.Street;
import ua.lviv.iot.lab4.service.StreetService;

import java.util.List;
import java.util.Optional;

@Service
public class StreetServiceImpl implements StreetService {
    private final StreetDAO streetDAO;

    @Autowired
    public StreetServiceImpl(StreetDAO streetDAO) {
        this.streetDAO = streetDAO;
    }

    @Override
    public List<Street> findAll() {
        return streetDAO.findAll();
    }

    @Override
    public Optional<Street> findById(Integer id) {
        return streetDAO.findById(id);
    }

    @Override
    public int create(Street street) {
        return streetDAO.create(street);
    }

    @Override
    public int update(Integer id, Street street) {
        return streetDAO.update(id, street);
    }

    @Override
    public int delete(Integer id) {
        return streetDAO.delete(id);
    }

    @Override
    public Optional<Street> findByName(String name) {
        return streetDAO.findByName(name);
    }
}
