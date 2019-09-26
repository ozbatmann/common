package com.common.common.model.review;

import com.common.common.model.user.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name="review",schema = "common")
public class Review {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "review_id", nullable = false, unique = true)
    private UUID id;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName="user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="to_id", referencedColumnName="user_id")
    private User to;

    @Column(name = "rating",nullable = false)
    private double rating;

    @Column(name = "attended",nullable = true)
    private boolean attended;

    @Column(name = "comment",nullable = true)
    @Size(max = 140)
    private String comment;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
