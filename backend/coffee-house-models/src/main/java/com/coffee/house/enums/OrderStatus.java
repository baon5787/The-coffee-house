package com.coffee.house.enums;

public enum OrderStatus {
    SHIPPED, DELIVERED, PENDING, PROCESSING, CANCELLED;

    public String getStatus() {
        String status;

        switch (this) {
            case PENDING: {
                status = "Chờ xử lý";
                break;
            }
            case PROCESSING: {
                status = "Đang xử lý";
                break;
            }
            case SHIPPED: {
                status = "Đang vận chuyển";
                break;
            }
            case DELIVERED: {
                status = "Đã giao";
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
