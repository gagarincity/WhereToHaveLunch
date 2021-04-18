package ru.ivanlis.wheretohavelunch.repository.crud;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanlis.wheretohavelunch.model.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends CrudRepository<Vote, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT v FROM Vote v WHERE v.voteDateTime >= :startDateTime AND v.voteDateTime <= :endDateTime")
    List<Vote> getBetweenDatesIncluding(@Param("startDateTime") LocalDateTime startDateTime
            , @Param("endDateTime") LocalDateTime endDateTime);

    @Query("SELECT v FROM Vote v WHERE v.voteDate=:voteDate AND v.userId=:userId")
    Vote getByUserIdAndDate(@Param("userId") Integer userId, @Param("voteDate") LocalDate voteDate);

    Vote getByUserId(int userId);
}
