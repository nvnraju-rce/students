package com.rce.oops.unit4;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY,
    FRIDAY, SATURDAY, SUNDAY
}

public class EnumDemo {
    public static void main(String[] args) {
        Day today = Day.WEDNESDAY;

        System.out.println("Today: " + today);

        switch (today) {
            case SATURDAY:
            case SUNDAY:
                System.out.println("It's the weekend.");
                break;
            default:
                System.out.println("It's a weekday.");
        }
    }
}