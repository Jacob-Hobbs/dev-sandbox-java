package org.example.clockhands;

import org.example.clockhands.ClockHand;

public class MinuteHand implements ClockHand {

    private int minutes;
    private HourHand hourHand;

    public MinuteHand() {
        this.minutes = 0;
    }

    @Override
    public void iterate() {
        try {
            if (this.minutes < 59) {
                this.minutes += 1;
            } else {
                this.minutes = 0;
                hourHand.iterate();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void setMinutes(int newMinutes) {
        this.minutes = newMinutes;
    }

    public HourHand getHourHand() {
        return this.hourHand;
    }

    public void setHourHand(HourHand hourHand) {
        this.hourHand = hourHand;
    }
}
