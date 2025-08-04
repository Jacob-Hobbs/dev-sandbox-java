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
        this.secondHand = new SecondHand(minuteHand);
        secondHand.setSeconds(setTimeUnits('S'));
        this.minuteHand = new MinuteHand();
        minuteHand.setMinutes(setTimeUnits('M'));
        this.hourHand = new HourHand(minuteHand);
        hourHand.setHours(setTimeUnits('H'));
    }

    // return current time as String to terminal
    protected String printTime() {
        return "Time: " + secondHand.getSeconds() + ":" + minuteHand.getMinutes() + ":" + hourHand.getHours();
    }

    private static int setTimeUnits(char unit) {
        int time = -1; // sentinel for error
        try {
            String[] timeArray = startTime.split(":");
            switch (unit) {
                case 'H' -> time = Integer.parseInt(timeArray[0]);
                case 'M' -> time = Integer.parseInt(timeArray[1]);
                case 'S' -> time = Integer.parseInt(timeArray[2]);
                default -> System.out.println("Invalid time unit: " + unit);
            }
        } catch (NumberFormatException e) {
            System.out.println("Failed to parse number: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid time format: " + e.getMessage());
        }
        return time;
    }

    // internal clock logic
    protected void clockWork() {
        ClockBuilder clockBuilder = new ClockBuilder();
        String hour = String.valueOf(clockBuilder.getHourHand().getHours());
        String minute = String.valueOf(clockBuilder.getMinuteHand().getMinutes());
        String second = String.valueOf(clockBuilder.getSecondHand().getSeconds());
        System.out.println("Current Time: " + hour + ":" + minute + ":" + second);
    }


}
