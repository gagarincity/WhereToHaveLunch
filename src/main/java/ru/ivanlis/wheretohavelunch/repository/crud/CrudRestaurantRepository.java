package ru.ivanlis.wheretohavelunch.repository.crud;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanlis.wheretohavelunch.model.Restaurant;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends CrudRepository<Restaurant, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    Restaurant getByRestaurantName(String restaurantName);
}
