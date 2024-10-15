package com.coffee.house.enums;

public enum CouponType {
    PERCENT, MONEY;

    public String getCouponType() {
        String status;

        switch (this) {
            case PERCENT: {
                status = "Phần trăm";
                break;
            }
            case MONEY: {
                status = "Tiền";
                break;
            }
            default:
                status = "erro";
                break;
        }
        return status;
    }

    public String getName() {
        return this.name();
    }
}
