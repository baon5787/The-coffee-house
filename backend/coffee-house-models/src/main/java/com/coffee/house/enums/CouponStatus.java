package com.coffee.house.enums;

public enum CouponStatus {
    PUBLISHED, INACTIVE, EXPIRED;

    public String getCouponStatus() {
        String status;

        switch (this) {
            case PUBLISHED: {
                status = "Đã duyệt";
                break;
            }
            case INACTIVE: {
                status = "Chưa duyệt";
                break;
            }
            case EXPIRED: {
                status = "Hết hạn";
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
