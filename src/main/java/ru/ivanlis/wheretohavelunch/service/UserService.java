package ru.ivanlis.wheretohavelunch.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.ivanlis.wheretohavelunch.model.User;
import ru.ivanlis.wheretohavelunch.repository.UserRepository;
import ru.ivanlis.wheretohavelunch.util.exception.NotFoundException;

import java.util.List;

@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return repository.save(user);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public User get(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Not found " + id));
    }

    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public void update(User user) {
        repository.save(user);
    }

//    @Transactional
//    public void update(UserTo userTo) {
//        User user = get(userTo.id());
//        repository.save(UserUtil.updateFromTo(user, userTo));
//    }

//    public User getWithVotes(int id) {
//        return repository.getWithVotes;
//    }

//    @Override
//    public UserDetails loadUserByUsername(String email){
//        User user = repository.getByEmail(email.toLowerCase());
//        if (user == null) {
//            throw new UsernameNotFoundException("User " + email + " is not found");
//        }
//        return new AuthorizedUser(user);
//    }
}
