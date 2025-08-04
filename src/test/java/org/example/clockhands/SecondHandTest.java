package org.example.clockhands;

import org.example.clockwork.ClockBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondHandTest {

    @Test
    void givenAddedSecondBeforeFiftyNine_whenIterate_thenSecondAddedSuccessfully() {
        ClockBuilder clockBuilder = new ClockBuilder();
        SecondHand secondHand = clockBuilder.getSecondHand();
        secondHand.setSeconds(58);
        secondHand.iterate();
        assertEquals(59, secondHand.getSeconds());
    }

    @Test
    void givenAddedSecondAtFiftyNine_whenIterate_thenSecondAddedSuccessfully() {
        ClockBuilder clockBuilder = new ClockBuilder();
        SecondHand secondHand = clockBuilder.getSecondHand();
        secondHand.setSeconds(59);
        secondHand.iterate();
        assertEquals(0, secondHand.getSeconds());
    }

    @Test
    void givenAddedSecondAtFiftyNine_whenIterate_thenMinuteAddedSuccessfully() {
        ClockBuilder clockBuilder = new ClockBuilder();
        SecondHand secondHand = clockBuilder.getSecondHand();
        MinuteHand minuteHand = clockBuilder.getMinuteHand();
        secondHand.setSeconds(59);
        secondHand.iterate();
        assertEquals(1, minuteHand.getMinutes());
    }



}