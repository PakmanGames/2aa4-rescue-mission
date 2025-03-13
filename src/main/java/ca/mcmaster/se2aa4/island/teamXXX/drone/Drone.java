package ca.mcmaster.se2aa4.island.teamXXX.drone;

import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionManager;

public class Drone {
    private Direction direction;
    private Position position;
    private int batteryLevel;
    private ActionManager actionManager;

    public Drone(Direction initialDirection, Position initialPosition, int batteryLevel, ActionManager actionManager) {
        this.direction = initialDirection;
        this.position = initialPosition;
        this.batteryLevel = batteryLevel;
        this.actionManager = actionManager;
    }

    public String fly() {
        return actionManager.createFlyCommand();
    }

    public String scan() {
        return actionManager.createScanCommand();
    }

    public String echo(Direction direction) {
        return actionManager.createEchoCommand(direction);
    }

    public String turn(Direction targetDirection) {
        return actionManager.createHeadingCommand(targetDirection);
    }

    public String stop() {
        return actionManager.createStopCommand();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
