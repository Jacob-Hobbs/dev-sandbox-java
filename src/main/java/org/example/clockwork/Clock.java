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

    private final ClockBuilder clockBuilder;

    // constructor for no start time clock
    protected Clock() {
        startTime = "00:00:00";
        this.clockBuilder = new ClockBuilder();
        initializeClockHands();
    }

    // constructor for specified start time clock
    protected Clock(String startTime) {
        this.clockBuilder = new ClockBuilder();
        Clock.startTime = startTime;
        initializeClockHands();
    }

    // set second, minute, and hour hands to chosen times when clock object is instantiated
    private void initializeClockHands() {
        this.clockBuilder.getSecondHand().setSeconds(setTimeUnits('S'));
        this.clockBuilder.getMinuteHand().setMinutes(setTimeUnits('M'));
        this.clockBuilder.getHourHand().setHours(setTimeUnits('H'));
    }

    // return current time as String to terminal
    protected String printTime() {
        return "Time: " + this.clockBuilder.getHourHand().getHours() + ":"
                + this.clockBuilder.getMinuteHand().getMinutes() + ":"
                + this.clockBuilder.getSecondHand().getSeconds();
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
        System.out.println(printTime()); // print out initial time
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            clockBuilder.getSecondHand().iterate(); // increment secondHand
            System.out.println(printTime()); // print out time
        };

        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
    }

}
