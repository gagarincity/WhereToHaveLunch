package ru.ivanlis.wheretohavelunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanlis.wheretohavelunch.model.User;
import ru.ivanlis.wheretohavelunch.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId ORDER BY v.localDate DESC")
    List<Vote> getAll(@Param("userId") int userId);

    Vote getByUserAndLocalDate(User user, LocalDate localDate);

    Vote getByUserIdAndLocalDate(int userId, LocalDate localDate);
}
