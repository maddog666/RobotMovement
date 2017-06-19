package com.robot.app.commands;

import com.robot.app.entities.Location;
import com.robot.app.entities.enums.Direction;

/**
 * This object is the PLACE command, containing the initial placing position and the direction it face.
 * Created by williamhu on 7/6/17.
 */
public class PlaceCommand extends Command {
    private final Location location;
    private final Direction face;

    public PlaceCommand(Integer x, Integer y, Direction face) {
        location = new Location(x, y);
        this.face = face;
    }

    public Integer getX() {
        return location.getX();
    }

    public Integer getY() {
        return location.getY();
    }

    public Direction getFace() {
        return face;
    }

    /**
     * This method determine whether the PLACE command containing a valid location.
     * @return
     */
    public boolean isValidLocation() {
        return location.isValidLocation();
    }

    public Location getLocation() {
        return location;
    }
}
