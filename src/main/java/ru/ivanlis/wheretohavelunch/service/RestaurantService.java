package ru.ivanlis.wheretohavelunch.service;

import ru.ivanlis.wheretohavelunch.model.Restaurant;
import ru.ivanlis.wheretohavelunch.repository.RestaurantRepository;

import java.util.List;

public class RestaurantService implements BaseService<Restaurant> {
    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Restaurant> getAll() {
        return null;
    }

    @Override
    public Restaurant getById(int id) {
        return null;
    }

    @Override
    public Restaurant save(Restaurant o) {
        return null;
    }

    @Override
    public void update(Restaurant o, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
