package org.example.clockwork;

import org.example.clockhands.HourHand;
import org.example.clockhands.MinuteHand;
import org.example.clockhands.SecondHand;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Clock {

    private String currentTime;
    private static String startTime;
    private SecondHand secondHand;
    private MinuteHand minuteHand;
    private HourHand hourHand;

    // constructor for no start time clock
    protected Clock() {
        startTime = "00:00:00";
        initializeClockHands();
    }

    // constructor for specified start time clock
    protected Clock(String startTime) {
        Clock.startTime = startTime;
        initializeClockHands();
    }

    // set second, minute, and hour hands to chosen times when clock object is instantiated
    private void initializeClockHands() {
        this.secondHand = new SecondHand();
        secondHand.setSeconds(setSeconds());
        this.minuteHand = new MinuteHand();
        minuteHand.setMinutes(setMinutes());
        this.hourHand = new HourHand();
        hourHand.setHours(setHours());

        //System.out.println(this.secondHand.getSeconds());
        //System.out.println(this.minuteHand.getMinutes());
        //System.out.println(this.hourHand.getHours());
    }

    // return current time as String to terminal
    protected String printTime() {
        return "Time: " + secondHand.getSeconds() + ":" + minuteHand.getMinutes() + ":" + hourHand.getHours();
    }

    private static int setSeconds() {
        String[] timeArray = startTime.split(":");
        return Integer.valueOf(timeArray[0]);
    }

    private static int setMinutes() {
        String[] timeArray = startTime.split(":");
        return Integer.valueOf(timeArray[1]);
    }

    private static int setHours() {
        String[] timeArray = startTime.split(":");
        return Integer.valueOf(timeArray[2]);
    }

    // internal clock logic
    protected void clockWork() {


    }


}
