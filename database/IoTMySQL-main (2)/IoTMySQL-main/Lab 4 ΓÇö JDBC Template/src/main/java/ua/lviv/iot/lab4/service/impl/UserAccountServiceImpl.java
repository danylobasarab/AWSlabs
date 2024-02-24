package ua.lviv.iot.lab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.UserAccountDAO;
import ua.lviv.iot.lab4.model.UserAccount;
import ua.lviv.iot.lab4.service.UserAccountService;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountDAO userAccountDAO;

    @Autowired
    public UserAccountServiceImpl(UserAccountDAO userAccountDAO) {
        this.userAccountDAO = userAccountDAO;
    }

    @Override
    public List<UserAccount> findAll() {
        return userAccountDAO.findAll();
    }

    @Override
    public Optional<UserAccount> findById(String nickname) {
        return userAccountDAO.findById(nickname);
    }

    @Override
    public int create(UserAccount userAccount) {
        return userAccountDAO.create(userAccount);
    }

    @Override
    public int update(String nickname, UserAccount userAccount) {
        return userAccountDAO.update(nickname, userAccount);
    }

    @Override
    public int delete(String nickname) {
        return userAccountDAO.delete(nickname);
    }
}
