package ru.ivanlis.wheretohavelunch.model;

import java.util.Date;
import java.util.EnumSet;

public class Restaurant extends AbstractBaseEntity {
    private String restaurantName;

    public Restaurant() {
    }

    public Restaurant(Restaurant r) {
        this(r.getId(), r.getRestaurantName());
    }

    public Restaurant(Integer id, String restaurantName) {
        super(id);
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", restaurantName='" + restaurantName + '\'' +
                '}';
    }
}
