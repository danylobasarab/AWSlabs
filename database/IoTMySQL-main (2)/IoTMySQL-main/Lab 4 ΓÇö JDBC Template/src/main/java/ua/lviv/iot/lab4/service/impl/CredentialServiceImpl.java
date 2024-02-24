package ua.lviv.iot.lab4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.dao.CredentialDAO;
import ua.lviv.iot.lab4.model.Credential;
import ua.lviv.iot.lab4.service.CredentialService;

import java.util.List;
import java.util.Optional;

@Service
public class CredentialServiceImpl implements CredentialService {
    private final CredentialDAO credentialDAO;

    @Autowired
    public CredentialServiceImpl(CredentialDAO credentialDAO) {
        this.credentialDAO = credentialDAO;
    }

    @Override
    public List<Credential> findAll() {
        return credentialDAO.findAll();
    }

    @Override
    public Optional<Credential> findById(Integer id) {
        return credentialDAO.findById(id);
    }

    @Override
    public int create(Credential credential) {
        return credentialDAO.create(credential);
    }

    @Override
    public int update(Integer id, Credential credential) {
        return credentialDAO.update(id, credential);
    }

    @Override
    public int delete(Integer id) {
        return credentialDAO.delete(id);
    }
}
