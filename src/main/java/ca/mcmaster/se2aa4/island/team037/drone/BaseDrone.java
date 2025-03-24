package ca.mcmaster.se2aa4.island.team037.drone;

import ca.mcmaster.se2aa4.island.team037.actions.Action;
import ca.mcmaster.se2aa4.island.team037.actions.ActionManager;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;
import ca.mcmaster.se2aa4.island.team037.result.ScanActionResult;

public class BaseDrone implements Drone {
    private Direction direction;
    private Position position;
    private int batteryLevel;
    private ActionManager actionManager;
    private MapInfo mapInfo;

    public BaseDrone(Direction initialDirection, int batteryLevel, ActionManager actionManager) {
        this.direction = initialDirection;
        this.batteryLevel = batteryLevel;
        this.actionManager = actionManager;
        this.mapInfo = new MapInfo();
    }

    // Gets the direction of the drone
    public Direction getDirection() {
        return direction;
    }

    private void setDirection(Direction direction) {
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

    private void expend(int cost) {
        batteryLevel -= cost;
    }

    @Override
    public void consumeFly(ActionResult result) {
        expend(result.getCost());

        switch (direction) {
            case NORTH:
                position.setY(position.getY() - 3);
                break;
            case EAST:
                position.setX(position.getX() + 3);
                break;
            case SOUTH:
                position.setY(position.getY() + 3);
                break;
            case WEST:
                position.setX(position.getX() - 3);
                break;
        }

    }

    @Override
    public void consumeScan(ActionResult result) {
        expend(result.getCost());
        // Perform the scanning
        ScanActionResult scanResult = result.getScanResult();

        // Add the POIs to the map
        for (String id : scanResult.sites())
            mapInfo.addPOI(new POI(id, position, POIType.SITE));

        // Add the creeks to the map
        for (String id : scanResult.creeks())
            mapInfo.addPOI(new POI(id, position, POIType.CREEK));
    }

    @Override
    public void consumeEcho(Direction direction, ActionResult result) {
        expend(result.getCost());
    }

    @Override
    public void consumeHead(Direction heading, ActionResult result) {
        expend(result.getCost());

        switch (direction) {
            case NORTH:
                position.setY(position.getY() - 3);
                position.setX(position.getX() + 3 * ((heading == Direction.WEST) ? -1 : 1));
                break;
            case EAST:
                position.setX(position.getX() + 3);
                position.setY(position.getY() + 3 * ((heading == Direction.NORTH) ? -1 : 1));
                break;
            case SOUTH:
                position.setY(position.getY() + 3);
                position.setX(position.getX() + 3 * ((heading == Direction.WEST) ? -1 : 1));
                break;
            case WEST:
                position.setX(position.getX() - 3);
                position.setY(position.getY() + 3 * ((heading == Direction.NORTH) ? -1 : 1));
                break;
        }

        setDirection(heading);
    }

    @Override
    public void consumeStop(ActionResult result) {
        expend(result.getCost());
    }

    @Override
    public void consume(Action action, ActionResult result) {
        action.consume(this, result);
    }

}
