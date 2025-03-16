package ca.mcmaster.se2aa4.island.teamXXX.algorithm;

import java.util.Map;

import ca.mcmaster.se2aa4.island.teamXXX.actions.Action;
import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionResult;
import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionType;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Direction;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Position;

/**
 * Start state of the drone algorithm
 * This state will handle getting dimensions of map
 * 
 * For MVP, we will assume that the drone is not near ground (in all directions
 * if extended). Also assume that the drone starts at (1,1)
 */
public class StartState extends State {

    private Map<Direction, Integer> dimensions;
    private Direction currentDirection;
    private Action action;
    private boolean start;

    public StartState(Drone drone) {
        super(drone);
        currentDirection = drone.getDirection();
        start = true;
    }

    @Override
    public State nextState(ActionResult result) {
        Drone drone = getDrone();
        drone.expend(result.getCost());

        // If you are checking out the range of the direction
        if (action.type() == ActionType.ECHO) {

            // Add the dimensions of the map
            dimensions.put(currentDirection, result.getEchoResult().range());
            return this;
        } else if (action.type() == ActionType.HEADING) {
            // If you are moving to the next direction
            drone.setDirection(currentDirection);

            if (dimensions.size() == 4) {
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

        // Turn right if it is the first action
        if (start) {
            start = false;

            currentDirection = currentDirection.right();
            action = drone.head(currentDirection);
        } else if (dimensions.containsKey(currentDirection)) {
            // If the direction has been checked, move to the next direction
            currentDirection = currentDirection.left();
            action = drone.head(currentDirection);

        } else {
            action = drone.echo(currentDirection);
        }

        return action;
    }

}
