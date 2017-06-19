# RobotMovement
A program to solve the robot movement problem.

## Installation
- Clone the project 
- Nevigate to the installed directory
```
mvn clean install
java -cp target/robot-movement-1.0-SNAPSHOT.jar com.robot.app.App
```

## Test
```
mvn test
```

## Usage

- PLACE X,Y,F
- MOVE
- LEFT
- RIGHT
- REPORT

X and Y can be any integer number between 0 - 4. Anything outside the range will be ignored.
 
F can be 
- NORTH
- SOUTH 
- EAST
- WEST

anything other than this will be ignored.
