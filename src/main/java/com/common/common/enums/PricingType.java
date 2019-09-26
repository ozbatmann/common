package com.common.common.enums;

public enum PricingType {

    FREE(0),
    PAID(1);

    final int pricing;

    PricingType(int pricing) { this.pricing = pricing; }

    public int getPricing(){
        return pricing;
    }
}
