package ua.lviv.iot.lab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.controller.UserAccountController;
import ua.lviv.iot.lab4.model.UserAccount;
import ua.lviv.iot.lab4.service.UserAccountService;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountControllerImpl implements UserAccountController {
    private final UserAccountService userAccountService;

    @Autowired
    public UserAccountControllerImpl(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public List<UserAccount> findAll() {
        return userAccountService.findAll();
    }

    @Override
    public Optional<UserAccount> findById(String nickname) {
        return userAccountService.findById(nickname);
    }

    @Override
    public int create(UserAccount userAccount) {
        return userAccountService.create(userAccount);
    }

    @Override
    public int update(String nickname, UserAccount userAccount) {
        return userAccountService.update(nickname, userAccount);
    }

    @Override
    public int delete(String nickname) {
        return userAccountService.delete(nickname);
    }
}
