package ru.ivanlis.wheretohavelunch.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Dish extends AbstractBaseEntity {
    private LocalDateTime dateTime;

    private String description;

    private BigDecimal price;

    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(LocalDateTime dateTime, String description, BigDecimal price) {
        this(null, dateTime, description, price);
    }

    public Dish(Integer id, LocalDateTime dateTime, String description, BigDecimal price) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.price = price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", restaurant=" + restaurant +
                '}';
    }
}
