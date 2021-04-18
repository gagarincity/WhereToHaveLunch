package ru.ivanlis.wheretohavelunch.repository.crud;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanlis.wheretohavelunch.model.User;

@Transactional(readOnly = true)
public interface CrudUserRepository extends CrudRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    User getByUserEmail(String email);
}
