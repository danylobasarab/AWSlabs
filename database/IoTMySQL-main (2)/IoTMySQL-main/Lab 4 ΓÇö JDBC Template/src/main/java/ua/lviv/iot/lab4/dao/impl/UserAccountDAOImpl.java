package ua.lviv.iot.lab4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.UserAccountDAO;
import ua.lviv.iot.lab4.model.UserAccount;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class UserAccountDAOImpl implements UserAccountDAO {
    private static final String FIND_ALL = "SELECT * FROM user_account";
    private static final String CREATE = "INSERT user_account(nickname, name, surname, credential_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE user_account SET name=?, surname=?, credential_id=? WHERE nickname=?";
    private static final String DELETE = "DELETE FROM user_account WHERE nickname=?";
    private static final String FIND_BY_ID = "SELECT * FROM user_account WHERE nickname=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserAccountDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserAccount> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(UserAccount.class));
    }

    @Override
    public Optional<UserAccount> findById(String nickname) {
        Optional<UserAccount> userAccount;
        try {
            userAccount = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(UserAccount.class), nickname));
        } catch (EmptyResultDataAccessException e) {
            userAccount = Optional.empty();
        }
        return userAccount;
    }

    @Override
    public int create(UserAccount userAccount) {
        return jdbcTemplate.update(CREATE, userAccount.getNickname(), userAccount.getName(), userAccount.getSurname(), userAccount.getCredentialId());
    }

    @Override
    public int update(String nickname, UserAccount userAccount) {
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=0");
        var tempVar = jdbcTemplate.update(UPDATE, userAccount.getName(), userAccount.getSurname(), userAccount.getCredentialId(), nickname);
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=1");
        return tempVar;
    }

    @Override
    public int delete(String nickname) {
        return jdbcTemplate.update(DELETE, nickname);
    }
}
