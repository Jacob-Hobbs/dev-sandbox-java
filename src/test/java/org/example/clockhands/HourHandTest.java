package org.example.clockhands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourHandTest {

    @Test
    void givenAddedHourBeforeTwentyTwo_whenIterate_thenHourAddedSuccessfully() {
        var minuteHand = new MinuteHand();
        var hourHand = new HourHand(minuteHand);
        hourHand.setHours(22);
        hourHand.iterate();
        assertEquals(23, hourHand.getHours());
    }

    @Test
    void givenAddedMinuteAtTwentyFour_whenIterate_thenHourAddedSuccessfully() {
        var minuteHand = new MinuteHand();
        var hourHand = new HourHand(minuteHand);
        hourHand.setHours(24);
        hourHand.iterate();
        assertEquals(0, hourHand.getHours());
    }

    @Test
    void givenAddedHourAtTwentyFour_whenIterate_thenSecondIteratesSuccessfully() {
        var minuteHand = new MinuteHand();
        var hourHand = new HourHand(minuteHand);
        hourHand.setHours(24);
        hourHand.iterate();
        assertEquals(1, hourHand.getSecondHand().getSeconds());
    }

}