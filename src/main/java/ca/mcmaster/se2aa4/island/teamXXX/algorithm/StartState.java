package ca.mcmaster.se2aa4.island.teamXXX.algorithm;

import java.util.Map;

import ca.mcmaster.se2aa4.island.teamXXX.actions.Action;
import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionType;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Direction;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Position;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

/**
 * Start state of the drone algorithm
 * This state will handle getting dimensions of map
 * 
 * For MVP, we will assume that the drone is not near ground (in all directions
 * if extended). Also assume that the drone starts at (1,1)
 */
public class StartState extends State {

    private Map<Direction, Integer> dimensions;
    private Action action;
    private boolean start;

    public StartState(Drone drone) {
        super(drone);
        drone.setPosition(new Position(1, 1));
        start = true;
    }

    @Override
    public State nextState(ActionResult result) {
        Drone drone = getDrone();
        drone.expend(result.getCost());
        action.consume(drone, result);

        Direction currentDirection = drone.getDirection();

        // If you are checking out the range of the direction
        if (action.type() == ActionType.ECHO) {

            // Add the dimensions of the map
            dimensions.put(currentDirection, result.getEchoResult().range());
            return this;
        } else if (action.type() == ActionType.HEADING) {
            // If you are moving to the next direction
            drone.setDirection(currentDirection);

            if (dimensions.size() == 4) {
                // Update the position of the drone and move to grid search state
                int height = (dimensions.get(Direction.NORTH) + dimensions.get(Direction.SOUTH) + 1) * 3;
                int width = (dimensions.get(Direction.EAST) + dimensions.get(Direction.WEST) + 1) * 3;

                // update dimensions and position
                drone.getMapInfo().setDimensions(height, width);

                // If all directions have been checked, move to (1,1)
                return new GridSearchState(drone);
            }

            return this;
        }

        return this;

    }

    @Override
    public Action getAction() {
        Drone drone = getDrone();
        Direction currentDirection = drone.getDirection();

        // Turn right if it is the first action
        if (start) {
            start = false;

            action = drone.head(currentDirection.right());
        } else if (dimensions.containsKey(currentDirection)) {
            // If the direction has been checked, move to the next direction
            action = drone.head(currentDirection.left());

        } else {
            action = drone.echo(currentDirection);
        }

        return action;
    }

}
