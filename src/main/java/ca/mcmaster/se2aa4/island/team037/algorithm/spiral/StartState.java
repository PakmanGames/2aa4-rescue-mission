package ca.mcmaster.se2aa4.island.team037.algorithm.spiral;

import ca.mcmaster.se2aa4.island.team037.actions.Action;
import ca.mcmaster.se2aa4.island.team037.algorithm.State;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

public class StartState extends State {

    public StartState(Drone drone) {
        super(drone);
    }

    @Override
    public State nextState(ActionResult result) {
        getDrone().scan().consume(getDrone(), result);
        return new DimensionFindingState(getDrone());
    }

    @Override
    public Action getAction() {
        // Just kept this there cuz every other action changes information
        return getDrone().scan();
    }

}
