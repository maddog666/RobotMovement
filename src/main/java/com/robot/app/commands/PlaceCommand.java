package com.robot.app.commands;

import com.robot.app.entities.enums.Direction;

/**
 * Created by williamhu on 7/6/17.
 */
public class PlaceCommand extends Command {
    private final Integer x;
    private final Integer y;
    private final Direction face;

    public PlaceCommand(Integer x, Integer y, Direction face) {
        this.x = x;
        this.y = y;
        this.face = face;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Direction getFace() {
        return face;
    }
}
