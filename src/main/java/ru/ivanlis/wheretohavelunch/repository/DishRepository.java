package ru.ivanlis.wheretohavelunch.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanlis.wheretohavelunch.model.Dish;
import ru.ivanlis.wheretohavelunch.repository.crud.CrudDishRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DishRepository implements BaseRepository<Dish> {
    private final CrudDishRepository dishRepository;

    public DishRepository(CrudDishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> getAll() {
        return (List<Dish>) dishRepository.findAll();
    }

    @Override
    public Dish getById(int id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dishRepository.delete(id);
    }

    @Override
    @Transactional
    public Dish create(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void update(Dish dish, int id) {
        dish.setId(id);
        dishRepository.save(dish);
    }

    public List<Dish> getByRestaurantName(String restaurantName) {
        return dishRepository.getByRestaurantName(restaurantName);
    }

    public List<Dish> getBetweenDatesIncluding(LocalDate startDate, LocalDate endDate) {
        return dishRepository.getBetweenDatesIncluding(startDate, endDate);
    }

    public List<Dish> getByRestaurantNameBetweenDates(String restaurantName, LocalDate startDate, LocalDate endDate) {
        return dishRepository.getByRestaurantNameBetweenDates(restaurantName, startDate, endDate);
    }
}
