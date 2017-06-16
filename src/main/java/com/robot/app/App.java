package com.robot.app;

import com.robot.app.entities.Location;
import com.robot.app.entities.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello! Welcome to Robot Movement! Where you can drive a robot car in a " +
                Location.getMaxWidth() +
                " units x " +
                Location.getMaxHeight() +
                " units tabletop!!");

        Robot robot = new Robot();


        try {
            while (true) {
                InputStreamReader reader = new InputStreamReader(System.in);
                BufferedReader in = new BufferedReader(reader);
                String command = in.readLine();
                robot.receiveCommand(command);
            }

        } catch (Exception e) {

            // if any I/O error occurs
            e.printStackTrace();
        }
    }
}
