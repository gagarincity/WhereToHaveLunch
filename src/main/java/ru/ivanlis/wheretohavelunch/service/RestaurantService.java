package ru.ivanlis.wheretohavelunch.service;

import org.springframework.stereotype.Service;
import ru.ivanlis.wheretohavelunch.model.Restaurant;
import ru.ivanlis.wheretohavelunch.repository.RestaurantRepository;
import ru.ivanlis.wheretohavelunch.util.exception.NotFoundException;

@Service
public class RestaurantService {
    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }


    public Restaurant create(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Restaurant get(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Not found " + id));
    }

    public void update(Restaurant restaurant) {
        repository.save(restaurant);
    }
}
