package com.robot.app.entities;

import junit.framework.TestCase;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by williamhu on 7/6/17.
 */
public class RobotTest extends TestCase {
    private Robot robot;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        super.setUp();
        this.robot = new Robot();
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        robot = null;
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void test_robot_constructor() throws Exception {
        assertNotNull(robot);
    }

    @Test
    public void test_rebot_report() throws Exception {
        robot.receiveCommand("REPORT");
        assertEquals("", outContent.toString());
    }

    @Test
    public void test_rebot_report_invalid_command() throws Exception {
        robot.receiveCommand("WHAT UP");
        robot.receiveCommand("REPORT");
        assertEquals("", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_place_north() throws Exception {
        robot.receiveCommand("PLACE 0,0,NORTH");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 0,0,NORTH", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_place_south() throws Exception {
        robot.receiveCommand("PLACE 0,0,SOUTH");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 0,0,SOUTH", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_place_east() throws Exception {
        robot.receiveCommand("PLACE 0,0,EAST");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 0,0,EAST", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_place_west() throws Exception {
        robot.receiveCommand("PLACE 0,0,WEST");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 0,0,WEST", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_place_invalid_location() throws Exception {
        robot.receiveCommand("PLACE 9,10,NORTH");
        robot.receiveCommand("REPORT");
        assertEquals("", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_place_negative_location() throws Exception {
        robot.receiveCommand("PLACE -2,-1,NORTH");
        robot.receiveCommand("REPORT");
        assertEquals("", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_place_invalid_direction() throws Exception {
        robot.receiveCommand("PLACE 1,3,UP");
        robot.receiveCommand("REPORT");
        assertEquals("", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_move_without_place() throws Exception {
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_move_north_1() throws Exception {
        robot.receiveCommand("PLACE 0,1,NORTH");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 0,2,NORTH", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_move_north_2() throws Exception {
        robot.receiveCommand("PLACE 0,1,NORTH");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 0,3,NORTH", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_move_north_over() throws Exception {
        robot.receiveCommand("PLACE 0,3,NORTH");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 0,4,NORTH", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_move_east_1() throws Exception {
        robot.receiveCommand("PLACE 0,1,EAST");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 1,1,EAST", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_move_east_2() throws Exception {
        robot.receiveCommand("PLACE 0,1,EAST");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 2,1,EAST", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_move_east_over() throws Exception {
        robot.receiveCommand("PLACE 3,1,EAST");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 4,1,EAST", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_move_west_1() throws Exception {
        robot.receiveCommand("PLACE 3,1,WEST");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 2,1,WEST", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_move_west_2() throws Exception {
        robot.receiveCommand("PLACE 3,1,WEST");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 1,1,WEST", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_move_west_over() throws Exception {
        robot.receiveCommand("PLACE 1,1,WEST");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 0,1,WEST", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_move_south_1() throws Exception {
        robot.receiveCommand("PLACE 3,3,SOUTH");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 3,2,SOUTH", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_move_south_2() throws Exception {
        robot.receiveCommand("PLACE 3,3,SOUTH");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 3,1,SOUTH", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_move_south_over() throws Exception {
        robot.receiveCommand("PLACE 1,1,SOUTH");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 1,0,SOUTH", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_left_south() throws Exception {
        robot.receiveCommand("PLACE 1,1,SOUTH");
        robot.receiveCommand("LEFT");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 1,1,EAST", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_left_west() throws Exception {
        robot.receiveCommand("PLACE 1,1,WEST");
        robot.receiveCommand("LEFT");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 1,1,SOUTH", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_left_north() throws Exception {
        robot.receiveCommand("PLACE 1,1,NORTH");
        robot.receiveCommand("LEFT");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 1,1,WEST", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_left_east() throws Exception {
        robot.receiveCommand("PLACE 1,1,EAST");
        robot.receiveCommand("LEFT");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 1,1,NORTH", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_right_south() throws Exception {
        robot.receiveCommand("PLACE 1,1,SOUTH");
        robot.receiveCommand("RIGHT");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 1,1,WEST", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_right_west() throws Exception {
        robot.receiveCommand("PLACE 1,1,WEST");
        robot.receiveCommand("RIGHT");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 1,1,NORTH", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_right_north() throws Exception {
        robot.receiveCommand("PLACE 1,1,NORTH");
        robot.receiveCommand("RIGHT");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 1,1,EAST", outContent.toString());
    }

    @Test
    public void test_rebot_ReceiveCommand_right_east() throws Exception {
        robot.receiveCommand("PLACE 1,1,EAST");
        robot.receiveCommand("RIGHT");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 1,1,SOUTH", outContent.toString());
    }

    @Test
    public void test_rebot_example_a() throws Exception {
        robot.receiveCommand("PLACE 0,0,NORTH");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 0,1,NORTH", outContent.toString());
    }

    @Test
    public void test_rebot_example_b() throws Exception {
        robot.receiveCommand("PLACE 0,0,NORTH");
        robot.receiveCommand("LEFT");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 0,0,WEST", outContent.toString());
    }

    @Test
    public void test_rebot_example_c() throws Exception {
        robot.receiveCommand("PLACE 1,2,EAST");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("LEFT");
        robot.receiveCommand("MOVE");
        robot.receiveCommand("REPORT");
        assertEquals("Output: 3,3,NORTH", outContent.toString());
    }


}