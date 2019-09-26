package com.common.common.enums;

public enum ActivityRequestType {

    REQUESTED(0),
    ACCEPTED(1),
    DECLINED(2),
    REVIEWED(3);

    final int notificationType;

    ActivityRequestType(int notificationType) { this.notificationType = notificationType; }

    public int getNotificationType(){
        return notificationType;
    }
}
