package org.example.clockhands;

import org.example.clockhands.ClockHand;

public class HourHand implements ClockHand {

    private int hours;
    private MinuteHand minuteHand;

    public HourHand(MinuteHand minuteHand) {
        this.hours = 0;
        this.minuteHand = minuteHand;
    }

    @Override
    public void iterate() {
        try {
            if (this.hours < 23) {
                this.hours += 1;
            } else {
                this.hours = 0;
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
