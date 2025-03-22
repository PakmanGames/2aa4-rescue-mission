package ca.mcmaster.se2aa4.island.team037.drone;

import ca.mcmaster.se2aa4.island.team037.actions.Action;
import ca.mcmaster.se2aa4.island.team037.actions.ActionManager;

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

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    // Gets the current position of the drone
    public Position getPosition() {
        return position;
    }

    // Sets the initial position of the drone
    public void setPosition(Position position) {
        this.position = position;
    }

    // Gets the battery level of the drone
    public int getBatteryLevel() {
        return batteryLevel;
    }

    public MapInfo getMapInfo() {
        return mapInfo;
    }

    public Action fly() {
        return actionManager.createFlyCommand();
    }

    public Action scan() {
        return actionManager.createScanCommand();
    }

    public Action echo(Direction heading) {
        return actionManager.createEchoCommand(heading);
    }

    public Action head(Direction heading) {
        return actionManager.createHeadingCommand(heading);
    }

    public Action stop() {
        return actionManager.createStopCommand();
    }

    public void expend(int cost) {
        batteryLevel -= cost;
    }
}
