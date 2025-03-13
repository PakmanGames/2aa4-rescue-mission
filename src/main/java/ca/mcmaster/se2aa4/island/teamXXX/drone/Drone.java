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
