package ca.mcmaster.se2aa4.island.team037.algorithm.spiral;

import ca.mcmaster.se2aa4.island.team037.actions.Action;
import ca.mcmaster.se2aa4.island.team037.actions.ActionType;
import ca.mcmaster.se2aa4.island.team037.algorithm.State;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

public class SpiralState extends State {
    private int padding;
    private int currentPadding;
    private Action action;
    private boolean second;

    public SpiralState(Drone drone) {
        super(drone);
        padding = 0;
        currentPadding = 0;
        action = drone.scan();
        second = true;
    }

    @Override
    public State nextState(ActionResult result) {
        // If the state still has work to be done then it should go to the current state
        // Otherwise it should go to the StopState
        Drone drone = getDrone();
        action.consume(drone, result);

        // Ensure the battery is a good amount
        if (drone.getBatteryLevel() < 35) {
            return new StopState(drone);
        }

        return this;
    }

    @Override
    public Action getAction() {
        Drone drone = getDrone();
        Action nextAction;
        if (action.type() == ActionType.SCAN) {
            if (currentPadding == 0) {
                nextAction = drone.head(drone.getDirection().right());
                second = !second;
                if (second) {
                    padding++;
                }
                currentPadding = padding;
            } else {
                nextAction = drone.fly();
                currentPadding--;
            }
        } else {
            nextAction = drone.scan();
        }

        action = nextAction;
        return nextAction;
    }

}
