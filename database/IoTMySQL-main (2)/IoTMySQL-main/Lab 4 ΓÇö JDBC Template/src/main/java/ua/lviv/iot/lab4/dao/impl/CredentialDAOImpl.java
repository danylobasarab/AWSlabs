package ua.lviv.iot.lab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.CredentialDAO;
import ua.lviv.iot.lab4.model.Credential;

import java.util.List;
import java.util.Optional;


@SuppressWarnings("SqlResolve")
@Service
public class CredentialDAOImpl implements CredentialDAO {
    private static final String FIND_ALL = "SELECT * FROM credential";
    private static final String CREATE = "INSERT credential(login, password) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE credential SET login=?, password=? WHERE id=?";
    private static final String DELETE = "DELETE FROM credential WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM credential WHERE id=?";


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CredentialDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Credential> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Credential.class));
    }

    @Override
    public Optional<Credential> findById(Integer id) {
        Optional<Credential> credential;
        try {
            credential = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Credential.class), id));
        } catch (EmptyResultDataAccessException e) {
            credential = Optional.empty();
        }
        return credential;
    }

    @Override
    public int create(Credential credential) {
        return jdbcTemplate.update(CREATE, credential.getLogin(), credential.getPassword());
    }

    @Override
    public int update(Integer id, Credential credential) {
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=0");
        var tempVar = jdbcTemplate.update(UPDATE, credential.getLogin(), credential.getPassword(), id);
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=1");
        return tempVar;
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
