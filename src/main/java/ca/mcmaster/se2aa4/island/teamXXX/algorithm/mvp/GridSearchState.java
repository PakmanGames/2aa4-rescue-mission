package ca.mcmaster.se2aa4.island.teamXXX.algorithm.mvp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.island.teamXXX.actions.Action;
import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionType;
import ca.mcmaster.se2aa4.island.teamXXX.algorithm.State;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Direction;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.drone.MapInfo;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Position;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

/**
 * Start state of the drone algorithm
 * This state will be grid-searching the map trying to pick up any creeks and
 * sites of interest
 * 
 * For MVP, we will assume that the drone starts at (1,1)
 */
public class GridSearchState extends State {
    /// The algorithm
    /// If the drone is not facing the end of the map (vertically) do the following
    /// 1. Move forward
    /// 2. scan the area and add any poi's found to the map
    /// Else if the drone is at the end of the map (horizontally) do the following
    /// 1. stop
    /// Else
    /// 1. If facing south, turn left, then left
    /// 2. If facing north, turn right, then right
    private Action action;
    private boolean changingDirection;

    private final Logger logger = LogManager.getLogger();

    public GridSearchState(Drone drone) {
        super(drone);
        // Dummy fly action
        action = drone.fly();
        changingDirection = false;

        logger.info("Map Dimensions ({},{})", drone.getMapInfo().getWidth(), drone.getMapInfo().getHeight());
    }

    @Override
    public State nextState(ActionResult result) {

        Drone drone = getDrone();
        action.consume(drone, result);

        Position position = drone.getPosition();
        MapInfo mapInfo = drone.getMapInfo();
        logger.info("Position: {}, Direction: {}", position, drone.getDirection());

        if (drone.getBatteryLevel() < 35) {
            return new StopState(drone);
        }

        if (action.type() == ActionType.FLY) {

            // Direction DOWN or Direction UP
            if (drone.getDirection() == Direction.SOUTH) {
                // If the drone is not facing the end of the map (vertically) do the following
                if (position.getY() + 6 >= mapInfo.getHeight() && position.getX() + 6 > mapInfo.getWidth()) {
                    return new StopState(drone);
                }
            } else if (drone.getDirection() == Direction.NORTH) {
                if (position.getY() - 6 < 1 && position.getX() + 6 > mapInfo.getWidth()) {
                    return new StopState(drone);
                }

            }

        }

        return this;
    }

    @Override
    public Action getAction() {
        Drone drone = getDrone();
        Position position = drone.getPosition();
        MapInfo mapInfo = drone.getMapInfo();
        Direction currentDirection = drone.getDirection();

        if (action.type() == ActionType.FLY) {
            action = drone.scan();
        } else if (action.type() == ActionType.HEADING) {
            if (changingDirection) {
                changingDirection = false;
                action = drone.fly();
            } else {
                changingDirection = true;
                if (position.getY() + 6 >= mapInfo.getHeight()) {
                    // If the drone is not facing the end of the map (vertically) do the following
                    action = drone.head(currentDirection.left());
                } else {
                    // If the drone is not facing the end of the map (vertically) do the following
                    action = drone.head(currentDirection.right());
                }
            }

        } else if (action.type() == ActionType.SCAN) {
            if (currentDirection == Direction.SOUTH && position.getY() + 6 >= mapInfo.getHeight()) {
                // If the drone is not facing the end of the map (vertically) do the following
                action = drone.head(currentDirection.left());
            } else if (currentDirection == Direction.NORTH && position.getY() - 6 < 1) {
                // If the drone is not facing the end of the map (vertically) do the following
                action = drone.head(currentDirection.right());
            } else {
                action = drone.fly();
            }
        }

        return action;
    }

}
