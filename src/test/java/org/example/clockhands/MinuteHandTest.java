package org.example.clockhands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinuteHandTest {

    @Test
    void givenAddedMinuteBeforeFiftyNine_whenIterate_thenMinuteAddedSuccessfully() {
        var minuteHand = new MinuteHand();
        minuteHand.setMinutes(58);
        minuteHand.iterate();
        assertEquals(59, minuteHand.getMinutes());
    }

    @Test
    void givenAddedMinuteAtFiftyNine_whenIterate_thenMinuteAddedSuccessfully() {
        var minuteHand = new MinuteHand();
        minuteHand.setMinutes(59);
        minuteHand.iterate();
        assertEquals(0, minuteHand.getMinutes());
    }

    @Test
    void givenAddedMinuteAtFiftyNine_whenIterate_thenHourIteratesSuccessfully() {
        var minuteHand = new MinuteHand();
        var hourHand = new HourHand(minuteHand);
        minuteHand.setHourHand(hourHand);
        minuteHand.setMinutes(59);
        minuteHand.iterate();
        assertEquals(1, hourHand.getHours());
    }

}