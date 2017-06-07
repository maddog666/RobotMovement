package com.robot.app.entities;

import com.robot.app.entities.enums.Direction;
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
    }

    @After
    public void tearDown() {
        robot = null;
    }

    @Test
    public void testConstructor() throws Exception {
        assertNotNull(robot);
    }

    @Test
    public void testReport() throws Exception {
        System.setOut(new PrintStream(outContent));
        robot.report();
        assertEquals("", outContent.toString());
    }

    @Test
    public void testReceiveCommand() throws Exception {

    }

}