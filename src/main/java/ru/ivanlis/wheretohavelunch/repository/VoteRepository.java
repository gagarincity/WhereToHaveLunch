package ru.ivanlis.wheretohavelunch.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanlis.wheretohavelunch.model.Vote;
import ru.ivanlis.wheretohavelunch.repository.crud.CrudVoteRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class VoteRepository implements BaseRepository<Vote> {
    private final CrudVoteRepository voteRepository;

    public VoteRepository(CrudVoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public List<Vote> getAll() {
        return (List<Vote>) voteRepository.findAll();
    }

    @Override
    public Vote getById(int id) {
        return voteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(int id) {
        voteRepository.delete(id);
    }

    @Override
    @Transactional
    public Vote create(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    @Transactional
    public void update(Vote vote, int id) {
        vote.setId(id);
        voteRepository.save(vote);
    }

    public Vote getByUserId(int userId) {
        return voteRepository.getByUserId(userId);
    }

    public Vote getByUserIdAndDate(int userId, LocalDate date) {
        return voteRepository.getByUserIdAndDate(userId, date);
    }

    public List<Vote> getBetweenDatesIncluding(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return voteRepository.getBetweenDatesIncluding(startDateTime, endDateTime);
    }
}
