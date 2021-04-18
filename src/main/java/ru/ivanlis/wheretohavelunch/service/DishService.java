package ru.ivanlis.wheretohavelunch.service;

import org.springframework.stereotype.Service;
import ru.ivanlis.wheretohavelunch.model.Dish;

import java.util.List;

@Service
public class DishService implements BaseService<Dish> {
    @Override
    public List<Dish> getAll() {
        return null;
    }

    @Override
    public Dish getById(int id) {
        return null;
    }

    @Override
    public Dish save(Dish o) {
        return null;
    }

    @Override
    public void update(Dish o, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
