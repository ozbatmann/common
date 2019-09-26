package com.common.common.enums;

public enum ActivityType {
    FOOTBALL(0),
    BASKETBALL(1),
    TENIS(2);


    final int activity;

    ActivityType(int activity) { this.activity = activity; }

    public int getActivity(){
        return activity;
    }
}
