package com.common.common.request.sportActivity;

import com.common.common.enums.ActivityType;
import com.common.common.enums.PricingType;
import com.common.common.model.user.User;

public class SportActivityRequest {

    private String id;

    private String ownerId;

    private ActivityType activityType;

    private PricingType pricingType;

    private String createdDate;

    private String startDate;

    private String endDate;

    private float lat;

    private float lon;

    private double ageRangeMin;

    private double ageRangeMax;

    private double price;

    private int remainingSlot;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public ActivityType getActivityType() {
        return activityType;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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
