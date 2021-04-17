package ru.ivanlis.wheretohavelunch.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanlis.wheretohavelunch.model.User;
import ru.ivanlis.wheretohavelunch.repository.crud.CrudUserRepository;

import java.util.List;

@Repository
public class UserRepository implements BaseRepository<User> {
    private final CrudUserRepository crudUserRepository;

    public UserRepository(CrudUserRepository crudUserRepository) {
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    public List<User> getAll() {
        return crudUserRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return crudUserRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(int id) {
        crudUserRepository.delete(id);
    }

    @Transactional
    @Override
    public User create(User user) {
        return crudUserRepository.save(user);
    }

    @Transactional
    @Override
    public void update(User user, int id) {
        crudUserRepository.save(user);
    }

    public User getByEmail(String email) {
        return crudUserRepository.getByEmail(email);
    }
}
