package org.example.clockhands;

import org.example.clockwork.ClockBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourHandTest {

    @Test
    void givenAddedHourBeforeTwentyThree_whenIterate_thenHourAddedSuccessfully() {
        ClockBuilder clockBuilder = new ClockBuilder();
        HourHand hourHand = clockBuilder.getHourHand();
        hourHand.setHours(22);
        hourHand.iterate();
        assertEquals(23, hourHand.getHours());
    }

    @Test
    void givenAddedHourAtTwentyThree_whenIterate_thenHourSetToZero() {
        ClockBuilder clockBuilder = new ClockBuilder();
        HourHand hourHand = clockBuilder.getHourHand();
        hourHand.setHours(23);
        hourHand.iterate();
        assertEquals(0, hourHand.getHours());
    }

}