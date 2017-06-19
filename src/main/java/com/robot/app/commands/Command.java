package com.robot.app.commands;

/**
 * An Abstract class of Command objects.
 * Created by williamhu on 7/6/17.
 */
public abstract class Command {
    /**
     * An enum objects containing the direction of {@link com.robot.app.commands.MoveCommand}.
     */
    public enum MoveDirection {
        LEFT, RIGHT
    }
}
