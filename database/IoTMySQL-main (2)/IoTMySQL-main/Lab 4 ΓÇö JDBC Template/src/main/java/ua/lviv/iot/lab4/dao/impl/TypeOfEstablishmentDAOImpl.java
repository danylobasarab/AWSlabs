package ua.lviv.iot.lab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.TypeOfEstablishmentDAO;
import ua.lviv.iot.lab4.model.TypeOfEstablishment;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class TypeOfEstablishmentDAOImpl implements TypeOfEstablishmentDAO {
    private static final String FIND_ALL = "SELECT * FROM type_of_establishment";
    private static final String CREATE = "INSERT type_of_establishment(type_name) VALUES (?)";
    private static final String UPDATE = "UPDATE type_of_establishment SET type_name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM type_of_establishment WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM type_of_establishment WHERE id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TypeOfEstablishmentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TypeOfEstablishment> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(TypeOfEstablishment.class));
    }

    @Override
    public Optional<TypeOfEstablishment> findById(Integer id) {
        Optional<TypeOfEstablishment> typeOfEstablishment;
        try {
            typeOfEstablishment = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(TypeOfEstablishment.class), id));
        } catch (EmptyResultDataAccessException e) {
            typeOfEstablishment = Optional.empty();
        }
        return typeOfEstablishment;
    }

    @Override
    public int create(TypeOfEstablishment typeOfEstablishment) {
        return jdbcTemplate.update(CREATE, typeOfEstablishment.getTypeName());
    }

    @Override
    public int update(Integer id, TypeOfEstablishment typeOfEstablishment) {
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=0");
        var tempVar = jdbcTemplate.update(UPDATE, typeOfEstablishment.getTypeName(), id);
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=1");
        return tempVar;
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
