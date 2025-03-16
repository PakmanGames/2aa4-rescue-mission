package ca.mcmaster.se2aa4.island.teamXXX.algorithm;

import java.util.Map;

import ca.mcmaster.se2aa4.island.teamXXX.actions.Action;
import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionResult;
import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionType;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Direction;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;

/**
 * Start state of the drone algorithm
 * This state will handle getting dimensions of map and getting to (1,1)
 * position
 * 
 * For MVP, we will assume that the drone is not near ground (in all directions
 * if extended)
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

            return this;
        }

        return new GridSearchState(drone);

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

        } else if (dimensions.size() < 4) {
            action = drone.echo(currentDirection);
        }

        return action;
    }

}
