package ua.lviv.iot.lab4.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab4.controller.CredentialController;
import ua.lviv.iot.lab4.model.Credential;
import ua.lviv.iot.lab4.service.CredentialService;

import java.util.List;
import java.util.Optional;

@Service
public class CredentialControllerImpl implements CredentialController {
    private final CredentialService credentialService;

    @Autowired
    public CredentialControllerImpl(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @Override
    public List<Credential> findAll() {
        return credentialService.findAll();
    }

    @Override
    public Optional<Credential> findById(Integer id) {
        return credentialService.findById(id);
    }

    @Override
    public int create(Credential credential) {
        return credentialService.create(credential);
    }

    @Override
    public int update(Integer id, Credential credential) {
        return credentialService.update(id, credential);
    }

    @Override
    public int delete(Integer id) {
        return credentialService.delete(id);
    }
}
