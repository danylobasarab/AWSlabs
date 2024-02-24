package ua.lviv.iot.lab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.CityDAO;
import ua.lviv.iot.lab4.model.City;

import java.util.List;
import java.util.Optional;


@SuppressWarnings("SqlResolve")
@Service
public class CityDAOImpl implements CityDAO {
    private static final String FIND_ALL = "SELECT * FROM city";
    private static final String CREATE = "INSERT city(name, country_name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE city SET name=?, country_name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM city WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM city WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM city WHERE name=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CityDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<City> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(City.class));
    }

    @Override
    public Optional<City> findById(Integer id) {
        Optional<City> city;
        try {
            city = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(City.class), id));
        } catch (EmptyResultDataAccessException e) {
            city = Optional.empty();
        }
        return city;
    }

    @Override
    public Optional<City> findByName(String name) {
        Optional<City> city;
        try {
            city = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_NAME,
                    BeanPropertyRowMapper.newInstance(City.class), name));
        } catch (EmptyResultDataAccessException e) {
            city = Optional.empty();
        }
        return city;
    }

    @Override
    public int create(City city) {
        return jdbcTemplate.update(CREATE, city.getName(), city.getCountryName());
    }

    @Override
    public int update(Integer id, City city) {
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=0");
        var tempVar =jdbcTemplate.update(UPDATE, city.getName(), city.getCountryName(), id);
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=1");
        return tempVar;
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
