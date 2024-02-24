package ua.lviv.iot.lab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.ReviewOfEstablishmentDAO;
import ua.lviv.iot.lab4.model.ReviewOfEstablishment;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ReviewOfEstablishmentDAOImpl implements ReviewOfEstablishmentDAO {
    private static final String FIND_ALL = "SELECT * FROM review_of_establishment";
    private static final String CREATE = "INSERT review_of_establishment(review, user_account_nickname) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE review_of_establishment SET review=?, user_account_nickname=? WHERE id=?";
    private static final String DELETE = "DELETE FROM review_of_establishment WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM review_of_establishment WHERE id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReviewOfEstablishmentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ReviewOfEstablishment> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(ReviewOfEstablishment.class));
    }

    @Override
    public Optional<ReviewOfEstablishment> findById(Integer id) {
        Optional<ReviewOfEstablishment> reviewOfEstablishment;
        try {
            reviewOfEstablishment = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(ReviewOfEstablishment.class), id));
        } catch (EmptyResultDataAccessException e) {
            reviewOfEstablishment = Optional.empty();
        }
        return reviewOfEstablishment;
    }

    @Override
    public int create(ReviewOfEstablishment reviewOfEstablishment) {
        return jdbcTemplate.update(CREATE, reviewOfEstablishment.getReview(), reviewOfEstablishment.getUserAccountNickname());
    }

    @Override
    public int update(Integer id, ReviewOfEstablishment reviewOfEstablishment) {
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=0");
        var tempVar = jdbcTemplate.update(UPDATE, reviewOfEstablishment.getReview(), reviewOfEstablishment.getUserAccountNickname(), id);
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=1");
        return tempVar;
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
