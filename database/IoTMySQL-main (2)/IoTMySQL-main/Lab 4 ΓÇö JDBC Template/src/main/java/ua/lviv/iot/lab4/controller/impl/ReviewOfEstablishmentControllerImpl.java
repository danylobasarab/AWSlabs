package ua.lviv.iot.lab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.controller.ReviewOfEstablishmentController;
import ua.lviv.iot.lab4.model.ReviewOfEstablishment;
import ua.lviv.iot.lab4.service.ReviewOfEstablishmentService;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewOfEstablishmentControllerImpl implements ReviewOfEstablishmentController {
    private final ReviewOfEstablishmentService reviewOfEstablishmentService;

    @Autowired
    public ReviewOfEstablishmentControllerImpl(ReviewOfEstablishmentService reviewOfEstablishmentService) {
        this.reviewOfEstablishmentService = reviewOfEstablishmentService;
    }

    @Override
    public List<ReviewOfEstablishment> findAll() {
        return reviewOfEstablishmentService.findAll();
    }

    @Override
    public Optional<ReviewOfEstablishment> findById(Integer id) {
        return reviewOfEstablishmentService.findById(id);
    }

    @Override
    public int create(ReviewOfEstablishment id) {
        return reviewOfEstablishmentService.create(id);
    }

    @Override
    public int update(Integer id, ReviewOfEstablishment reviewOfEstablishment) {
        return reviewOfEstablishmentService.update(id, reviewOfEstablishment);
    }

    @Override
    public int delete(Integer id) {
        return reviewOfEstablishmentService.delete(id);
    }
}
