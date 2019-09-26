package com.common.common.model.notification;

import com.common.common.enums.ActivityRequestType;
import com.common.common.model.sportActivity.SportActivity;
import com.common.common.model.user.User;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name="notification",schema = "common")
public class Notification {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "notification_id", nullable = false, unique = true)
    private UUID id;

    @OneToOne
    @JoinColumn(name="notification_receiver_id",referencedColumnName="user_id")
    private User notificationReceiver;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type", nullable = false, unique = false)
    private ActivityRequestType activityRequestType;

    @OneToOne
    @JoinColumn(name="activity_id",referencedColumnName="activity_id")
    private SportActivity sportActivity;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date createdDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getNotificationReceiver() {
        return notificationReceiver;
    }

    public void setNotificationReceiver(User notificationReceiver) {
        this.notificationReceiver = notificationReceiver;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ActivityRequestType getActivityRequestType() {
        return activityRequestType;
    }

    public void setActivityRequestType(ActivityRequestType activityRequestType) {
        this.activityRequestType = activityRequestType;
    }

    public SportActivity getSportActivity() {
        return sportActivity;
    }

    public void setSportActivity(SportActivity sportActivity) {
        this.sportActivity = sportActivity;
    }
}
