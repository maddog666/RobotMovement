package com.robot.app.factories;

import com.robot.app.commands.*;
import com.robot.app.entities.enums.Direction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by williamhu on 7/6/17.
 */
public class CommandFactory {
    private static final String COMMAND_PATTERN = "(\\w+)\\s*(\\d+)?,?(\\d+)?,?(\\w+)?";

    public CommandFactory() {
    }

    public Command interpretCommand(String commandString) {
        // Catch when command is too long
        if (commandString.length() > 20) {
            return null;
        }
        Matcher matcher = matchPattern(commandString);

        return matchCommand(matcher);
    }

    private Matcher matchPattern(String commandString) {
        Pattern pattern = Pattern.compile(COMMAND_PATTERN);
        return pattern.matcher(commandString);
    }

    private Command matchCommand(Matcher matcher) {
        Command command = null;
        try {
            while (matcher.find()) {
                switch (matcher.group(1)) {
                    case ("PLACE"):
                        return matchPlaceCommand(matcher);
                    case ("MOVE"):
                        return new MoveCommand();
                    case ("LEFT"):
                        return new DirectionCommand(Command.MoveDirection.LEFT);
                    case ("RIGHT"):
                        return new DirectionCommand(Command.MoveDirection.RIGHT);
                    case ("REPORT"):
                        return new ReportCommand();
                    default:
                        throw new IllegalArgumentException("Invalid command");
                }
            }
        } catch (IllegalArgumentException e) {

        }
        return command;
    }

    private Command matchPlaceCommand(Matcher matcher) throws IllegalArgumentException {
        try {
            return new PlaceCommand(Integer.valueOf(matcher.group(2)),
                    Integer.valueOf(matcher.group(3)),
                    Direction.valueOf(matcher.group(4))
            );
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid command");
        }
    }
}
