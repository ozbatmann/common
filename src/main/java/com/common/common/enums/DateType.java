package com.common.common.enums;

public enum DateType {
    TODAY(0),
    TOMORROW(1);

    final int date;

    DateType(int date) { this.date = date; }

    public int getDate(){
        return date;
    }
}
