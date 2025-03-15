package ca.mcmaster.se2aa4.island.teamXXX.drone;

import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionManager;

public class Drone {
    private Direction direction;
    private Position position;
    private int batteryLevel;
    private ActionManager actionManager;
    private MapInfo mapInfo;

    public Drone(Direction initialDirection, int batteryLevel, ActionManager actionManager) {
        this.direction = initialDirection;
        this.batteryLevel = batteryLevel;
        this.actionManager = actionManager;
        this.mapInfo = new MapInfo();
    }

    // Gets the direction of the drone
    public Direction getDirection() {
        return direction;
    }

    // Gets the current position of the drone
    public Position getPosition() {
        return position;
    }

    // Sets the initial position of the drone
    public void initializePosition(Position position) {
        this.position = position;
    }

    // Gets the battery level of the drone
    public int getBatteryLevel() {
        return batteryLevel;
    }

    public MapInfo getMapInfo() {
        return mapInfo;
    }

    public String fly() {
        return actionManager.createFlyCommand();
    }

    public String scan() {
        return actionManager.createScanCommand();
    }

    public String echo(Direction heading) {
        return actionManager.createEchoCommand(heading);
    }

    public String head(Direction heading) {
        return actionManager.createHeadingCommand(heading);
    }

    public String stop() {
        return actionManager.createStopCommand();
    }
}
