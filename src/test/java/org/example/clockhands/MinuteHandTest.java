package org.example.clockhands;

import org.example.clockwork.ClockBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinuteHandTest {

    @Test
    void givenAddedMinuteBeforeFiftyNine_whenIterate_thenMinuteAddedSuccessfully() {
        ClockBuilder clockBuilder = new ClockBuilder();
        MinuteHand minuteHand = clockBuilder.getMinuteHand();
        minuteHand.setMinutes(58);
        minuteHand.iterate();
        assertEquals(59, minuteHand.getMinutes());
    }

    @Test
    void givenAddedMinuteAtFiftyNine_whenIterate_thenMinuteSetToZero() {
        ClockBuilder clockBuilder = new ClockBuilder();
        MinuteHand minuteHand = clockBuilder.getMinuteHand();
        minuteHand.setMinutes(59);
        minuteHand.iterate();
        assertEquals(0, minuteHand.getMinutes());
    }

    @Test
    void givenAddedMinuteAtFiftyNine_whenIterate_thenHourAddedSuccessfully() {
        ClockBuilder clockBuilder = new ClockBuilder();
        MinuteHand minuteHand = clockBuilder.getMinuteHand();
        HourHand hourHand = clockBuilder.getHourHand();
        minuteHand.setMinutes(59);
        minuteHand.iterate();
        assertEquals(1, hourHand.getHours());
    }

}