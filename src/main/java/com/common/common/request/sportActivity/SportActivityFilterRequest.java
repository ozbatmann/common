package com.common.common.request.sportActivity;

import com.common.common.enums.ActivityType;
import com.common.common.enums.PricingType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class SportActivityFilterRequest {

    private double minAge;
    private double maxAge;
    private float distance;
    private float lat;
    private float lon;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern= "yyyy/MM/dd HH:mm:ss", timezone = "Europe/Minsk")
    private List<Date> startDates;

    private List<ActivityType> activityTypes;
    private List<PricingType> pricingTypes;


    public double getMinAge() {
        return minAge;
    }

    public void setMinAge(double minAge) {
        this.minAge = minAge;
    }

    public double getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(double maxAge) {
        this.maxAge = maxAge;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
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

    public List<Date> getStartDates() {
        return startDates;
    }

    public void setStartDates(List<Date> startDates) {
        this.startDates = startDates;
    }

    public List<ActivityType> getActivityTypes() {
        return activityTypes;
    }

    public void setActivityTypes(List<ActivityType> activityTypes) {
        this.activityTypes = activityTypes;
    }

    public List<PricingType> getPricingTypes() {
        return pricingTypes;
    }

    public void setPricingTypes(List<PricingType> pricingTypes) {
        this.pricingTypes = pricingTypes;
    }
}
