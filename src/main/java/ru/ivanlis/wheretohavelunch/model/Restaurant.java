package ru.ivanlis.wheretohavelunch.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM Restaurant r WHERE r.id=:id"),
        @NamedQuery(name = Restaurant.BY_NAME, query = "SELECT DISTINCT r FROM Restaurant r WHERE r.name=?1"),
})
@Entity
@Table(name = "restaurant", uniqueConstraints = {@UniqueConstraint(columnNames = "name"
        , name = "restaurant_unique_name_idx")})
public class Restaurant extends AbstractBaseEntity {
    public static final String DELETE = "Restaurant.delete";
    public static final String BY_NAME = "Restaurant.getByName";

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @Column(name = "registered", nullable = false)
    @NotNull
    private Date registered = new Date();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("localDate DESC")
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Dish> dishes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("localDate DESC")
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Vote> votes;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, Date registered) {
        super(id);
        this.name = name;
        this.registered = registered;
    }

    public Restaurant(Integer id, String name) {
        this(id, name, new Date());
    }

    public Restaurant(Restaurant restaurant) {
        this(restaurant.getId(), restaurant.getName(), restaurant.getRegistered());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registered=" + registered +
                '}';
    }

    @Override
    public int id() {
        return id;
    }
}
