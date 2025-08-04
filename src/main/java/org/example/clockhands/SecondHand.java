package org.example.clockhands;

import org.example.clockhands.ClockHand;

public class SecondHand implements ClockHand {

    private int seconds;
    private MinuteHand minuteHand;

    public SecondHand() {}

    @Override
    public void iterate() {
        try {
            if (this.seconds < 59) {
                this.seconds += 1;
            } else {
                this.seconds = 0;
                minuteHand.iterate();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setSeconds(int newSeconds) {
        this.seconds = newSeconds;
    }
}
