package com.robot.app.commands;

/**
 * This object is the LEFT or RIGHT direction command containing the direction to move to.
 * Created by williamhu on 15/6/17.
 */
public class DirectionCommand extends Command {
    private MoveDirection direction;

    public DirectionCommand(MoveDirection direction) {
        this.direction = direction;
    }

    public MoveDirection getDirection() {
        return direction;
    }
}
