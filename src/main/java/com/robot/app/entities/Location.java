package com.robot.app.entities;

/**
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

    public boolean isValidLocation() {
        return x >= MIN_X &&
                x <= MAX_X &&
                y >= MIN_Y &&
                y <= MAX_Y;
    }

    public static int getMaxWidth() {
        return MAX_X - MIN_X + 1;
    }

    public static int getMaxHeight() {
        return MAX_Y - MIN_Y + 1;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Location moveNorth() {
        if (y < MAX_Y) {
            y++;
        }
        return this;
    }

    public Location moveEast() {
        if (x < MAX_X) {
            x++;
        }
        return this;
    }

    public Location moveWest() {
        if (x > MIN_X) {
            x--;
        }
        return this;
    }

    public Location moveSouth() {
        if (y > MIN_Y) {
            y--;
        }
        return this;
    }
}
