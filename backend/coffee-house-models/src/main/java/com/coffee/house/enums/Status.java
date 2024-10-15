package com.coffee.house.enums;

public enum Status {
    PUBLISHED, INACTIVE;

    public String getStatus() {
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
            default:
                status = "error";
                break;
        }
        return status;
    }

    public String getName() {
        return this.name();
    }

    // public static Map<String, Status> getStatusMap() {
    // HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
    // paymentStatusMap.put(PUBLISHED.name(), PUBLISHED);
    // paymentStatusMap.put(INACTIVE.name(), INACTIVE);
    // return paymentStatusMap;
    // }

    // public static Status getStatusEnum(String status) {
    // Map<String, Status> statusMap = getStatusMap();

    // Status statusName = statusMap.get(status);

    // return statusName;
    // }
}