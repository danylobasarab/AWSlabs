package ua.lviv.iot.lab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.TypeOfEstablishmentDAO;
import ua.lviv.iot.lab4.model.TypeOfEstablishment;
import ua.lviv.iot.lab4.service.TypeOfEstablishmentService;

import java.util.List;
import java.util.Optional;

@Service
public class TypeOfEstablishmentServiceImpl implements TypeOfEstablishmentService {
    private final TypeOfEstablishmentDAO typeOfEstablishmentDAO;

    @Autowired
    public TypeOfEstablishmentServiceImpl(TypeOfEstablishmentDAO typeOfEstablishmentDAO) {
        this.typeOfEstablishmentDAO = typeOfEstablishmentDAO;
    }

    @Override
    public List<TypeOfEstablishment> findAll() {
        return typeOfEstablishmentDAO.findAll();
    }

    @Override
    public Optional<TypeOfEstablishment> findById(Integer id) {
        return typeOfEstablishmentDAO.findById(id);
    }

    @Override
    public int create(TypeOfEstablishment typeOfEstablishment) {
        return typeOfEstablishmentDAO.create(typeOfEstablishment);
    }

    @Override
    public int update(Integer id, TypeOfEstablishment typeOfEstablishment) {
        return typeOfEstablishmentDAO.update(id, typeOfEstablishment);
    }

    @Override
    public int delete(Integer id) {
        return typeOfEstablishmentDAO.delete(id);
    }
}
