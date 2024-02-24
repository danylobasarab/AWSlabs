package ua.lviv.iot.lab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.EstablishmentDAO;
import ua.lviv.iot.lab4.model.Establishment;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class EstablishmentDAOImpl implements EstablishmentDAO {
    private static final String FIND_ALL = "SELECT * FROM establishment";
    private static final String CREATE = "INSERT establishment(name, type_of_establishment_id, rating, street_id," +
            "information_about_owner_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE establishment SET name=?, type_of_establishment_id=?, rating=?," +
            "street_id=?, information_about_owner_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM establishment WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM establishment WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM establishment WHERE name=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EstablishmentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Establishment> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Establishment.class));
    }

    @Override
    public Optional<Establishment> findById(Integer id) {
        Optional<Establishment> establishment;
        try {
            establishment = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Establishment.class), id));
        } catch (EmptyResultDataAccessException e) {
            establishment = Optional.empty();
        }
        return establishment;
    }

    @Override
    public Optional<Establishment> findByName(String name) {
        Optional<Establishment> establishment;
        try {
            establishment = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_NAME,
                    BeanPropertyRowMapper.newInstance(Establishment.class), name));
        } catch (EmptyResultDataAccessException e) {
            establishment = Optional.empty();
        }
        return establishment;
    }

    @Override
    public int create(Establishment establishment) {
        return jdbcTemplate.update(CREATE, establishment.getName(), establishment.getTypeOfEstablishmentId(),
                establishment.getRating(), establishment.getStreetId(), establishment.getInformationAboutOwnerId());
    }

    @Override
    public int update(Integer id, Establishment establishment) {
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=0");
        var tempVar = jdbcTemplate.update(UPDATE, establishment.getName(), establishment.getTypeOfEstablishmentId(),
                establishment.getRating(), establishment.getStreetId(), establishment.getInformationAboutOwnerId(), id);
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=1");
        return tempVar;
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
