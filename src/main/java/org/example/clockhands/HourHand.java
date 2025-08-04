package org.example.clockhands;

import org.example.clockhands.ClockHand;

public class HourHand implements ClockHand {

    private int hours;
    private SecondHand secondHand;

    public HourHand() {}

    @Override
    public void iterate() {
        try {
            if (this.hours < 23) {
                this.hours += 1;
            } else {
                this.hours = 0;
                secondHand.iterate();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int getHours() {
        return this.hours;
    }

    public void setHours(int newHours) {
        this.hours = newHours;
    }
}
