package com.robot.app.entities;

import com.robot.app.commands.Command;
import com.robot.app.entities.enums.Direction;

/**
 * Created by williamhu on 7/6/17.
 */
public class Robot {
    private Integer x;
    private Integer y;
    private Direction face;
    public Robot() {
    }

    public void receiveCommand(Command command) {
        if (true) { // command start with PLACE
            // initiate x, y, and direction
        } else if (x != null && y != null){
            // execute command
        }
    }

    public void report() {
        if (x != null && y != null) {
            System.out.println("OUTPUT: " + x.toString() + "," + y.toString() + "," + face);
        }
    }
}
