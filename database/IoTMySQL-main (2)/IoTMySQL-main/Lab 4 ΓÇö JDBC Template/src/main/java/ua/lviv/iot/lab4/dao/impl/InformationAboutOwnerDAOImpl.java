package ua.lviv.iot.lab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.InformationAboutOwnerDAO;
import ua.lviv.iot.lab4.model.Establishment;
import ua.lviv.iot.lab4.model.InformationAboutOwner;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class InformationAboutOwnerDAOImpl implements InformationAboutOwnerDAO {
    private static final String FIND_ALL = "SELECT * FROM information_about_owner";
    private static final String CREATE = "INSERT information_about_owner(name, surname, age, fortunes) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE information_about_owner SET name=?, surname=?, age=?, fortunes=? WHERE id=?";
    private static final String DELETE = "DELETE FROM information_about_owner WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM information_about_owner WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM information_about_owner WHERE name=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InformationAboutOwnerDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<InformationAboutOwner> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(InformationAboutOwner.class));
    }

    @Override
    public Optional<InformationAboutOwner> findById(Integer id) {
        Optional<InformationAboutOwner> informationAboutOwner;
        try {
            informationAboutOwner = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(InformationAboutOwner.class), id));
        } catch (EmptyResultDataAccessException e) {
            informationAboutOwner = Optional.empty();
        }
        return informationAboutOwner;
    }

    @Override
    public Optional<InformationAboutOwner> findByName(String name) {
        Optional<InformationAboutOwner> informationAboutOwner;
        try {
            informationAboutOwner = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_NAME,
                    BeanPropertyRowMapper.newInstance(InformationAboutOwner.class), name));
        } catch (EmptyResultDataAccessException e) {
            informationAboutOwner = Optional.empty();
        }
        return informationAboutOwner;
    }

    @Override
    public int create(InformationAboutOwner informationAboutOwner) {
        return jdbcTemplate.update(CREATE, informationAboutOwner.getName(), informationAboutOwner.getSurname(),
                informationAboutOwner.getAge(), informationAboutOwner.getFortunes());
    }

    @Override
    public int update(Integer id, InformationAboutOwner informationAboutOwner) {
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=0");
        var tempVar = jdbcTemplate.update(UPDATE, informationAboutOwner.getName(), informationAboutOwner.getSurname(),
                informationAboutOwner.getAge(), informationAboutOwner.getFortunes(), id);
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=1");
        return tempVar;
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
