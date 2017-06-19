package com.robot.app.entities;

import com.robot.app.commands.*;
import com.robot.app.entities.enums.Direction;
import com.robot.app.factories.CommandFactory;

/**
 * This class is the robot object, which stores all the attribute of a robot and its logic for handling commands.
 * Created by williamhu on 7/6/17.
 */
public class Robot {
    private Location location;
    private Direction face;
    private CommandFactory factory;

    public Robot() {
        this.factory = new CommandFactory();
    }

    /**
     * Handling a string command accordingly.
     * @param commandString A command in string.
     * @return The current robot.
     */
    public Robot receiveCommand(String commandString) {
        Command command = factory.interpretCommand(commandString);

        if (command instanceof PlaceCommand) {
            receivedPlaceCommand((PlaceCommand) command);
        } else if (command instanceof MoveCommand) {
            receivedMoveCommand((MoveCommand) command);
        } else if (command instanceof DirectionCommand) {
            receivedDirectionCommand((DirectionCommand) command);
        } else if (command instanceof ReportCommand) {
            receivedReportCommand((ReportCommand) command);
        }
        return this;
    }

    /**
     * Print out the location and direction for report.
     * @return The current robot.
     */
    private Robot report() {
        if (isRobotPlaced()) {
            System.out.println("\nOutput: " +
                    location.getX().toString() + "," +
                    location.getY().toString() + "," +
                    face.name());
        }

        return this;
    }

    /**
     * Handles the logic when a PLACE command was received
     * @param command A PLACE command.
     * @return The current robot.
     */
    private Robot receivedPlaceCommand(PlaceCommand command) {
        if (command != null && command.isValidLocation()) {
            this.location = command.getLocation();
            this.face = command.getFace();
        }
        return this;
    }

    /**
     * Handles the logic when a MOVE command was received
     * @param command A MOVE command.
     * @return The current robot.
     */
    private Robot receivedMoveCommand(MoveCommand command) {
        if (isRobotPlaced() && command != null) {
            switch (face) {
                case SOUTH:
                    location.moveSouth();
                    break;
                case NORTH:
                    location.moveNorth();
                    break;
                case EAST:
                    location.moveEast();
                    break;
                case WEST:
                    location.moveWest();
                    break;
            }
        }
        return this;
    }

    /**
     * Handles the logic when a LEFT or RIGHT command was received.
     * @param command A LEFT or RIGHT Direction command.
     * @return The current robot.
     */
    private Robot receivedDirectionCommand(DirectionCommand command) {
        if (isRobotPlaced() && command != null) {
            switch (command.getDirection()) {
                case LEFT:
                    this.face = this.face.moveLeft();
                    break;
                case RIGHT:
                    this.face = this.face.moveRight();
                    break;
            }
        }
        return this;
    }

    /**
     * Handles the logic when a REPORT command was received.
     * @param command A REPORT command.
     * @return The current robot.
     */
    private Robot receivedReportCommand(ReportCommand command) {
        if (isRobotPlaced() && command != null) {
            report();
        }
        return this;
    }

    /**
     * Check whether the robot had been placed on the grid.
     * @return If the robot was placed on the grid.
     */
    private boolean isRobotPlaced() {
        if (location != null) {
            return true;
        } else {
            return false;
        }
    }


}
