package com.robot.app.factories;

import com.robot.app.commands.*;
import com.robot.app.entities.enums.Direction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is a factory class for generating {@link com.robot.app.commands.Command} object from a string.
 * Created by williamhu on 7/6/17.
 */
public class CommandFactory {
    // Default format of a command using regular expression.
    private static final String COMMAND_PATTERN = "(\\w+)\\s*(\\d+)?,?(\\d+)?,?(\\w+)?";

    public CommandFactory() {
    }

    /**
     * Translate a string into one of the {@link com.robot.app.commands.Command} subclass. Return null if the command
     * is not a valid command.
     *
     * @param commandString a command in String.
     * @return A {@link com.robot.app.commands.Command} object of the command.
     */
    public Command interpretCommand(String commandString) {
        // Catch when command is too long
        if (commandString.length() > 20) {
            return null;
        }
        Matcher matcher = matchPattern(commandString);

        return matchCommand(matcher);
    }

    /**
     * Match the string command using the default regular expression COMMAND_PATTERN.
     * @param commandString a command string.
     * @return A regular expression matcher to the COMMAND_PATTERN.
     */
    private Matcher matchPattern(String commandString) {
        Pattern pattern = Pattern.compile(COMMAND_PATTERN);
        return pattern.matcher(commandString);
    }

    /**
     * Match the matcher to one of the known command, and return the specific command object accordingly. Return null
     * if the command is invalid.
     * @param matcher regular expresion matcher to the COMMAND_PATTERN.
     * @return A Command object match to the string command. Null if the command string is invalid.
     */
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

    /**
     * Match the PLACE command to the {@link com.robot.app.commands.PlaceCommand}.
     * @param matcher Regular expression matcher to the PLACE command
     * @return An {@link com.robot.app.commands.PlaceCommand} matching to the matcher. Null if invalid.
     * @throws IllegalArgumentException if String command is invalid.
     */
    private PlaceCommand matchPlaceCommand(Matcher matcher) throws IllegalArgumentException {
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
