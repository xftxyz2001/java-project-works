package com.xftxyz.clock.view;

/**
 * Description: Create a program which shows the current time using a label.
 * Allow the user to select a given time and specify a message. When the clock
 * reaches that time, have it pop up a message to the user reminding them of
 * their message and/or play a specific sound file.
 * 
 * Tips:
 * 
 * You will need to be able to get the current time and display it to the user.
 * You will also need a mechanism for saving an “event” which has a specific
 * time and an associated message. Try creating a custom class to hold this
 * information. On each tick of the clock, compare the time to each of the saved
 * scheduled events. If one matches, show the associated message. Be sure to
 * check for multiple events for a given time and possibly throw away any old
 * events (expired) in the system if they are not needed.
 * 
 * Added Difficulty:
 * 
 * Make the clock display graphical using pictures for the numbers. You could
 * also integrate a database to keep track of multiple events much easier. Add
 * an icon to your messages and possibly specify which sound file is to played
 * as the alarm. Remind the user if an event is “overdue” and by how long.
 * 
 * 标题：闹钟
 * 
 * 说明：
 * 
 * 创建一个使用标签显示当前时间的程序。允许用户选择给定时间并指定消息。当时钟到达该时间时，让它弹出一条消息提醒用户他们的消息和/或播放特定的声音文件。
 * 
 * 提示：
 * 
 * 您需要能够获取当前时间并将其显示给用户。您还需要一种机制来保存具有特定时间和关联消息的“事件”。
 * 尝试创建一个自定义类来保存此信息。在时钟的每个滴答声中，将时间与每个保存的计划事件进行比较。
 * 如果其中一条匹配，则显示关联的消息。确保在给定的时间内检查多个事件，如果不需要， 可能会丢弃系统中的任何旧事件（过期）。
 * 
 * 增加的困难：
 * 
 * 使用数字图片使时钟显示为图形。您还可以集成一个数据库，以便更轻松地跟踪多个事件。在消息中添加一个图标，
 * 并可能指定播放哪个声音文件作为警报。提醒用户事件是否“过期”以及过期时间。
 * 
 */

public class AlarmClock {
    public static void main(String[] args) {
        new AlarmClockView("时钟");

    }

}
