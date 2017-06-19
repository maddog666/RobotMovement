package com.robot.app.entities;

/**
 * This object containing the x, y and logic of location on the grid.
 * Created by williamhu on 16/6/17.
 */
public class Location {
    static final int MAX_X = 4;
    static final int MIN_X = 0;
    static final int MAX_Y = 4;
    static final int MIN_Y = 0;
    private Integer x;
    private Integer y;

    public Location(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Location(int x, int y) {
        this.x = Integer.valueOf(x);
        this.y = Integer.valueOf(y);
    }

    /**
     * Check whether the current location is a valid location.
     *
     * @return if the location is valid.
     */
    public boolean isValidLocation() {
        return x >= MIN_X &&
                x <= MAX_X &&
                y >= MIN_Y &&
                y <= MAX_Y;
    }

    /**
     * Get the maximum allowed width.
     *
     * @return maximum width.
     */
    public static int getMaxWidth() {
        return MAX_X - MIN_X + 1;
    }

    /**
     * Get the maximum allowed height.
     *
     * @return maximum height.
     */
    public static int getMaxHeight() {
        return MAX_Y - MIN_Y + 1;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    /**
     * Move north from the current location.
     *
     * @return The new location after moving north.
     */
    public Location moveNorth() {
        if (y < MAX_Y) {
            y++;
        }
        return this;
    }

    /**
     * Move east from the current location.
     *
     * @return The new location after moving east.
     */
    public Location moveEast() {
        if (x < MAX_X) {
            x++;
        }
        return this;
    }

    /**
     * Move west from the current location.
     *
     * @return The new location after moving west.
     */
    public Location moveWest() {
        if (x > MIN_X) {
            x--;
        }
        return this;
    }

    /**
     * Move south from the current location.
     *
     * @return The new location after moving south.
     */
    public Location moveSouth() {
        if (y > MIN_Y) {
            y--;
        }
        return this;
    }
}
