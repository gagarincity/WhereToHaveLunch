package ru.ivanlis.wheretohavelunch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
public class Vote extends AbstractBaseEntity {
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @Column(name = "vote_date_time", nullable = false)
    private LocalDateTime voteDateTime;

    @Column(name = "vote_date", nullable = false)
    private LocalDate voteDate;

    public Vote() {
    }

    public Vote(Integer id, Integer userId, Integer restaurantId, LocalDateTime voteDateTime, LocalDate voteDate) {
        super(id);
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.voteDateTime = voteDateTime;
        this.voteDate = voteDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDateTime getVoteDateTime() {
        return voteDateTime;
    }

    public void setVoteDateTime(LocalDateTime voteDateTime) {
        this.voteDateTime = voteDateTime;
    }

    public LocalDate getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(LocalDate voteDate) {
        this.voteDate = voteDate;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", userId=" + userId +
                ", restaurantId=" + restaurantId +
                ", voteDateTime=" + voteDateTime +
                ", voteDate=" + voteDate +
                '}';
    }
}
