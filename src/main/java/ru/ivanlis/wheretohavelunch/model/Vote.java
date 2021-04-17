package ru.ivanlis.wheretohavelunch.model;

import java.time.LocalDateTime;

public class Vote extends AbstractBaseEntity {
    private Integer userId;

    private Integer restaurantId;

    private LocalDateTime voteDateTime;

    public Vote() {
    }

    public Vote(Integer id, Integer userId, Integer restaurantId, LocalDateTime voteDateTime) {
        super(id);
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.voteDateTime = voteDateTime;
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

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", userId=" + userId +
                ", restaurantId=" + restaurantId +
                ", voteDateTime=" + voteDateTime +
                '}';
    }
}
