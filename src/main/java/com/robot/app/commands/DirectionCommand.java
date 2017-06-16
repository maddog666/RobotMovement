package com.robot.app.commands;

/**
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
