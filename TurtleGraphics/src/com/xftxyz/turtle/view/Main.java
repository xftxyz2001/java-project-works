package com.xftxyz.turtle.view;

/**
 * Description:
 * 
 * Make an application that instructs a turtle icon on the screen to draw
 * various shapes based on user input. For instance, if the user issues the
 * command “drop pen” the turtle will start a line. If the user then issues the
 * command “move to 1,1” it will then draw that line from its current position
 * to coordinates 1,1... which then makes a line. The user can then tell the
 * turtle to “lift pen” where it will then end the line. The program should
 * allow the user to instruct the turtle how to draw lines, move to various
 * coordinates and drop or lift its pen.
 * 
 * Tips:
 * 
 * This type of program is great if you wish to learn how to take in user
 * instructions, parse them and then translate them into actions the turtle on
 * screen does. So the first part is to come up with a syntax for commands that
 * the program can parse. For instance, perhaps the command is “DROP” and the
 * object is “PEN” in which case you can tell the turtle to drop its pen. If the
 * user enters “DROP MARKER” it would see “DROP” and understand it, but would
 * not understand “MARKER” so it would issue an error. Once you have a function
 * that can parse various commands, all that is left is to instruct the turtle
 * what to do. It is suggested that you create various functions that you can
 * call to control the turtle. You could even make a Turtle class and have
 * various methods to control it.
 * 
 * Added Difficulty:
 * 
 * Have the turtle draw a star from its current location with one command
 */
public class Main {
    public static void main(String[] args) {
        new TurtleGraphicsView("海龟绘图");
    }
}
