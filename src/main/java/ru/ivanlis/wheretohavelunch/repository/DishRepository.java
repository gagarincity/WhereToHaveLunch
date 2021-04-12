package ru.ivanlis.wheretohavelunch.repository;

import ru.ivanlis.wheretohavelunch.model.Dish;

import java.util.List;

public class DishRepository implements BaseRepository<Dish> {
    @Override
    public List<Dish> getAll() {
        return null;
    }

    @Override
    public Dish getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Dish create(Dish o) {
        return null;
    }

    @Override
    public void update(Dish o, int id) {

    }
}
