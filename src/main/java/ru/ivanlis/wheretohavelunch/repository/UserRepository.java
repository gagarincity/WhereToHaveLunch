package ru.ivanlis.wheretohavelunch.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanlis.wheretohavelunch.model.User;
import ru.ivanlis.wheretohavelunch.repository.crud.CrudUserRepository;

import java.util.List;

@Repository
public class UserRepository implements BaseRepository<User> {
    private final CrudUserRepository userRepository;

    public UserRepository(CrudUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(User user, int id) {
        user.setId(id);
        userRepository.save(user);
    }

    public User getByUserEmail(String email) {
        return userRepository.getByUserEmail(email);
    }
}
