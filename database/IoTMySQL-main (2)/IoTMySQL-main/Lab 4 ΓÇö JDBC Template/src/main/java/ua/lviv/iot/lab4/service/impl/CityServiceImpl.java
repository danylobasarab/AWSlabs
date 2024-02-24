package ua.lviv.iot.lab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.CityDAO;
import ua.lviv.iot.lab4.model.City;
import ua.lviv.iot.lab4.service.CityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private final CityDAO cityDAO;

    @Autowired
    public CityServiceImpl(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    public Optional<City> findByName(String name) {
        return cityDAO.findByName(name);
    }

    @Override
    public List<City> findAll() {
        return cityDAO.findAll();
    }

    @Override
    public Optional<City> findById(Integer id) {
        return cityDAO.findById(id);
    }

    @Override
    public int create(City city) {
        return cityDAO.create(city);
    }

    @Override
    public int update(Integer id, City city) {
        return cityDAO.update(id, city);
    }

    @Override
    public int delete(Integer id) {
        return cityDAO.delete(id);
    }
}
