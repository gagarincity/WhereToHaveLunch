package ru.ivanlis.wheretohavelunch.service;

import org.springframework.stereotype.Service;
import ru.ivanlis.wheretohavelunch.model.Restaurant;
import ru.ivanlis.wheretohavelunch.model.User;
import ru.ivanlis.wheretohavelunch.model.Vote;
import ru.ivanlis.wheretohavelunch.repository.RestaurantRepository;
import ru.ivanlis.wheretohavelunch.repository.UserRepository;
import ru.ivanlis.wheretohavelunch.repository.VoteRepository;
import ru.ivanlis.wheretohavelunch.util.exception.NotFoundException;
import ru.ivanlis.wheretohavelunch.util.exception.VoteFinishException;

import javax.transaction.Transactional;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static ru.ivanlis.wheretohavelunch.model.Vote.VOTE_FINISH;

@Service
public class VoteService {
    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public VoteService(VoteRepository voteRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    private Clock clock = Clock.systemDefaultZone();

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    @Transactional
    public Vote vote(int userId, int restaurantId) {
        LocalDateTime votingLocalDateTime = LocalDateTime.now(clock);
        final Restaurant restaurant = restaurantRepository.getOne(restaurantId);
        final User user = userRepository.getOne(userId);
        Vote vote;
        try {
            vote = getByUserAndLocalDate(user, votingLocalDateTime.toLocalDate());
        } catch (NotFoundException e) {
            return voteRepository.save(new Vote(null, votingLocalDateTime.toLocalDate(), user, restaurant));
        }

        if (votingLocalDateTime.toLocalTime().isBefore(VOTE_FINISH)) {
            if (vote.getRestaurant().id() != restaurantId) {
                vote.setRestaurant(restaurant);
                return vote;
            }
            return vote;
        } else {
            throw new VoteFinishException("Vote finish for that day");
        }
    }

    public Vote getByUserAndLocalDate(User user, LocalDate date) {
        return voteRepository.getByUserAndLocalDate(user, date);
    }

    public Vote getByUserIdAndLocalDate(int userId, LocalDate date) {
        return voteRepository.getByUserIdAndLocalDate(userId, date);
    }

    public List<Vote> getAll(int userId) {
        return voteRepository.getAll(userId);
    }
}
