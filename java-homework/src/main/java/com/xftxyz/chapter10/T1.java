package com.xftxyz.chapter10;

public class T1 {

    public static void main(String[] args) {
        Time t1 = new Time();
        Time t2 = new Time(555550000L);

        System.out.println(t1);
        System.out.println(t2);
    }
}

class Time {
    private long hour;
    private long minute;
    private long second;

    Time() {
        this(System.currentTimeMillis());
    }

    Time(long elapsedTime) {
        setTime(elapsedTime);
    }

    Time(long hour, long minute, long second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public long getHour() {
        return hour;
    }

    public long getMinute() {
        return minute;
    }

    public long getSecond() {
        return second;
    }

    public void setTime(long elapsedTime) {
        long totalSeconds = elapsedTime / 1000;
        second = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        minute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        hour = totalHours % 24;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}