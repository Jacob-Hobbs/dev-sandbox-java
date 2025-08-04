package org.example.clockhands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondHandTest {

    @Test
    void givenAddedSecondBeforeFiftyNine_whenIterate_thenSecondAddedSuccessfully() {
        var secondHand = new SecondHand(new MinuteHand());
        secondHand.setSeconds(58);
        secondHand.iterate();
        assertEquals(59, secondHand.getSeconds());
    }

    @Test
    void givenAddedSecondAtFiftyNine_whenIterate_thenSecondAddedSuccessfully() {
        var secondHand = new SecondHand(new MinuteHand());
        secondHand.setSeconds(59);
        secondHand.iterate();
        assertEquals(0, secondHand.getSeconds());
    }

    @Test
    void givenAddedSecondAtFiftyNine_whenIterate_thenMinuteIteratesSuccessfully() {
        var secondHand = new SecondHand(new MinuteHand());
        secondHand.setSeconds(59);
        secondHand.iterate();
        assertEquals(1, secondHand.getMinuteHand().getMinutes());
    }


}