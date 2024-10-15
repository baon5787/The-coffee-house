package com.coffee.house.enums;

public enum Gender {
    MALE, FEMALE, OTHER;

    public String getGender() {
        String gender;

        switch (this) {
            case MALE: {
                gender = "Nam";
                break;
            }
            case FEMALE: {
                gender = "Nữ";
                break;
            }
            case OTHER: {
                gender = "Không rõ";
                break;
            }
            default:
                gender = "Khác";
                break;
        }
        return gender;
    }

    public String getName() {
        return this.name();
    }
}
