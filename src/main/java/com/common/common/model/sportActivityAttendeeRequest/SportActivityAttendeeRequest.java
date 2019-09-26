package com.common.common.model.sportActivityAttendeeRequest;

import com.common.common.enums.ActivityRequestType;
import com.common.common.model.sportActivity.SportActivity;
import com.common.common.model.user.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="sportActivityAttendeeRequest",schema = "common")
public class SportActivityAttendeeRequest {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "sport_activity_attendee_request_id", nullable = false, unique = true)
    private UUID id;

    @OneToOne
    @JoinColumn(name="request_owner_id", referencedColumnName="user_id")
    private User requestOwner;

    @OneToOne
    @JoinColumn(name="activity_owner_id", referencedColumnName="user_id")
    private User activityOwner;

    @OneToOne
    @JoinColumn(name="activity_id", referencedColumnName="activity_id")
    private SportActivity sportActivity;

    @Enumerated(EnumType.STRING)
    @Column(name="sport_activity_request_type", nullable = false)
    private ActivityRequestType activityRequestType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getRequestOwner() {
        return requestOwner;
    }

    public void setRequestOwner(User requestOwner) {
        this.requestOwner = requestOwner;
    }

    public User getActivityOwner() {
        return activityOwner;
    }

    public void setActivityOwner(User activityOwner) {
        this.activityOwner = activityOwner;
    }

    public SportActivity getSportActivity() {
        return sportActivity;
    }

    public void setSportActivity(SportActivity sportActivity) {
        this.sportActivity = sportActivity;
    }

    public ActivityRequestType getActivityRequestType() {
        return activityRequestType;
    }

    public void setActivityRequestType(ActivityRequestType activityRequestType) {
        this.activityRequestType = activityRequestType;
    }
}
