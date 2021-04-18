package ru.ivanlis.wheretohavelunch.repository.crud;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanlis.wheretohavelunch.model.Dish;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudDishRepository extends CrudRepository<Dish, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Dish d WHERE d.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT d FROM Dish d WHERE d.restaurant.restaurantName=:restaurantName")
    List<Dish> getByRestaurantName(@Param("restaurantName") String restaurantName);

    @Query("SELECT d FROM Dish d WHERE d.dateTime >= :startDate AND d.dateTime <= :endDate")
    List<Dish> getBetweenDatesIncluding(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT d FROM Dish d WHERE d.restaurant.restaurantName=:restaurantName AND d.dateTime >= :startDate " +
            "AND d.dateTime <= :endDate")
    List<Dish> getByRestaurantNameBetweenDates(@Param("restaurantName") String restaurantName,
                                               @Param("startDate") LocalDate startDate,
                                               @Param("endDate") LocalDate endDate);
}
