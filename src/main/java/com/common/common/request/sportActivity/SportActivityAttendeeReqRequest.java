package com.common.common.request.sportActivity;

public class SportActivityAttendeeReqRequest {

    private String requestOwnerId;
    private String activityOwnerId;
    private String activityId;

    public String getRequestOwnerId() {
        return requestOwnerId;
    }

    public void setRequestOwnerId(String requestOwnerId) {
        this.requestOwnerId = requestOwnerId;
    }

    public String getActivityOwnerId() {
        return activityOwnerId;
    }

    public void setActivityOwnerId(String activityOwnerId) {
        this.activityOwnerId = activityOwnerId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
}
