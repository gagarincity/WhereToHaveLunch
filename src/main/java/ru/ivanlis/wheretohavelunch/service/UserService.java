package ru.ivanlis.wheretohavelunch.service;

import ru.ivanlis.wheretohavelunch.model.User;
import ru.ivanlis.wheretohavelunch.repository.UserRepository;

import java.util.List;

public class UserService implements BaseService<User> {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User getById(int id) {
        return repository.getById(id);
    }

    @Override
    public User save(User user) {
        return repository.create(user);
    }

    @Override
    public void update(User user, int id) {
        repository.update(user, id);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    public User getByEmail(String email) {
        return repository.getByUserEmail(email);
    }
}
