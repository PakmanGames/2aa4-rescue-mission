package ca.mcmaster.se2aa4.island.team037.drone;

import ca.mcmaster.se2aa4.island.team037.actions.Action;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

public interface Drone {

    // Gets the direction of the drone
    public Direction getDirection();

    // Gets the current position of the drone
    public Position getPosition();

    public void setPosition(Position position);

    // Gets the battery level of the drone
    public int getBatteryLevel();

    public MapInfo getMapInfo();

    public Action fly();

    public void consumeFly(ActionResult result);

    public Action scan();

    public void consumeScan(ActionResult result);

    public Action echo(Direction heading);

    public void consumeEcho(Direction direction, ActionResult result);

    public Action head(Direction heading);

    public void consumeHead(Direction direction, ActionResult result);

    public Action stop();

    public void consumeStop(ActionResult result);

    public void consume(Action action, ActionResult result);
}
