package com.common.common.model.sportActivity;

import com.common.common.enums.ActivityType;
import com.common.common.enums.PricingType;
import com.common.common.model.user.User;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="sportActivity",schema = "common")
public class SportActivity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "activity_id", nullable = false, unique = true)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ActivityType activityType;

    @Enumerated(EnumType.STRING)
    @Column(name = "pricingType", nullable = false)
    private PricingType pricingType;

    @OneToOne
    @JoinColumn(name="owner_id", referencedColumnName="user_id", nullable = false)
    private User owner;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date createdDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date endDate;

    @Column(name = "lat",nullable = false)
    private float lat;

    @Column(name = "lon",nullable = false)
    private float lon;

    @Column(name = "ageRangeMin",nullable = false)
    private double ageRangeMin;

    @Column(name = "ageRangeMax",nullable = false)
    private double ageRangeMax;

    @Column(name = "price",nullable = false)
    private double price;

    @Column(name = "remainingSlot",nullable = false)
    private int remainingSlot;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getActivityType() {
        return activityType.getActivity();
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public PricingType getPricingType() {
        return pricingType;
    }

    public void setPricingType(PricingType pricingType) {
        this.pricingType = pricingType;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public double getAgeRangeMin() {
        return ageRangeMin;
    }

    public void setAgeRangeMin(double ageRangeMin) {
        this.ageRangeMin = ageRangeMin;
    }

    public double getAgeRangeMax() {
        return ageRangeMax;
    }

    public void setAgeRangeMax(double ageRangeMax) {
        this.ageRangeMax = ageRangeMax;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRemainingSlot() {
        return remainingSlot;
    }

    public void setRemainingSlot(int remainingSlot) {
        this.remainingSlot = remainingSlot;
    }
}
