package com.example.user.dietamaggi;

class Day {
    private String breakfast;
    private String lunch;
    private String dinner;

    Day(String breakfast, String lunch, String dinner) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    String getBreakfast() {
        return breakfast;
    }

    String getLunch() {
        return lunch;
    }

    String getDinner() {
        return dinner;
    }
}
