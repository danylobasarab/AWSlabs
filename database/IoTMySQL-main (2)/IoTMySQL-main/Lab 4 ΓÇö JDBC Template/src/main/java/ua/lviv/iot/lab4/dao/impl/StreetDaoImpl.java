package ua.lviv.iot.lab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.StreetDAO;
import ua.lviv.iot.lab4.model.Street;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class StreetDaoImpl implements StreetDAO {
    private static final String FIND_ALL = "SELECT * FROM street";
    private static final String CREATE = "INSERT street(name, city_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE street SET name=?, city_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM street WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM street WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM street7 WHERE name=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StreetDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Street> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Street.class));
    }

    @Override
    public Optional<Street> findById(Integer id) {
        Optional<Street> street;
        try {
            street = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Street.class), id));
        } catch (EmptyResultDataAccessException e) {
            street = Optional.empty();
        }
        return street;
    }

    @Override
    public Optional<Street> findByName(String name) {
        Optional<Street> street;
        try {
            street = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_NAME,
                    BeanPropertyRowMapper.newInstance(Street.class), name));
        } catch (EmptyResultDataAccessException e) {
            street = Optional.empty();
        }
        return street;
    }

    @Override
    public int create(Street street) {
        return jdbcTemplate.update(CREATE, street.getName(), street.getCityId());
    }

    @Override
    public int update(Integer id, Street street) {
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=0");
        var tempVar = jdbcTemplate.update(UPDATE, street.getName(), street.getCityId(), id);
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=1");
        return tempVar;
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

}
