package com.robot.app.entities.enums;

/**
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
