package com.coffee.house.enums;

public enum PaymentStatus {
    PENDING, SUCCESS, CANCELLED;

    public String getStatus() {
        String status;

        switch (this) {
            case SUCCESS: {
                status = "Thành công";
                break;
            }
            case PENDING: {
                status = "Chờ thanh toán";
                break;
            }
            case CANCELLED: {
                status = "Đã hủy";
                break;
            }
            default:
                status = "error";
                break;
        }
        return status;
    }

    public String getName() {
        return this.name();
    }
}
