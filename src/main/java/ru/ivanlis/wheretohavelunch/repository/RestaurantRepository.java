package ru.ivanlis.wheretohavelunch.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanlis.wheretohavelunch.model.Restaurant;
import ru.ivanlis.wheretohavelunch.repository.crud.CrudRestaurantRepository;

import java.util.List;

@Repository
public class RestaurantRepository implements BaseRepository<Restaurant> {
    private final CrudRestaurantRepository restaurantRepository;

    public RestaurantRepository(CrudRestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAll() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }

    @Override
    public Restaurant getById(int id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(int id) {
        restaurantRepository.delete(id);
    }

    @Override
    @Transactional
    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    @Transactional
    public void update(Restaurant restaurant, int id) {
        restaurant.setId(id);
        restaurantRepository.save(restaurant);
    }

    public Restaurant getByRestaurantName(String restaurantName) {
        return restaurantRepository.getByRestaurantName(restaurantName);
    }
}
