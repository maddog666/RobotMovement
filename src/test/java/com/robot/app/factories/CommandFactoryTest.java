package com.robot.app.factories;

import com.robot.app.commands.*;
import com.robot.app.entities.enums.Direction;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

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
    public void test_intepretCommand_place_x() throws Exception {
        Command command = factory.interpretCommand("PLACE 1,2,SOUTH");
        assertThat(command, instanceOf(PlaceCommand.class));

        PlaceCommand placeCommand = (PlaceCommand)command;
        assertEquals(placeCommand.getX(), Integer.valueOf(1));
    }

    @Test
    public void test_intepretCommand_place_y() throws Exception {
        Command command = factory.interpretCommand("PLACE 1,5,SOUTH");
        assertThat(command, instanceOf(PlaceCommand.class));

        PlaceCommand placeCommand = (PlaceCommand)command;
        assertEquals(placeCommand.getY(), Integer.valueOf(5));
    }

    @Test
    public void test_intepretCommand_place_south() throws Exception {
        Command command = factory.interpretCommand("PLACE 1,2,SOUTH");
        assertThat(command, instanceOf(PlaceCommand.class));

        PlaceCommand placeCommand = (PlaceCommand)command;
        assertEquals(placeCommand.getFace(), Direction.SOUTH);
    }

    @Test
    public void test_intepretCommand_place_east() throws Exception {
        Command command = factory.interpretCommand("PLACE 1,2,EAST");
        assertThat(command, instanceOf(PlaceCommand.class));

        PlaceCommand placeCommand = (PlaceCommand)command;
        assertEquals(placeCommand.getFace(), Direction.EAST);
    }

    @Test
    public void test_intepretCommand_place_north() throws Exception {
        Command command = factory.interpretCommand("PLACE 1,2,NORTH");
        assertThat(command, instanceOf(PlaceCommand.class));

        PlaceCommand placeCommand = (PlaceCommand)command;
        assertEquals(placeCommand.getFace(), Direction.NORTH);
    }

    @Test
    public void test_intepretCommand_place_west() throws Exception {
        Command command = factory.interpretCommand("PLACE 1,2,WEST");
        assertThat(command, instanceOf(PlaceCommand.class));

        PlaceCommand placeCommand = (PlaceCommand)command;
        assertEquals(placeCommand.getFace(), Direction.WEST);
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

    @Test
    public void test_intepretCommand_place_invalid_direction() throws Exception {
        Command command = factory.interpretCommand("PLACE 1,2,SOMEWHERE");
        assertNull(command);
    }

    @Test
    public void test_intepretCommand_place_invalid_X() throws Exception {
        Command command = factory.interpretCommand("PLACE a,2,SOMEWHERE");
        assertNull(command);
    }

    @Test
    public void test_intepretCommand_invalid_command() throws Exception {
        Command command = factory.interpretCommand("SOMETHING RANDOM");
        assertNull(command);
    }


    @Test
    public void test_intepretCommand_place_invalid_Y() throws Exception {
        Command command = factory.interpretCommand("PLACE 1,b,SOMEWHERE");
        assertNull(command);
    }

    @Test
    public void test_intepretCommand_invalid_command_2() throws Exception {
        Command command = factory.interpretCommand("SOMETHING 1,2,SOMEWHERE");
        assertNull(command);
    }

    @Test
    public void test_intepretCommand_long_command() throws Exception {
        Command command = factory.interpretCommand("SOMETHING RANDOM THAT MIGHT BE TOO LONG TO INTERPRET");
        assertNull(command);
    }


}
