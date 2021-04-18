package ru.ivanlis.wheretohavelunch.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "dish", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "name", "localdate"}
        , name = "dish_unique_restaurant_name_date_idx")})
public class Dish extends AbstractBaseEntity {

    @Column(name = "localdate", nullable = false)
    private LocalDate localDate = LocalDate.now();

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String name;

    @Column(name = "price", nullable = false)
    @Positive
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(Dish d) {
        this(d.getId(), d.getLocalDate(), d.getName(), d.getPrice(), d.getRestaurant());
    }

    public Dish(Integer id, LocalDate localDate, String name, Long price, Restaurant restaurant) {
        super(id);
        this.localDate = localDate;
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
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
                ", localDate=" + localDate +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", restaurant=" + restaurant +
                '}';
    }

    @Override
    public int id() {
        return id;
    }
}
