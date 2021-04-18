package ru.ivanlis.wheretohavelunch.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NamedQueries({
        @NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM Restaurant r WHERE r.id=:id"),
        @NamedQuery(name = Restaurant.BY_NAME, query = "SELECT DISTINCT r FROM Restaurant r WHERE r.restaurantName=?1"),
})
@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractBaseEntity {
    public static final String DELETE = "Restaurant.delete";
    public static final String BY_NAME = "Restaurant.getByName";

    @Column(name = "restaurant_name", nullable = false)
    @NotBlank
    @Size(max = 100)
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
