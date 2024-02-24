package ua.lviv.iot.lab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.ReviewOfEstablishmentDAO;
import ua.lviv.iot.lab4.model.ReviewOfEstablishment;
import ua.lviv.iot.lab4.service.ReviewOfEstablishmentService;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewOfEstablishmentServiceImpl implements ReviewOfEstablishmentService {
    private final ReviewOfEstablishmentDAO reviewOfEstablishmentDAO;

    @Autowired
    public ReviewOfEstablishmentServiceImpl(ReviewOfEstablishmentDAO reviewOfEstablishmentDAO) {
        this.reviewOfEstablishmentDAO = reviewOfEstablishmentDAO;
    }

    @Override
    public List<ReviewOfEstablishment> findAll() {
        return reviewOfEstablishmentDAO.findAll();
    }

    @Override
    public Optional<ReviewOfEstablishment> findById(Integer id) {
        return reviewOfEstablishmentDAO.findById(id);
    }

    @Override
    public int create(ReviewOfEstablishment id) {
        return reviewOfEstablishmentDAO.create(id);
    }

    @Override
    public int update(Integer id, ReviewOfEstablishment reviewOfEstablishment) {
        return reviewOfEstablishmentDAO.update(id, reviewOfEstablishment);
    }

    @Override
    public int delete(Integer id) {
        return reviewOfEstablishmentDAO.delete(id);
    }
}
