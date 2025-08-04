package org.example.clockwork;

import org.example.clockhands.HourHand;
import org.example.clockhands.MinuteHand;
import org.example.clockhands.SecondHand;

public class ClockBuilder {
    private final HourHand hourHand;
    private final MinuteHand minuteHand;
    private final SecondHand secondHand;

    public ClockBuilder() {
        this.minuteHand = new MinuteHand();
        this.hourHand = new HourHand(minuteHand);
        this.minuteHand.setHourHand(hourHand);
        this.secondHand = new SecondHand(minuteHand);

    }

    public HourHand getHourHand() {
        return hourHand;
    }

    public MinuteHand getMinuteHand() {
        return this.minuteHand;
    }

    public SecondHand getSecondHand() {
        return this.secondHand;
    }
}
