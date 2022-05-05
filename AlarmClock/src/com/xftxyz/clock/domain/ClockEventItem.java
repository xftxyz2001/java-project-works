package com.xftxyz.clock.domain;

import java.time.LocalDateTime;

public class ClockEventItem implements Comparable<ClockEventItem> {
    // 时间
    private LocalDateTime eventTime;
    // 事件
    private String event;
    // 是否播放放声音
    private boolean isPlaySound;

    public ClockEventItem(LocalDateTime eventTime, String event, boolean isPlaySound) {
        this.eventTime = eventTime;
        this.event = event;
        this.isPlaySound = isPlaySound;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    // public void setEventTime(LocalDateTime eventTime) {
    // this.eventTime = eventTime;
    // }

    public String getEvent() {
        return event;
    }

    // public void setEvent(String event) {
    // this.event = event;
    // }

    public boolean isPlaySound() {
        return isPlaySound;
    }

    @Override
    public int compareTo(ClockEventItem o) {
        // 时间早的在前
        return this.eventTime.compareTo(o.eventTime);
    }

    public void setPlaySound(boolean playSound) {
    isPlaySound = playSound;
    }
}
