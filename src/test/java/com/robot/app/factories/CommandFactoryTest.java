package com.robot.app.factories;

import com.robot.app.commands.*;
import com.robot.app.entities.enums.Direction;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.regex.Matcher;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


/**
 * Created by williamhu on 15/6/17.
 */
public class CommandFactoryTest extends TestCase {
    private CommandFactory factory;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        this.factory = new CommandFactory();
    }

    @After
    public void tearDown() {
        factory = null;
    }

    @Test
    public void test_constructor() throws Exception {
        assertNotNull(factory);
    }

    @Test
    public void test_matcher_place() throws Exception {
        Matcher matcher = factory.matchPattern("PLACE 1,2,SOUTH");

        while(matcher.find()) {
            assertThat(matcher.group(1).toString(), is("PLACE"));
            assertThat(matcher.group(2).toString(), is("1"));
            assertThat(matcher.group(3).toString(), is("2"));
            assertThat(matcher.group(4).toString(), is("SOUTH"));
        }
    }

    @Test
    public void test_matcher_report() throws Exception {
        Matcher matcher = factory.matchPattern("REPORT");

        while(matcher.find()) {
            assertThat(matcher.group(1).toString(), is("REPORT"));
        }
    }

    @Test
    public void test_intepretCommand_place() throws Exception {
        Command command = factory.interpretCommand("PLACE 1,2,SOUTH");
        assertThat(command, instanceOf(PlaceCommand.class));

        PlaceCommand placeCommand = (PlaceCommand)command;
        assertEquals(placeCommand.getX(), Integer.valueOf(1));
        assertEquals(placeCommand.getY(), Integer.valueOf(2));
        assertEquals(placeCommand.getFace(), Direction.SOUTH);
    }

    @Test
    public void test_intepretCommand_move() throws Exception {
        Command command = factory.interpretCommand("MOVE");
        assertThat(command, instanceOf(MoveCommand.class));

    }

    @Test
    public void test_intepretCommand_left() throws Exception {
        Command command = factory.interpretCommand("LEFT");
        assertThat(command, instanceOf(DirectionCommand.class));

        DirectionCommand directionCommand = (DirectionCommand)command;
        assertEquals(directionCommand.getDirection(), Command.MoveDirection.LEFT);
    }

    @Test
    public void test_intepretCommand_right() throws Exception {
        Command command = factory.interpretCommand("RIGHT");
        assertThat(command, instanceOf(DirectionCommand.class));

        DirectionCommand directionCommand = (DirectionCommand)command;
        assertEquals(directionCommand.getDirection(), Command.MoveDirection.RIGHT);
    }

    @Test
    public void test_intepretCommand_report() throws Exception {
        Command command = factory.interpretCommand("REPORT");
        assertThat(command, instanceOf(ReportCommand.class));

    }
}
