package com.robot.app.entities.enums;

/**
 * This is an enum class which store all the possible directions.
 * It containing the logic of turning left and right from a given direction.
 * Created by williamhu on 7/6/17.
 */
public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public String toString(){
        switch(this){
            case NORTH :
                return "NORTH";
            case SOUTH :
                return "SOUTH";
            case EAST :
                return "EAST";
            case WEST :
                return "WEST";
        }
        return "";
    }

    /**
     * Turn left from the current direction.
     *
     * @return The new direction after turning left.
     */
    public Direction moveLeft() {
        switch(this){
            case EAST :
                return NORTH;
            case SOUTH :
                return EAST;
            case WEST :
                return SOUTH;
            case NORTH :
                return WEST;
        }
        return this;
    }

    /**
     * Turn right from the current direction.
     *
     * @return The new direction after turning right.
     */
    public Direction moveRight() {
        switch(this){
            case EAST :
                return SOUTH;
            case SOUTH :
                return WEST;
            case WEST :
                return NORTH;
            case NORTH :
                return EAST;
        }
        return this;
    }
}
