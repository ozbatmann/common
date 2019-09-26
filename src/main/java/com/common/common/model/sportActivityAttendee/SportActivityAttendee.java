package com.common.common.model.sportActivityAttendee;

import com.common.common.model.sportActivity.SportActivity;
import com.common.common.model.user.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name="sportActivityAttendee",schema = "common")
public class SportActivityAttendee {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "sport_activity_attendees_id", nullable = false, unique = true)
    private UUID id;

    @OneToOne
    @JoinColumn(name="attendee_id", referencedColumnName="user_id")
    private User attendee;

    @OneToOne
    @JoinColumn(name="activity_id", referencedColumnName = "activity_id")
    private SportActivity sportActivity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getAttendee() {
        return attendee;
    }

    public void setAttendee(User attendee) {
        this.attendee = attendee;
    }

    public SportActivity getSportActivity() {
        return sportActivity;
    }

    public void setSportActivity(SportActivity sportActivity) {
        this.sportActivity = sportActivity;
    }
}
