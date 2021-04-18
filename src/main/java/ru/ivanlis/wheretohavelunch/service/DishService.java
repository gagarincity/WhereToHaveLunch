package ru.ivanlis.wheretohavelunch.service;

import org.springframework.stereotype.Service;
import ru.ivanlis.wheretohavelunch.model.Dish;
import ru.ivanlis.wheretohavelunch.repository.DishRepository;
import ru.ivanlis.wheretohavelunch.repository.RestaurantRepository;
import ru.ivanlis.wheretohavelunch.util.exception.NotFoundException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Service
public class DishService {
    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    public DishService(DishRepository dishRepository, RestaurantRepository restaurantRepository) {
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public Dish create(@Valid Dish dish, int restaurantId) {
        dish.setRestaurant(restaurantRepository.findById(restaurantId).orElseThrow(() -> new NotFoundException("Not found " + restaurantId)));
        return dishRepository.save(dish);
    }

    @Transactional
    public Dish update(@Valid Dish dish, int restaurantId) {
        dish.setRestaurant(restaurantRepository.findById(restaurantId).orElseThrow(() -> new NotFoundException("Not found " + restaurantId)));
        return dishRepository.save(dish);
    }

    public void delete(int id, int restaurantId) {
        dishRepository.delete(id, restaurantId);
    }

    public Dish get(int id, int restaurantId) {
        return dishRepository.findById(id)
                .filter(dish -> dish.getRestaurant().getId() == restaurantId)
                .orElse(null);
    }

    public List<Dish> getAll(int restaurantId) {
        return dishRepository.getAll(restaurantId);
    }

    public List<Dish> getByDate(LocalDate date, int restaurantId) {
        return dishRepository.getByDate(date, restaurantId);
    }
}
