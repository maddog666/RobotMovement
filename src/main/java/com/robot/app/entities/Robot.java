package com.robot.app.entities;

import com.robot.app.commands.*;
import com.robot.app.entities.enums.Direction;
import com.robot.app.factories.CommandFactory;

/**
 * Created by williamhu on 7/6/17.
 */
public class Robot {
    private Location location;
    private Direction face;
    private CommandFactory factory;

    public Robot() {
        this.factory = new CommandFactory();
    }

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

    private Robot report() {
        if (robotPlaced()) {
            System.out.print("Output: " +
                    location.getX().toString() + "," +
                    location.getY().toString() + "," +
                    face.name());
        }

        return this;
    }

    private Robot receivedPlaceCommand(PlaceCommand command) {
        if (command != null && command.isValidLocation()) {
            this.location = command.getLocation();
            this.face = command.getFace();
        }
        return this;
    }


    private Robot receivedMoveCommand(MoveCommand command) {
        if (robotPlaced() && command != null) {
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

    private Robot receivedDirectionCommand(DirectionCommand command) {
        if (robotPlaced() && command != null) {
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

    private Robot receivedReportCommand(ReportCommand command) {
        if (robotPlaced() && command != null) {
            report();
        }
        return this;
    }

    private boolean robotPlaced() {
        if (location != null) {
            return true;
        } else {
            return false;
        }
    }


}
