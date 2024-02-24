package ua.lviv.iot.lab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.CountryDAO;
import ua.lviv.iot.lab4.model.Country;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class CountryDAOImpl implements CountryDAO {
    private static final String FIND_ALL = "SELECT * FROM country";
    private static final String CREATE = "INSERT country(name) VALUES (?)";
    private static final String UPDATE = "UPDATE country SET name=?  WHERE name=?";
    private static final String DELETE = "DELETE FROM country WHERE name=?";
    private static final String FIND_BY_NAME = "SELECT * FROM country WHERE name=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Country> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Country.class));
    }

    @Override
    public Optional<Country> findById(String name) {
        Optional<Country> country;
        try {
            country = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_NAME,
                    BeanPropertyRowMapper.newInstance(Country.class), name));
        } catch (EmptyResultDataAccessException e) {
            country = Optional.empty();
        }
        return country;
    }

    @Override
    public int create(Country country) {
        return jdbcTemplate.update(CREATE, country.getName());
    }

    @Override
    public int update(String name, Country country) {
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=0");
        var tempVar = jdbcTemplate.update(UPDATE, country.getName(), name);
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=1");
        return tempVar;
    }

    @Override
    public int delete(String name) {
        return jdbcTemplate.update(DELETE, name);
    }
}
