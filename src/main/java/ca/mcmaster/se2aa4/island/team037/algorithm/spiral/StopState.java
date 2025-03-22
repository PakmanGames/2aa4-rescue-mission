package ca.mcmaster.se2aa4.island.team037.algorithm.spiral;

import ca.mcmaster.se2aa4.island.team037.actions.Action;
import ca.mcmaster.se2aa4.island.team037.algorithm.State;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

public class StopState extends State {

    public StopState(Drone drone) {
        super(drone);
    }

    @Override
    public State nextState(ActionResult action) {
        return this;
    }

    @Override
    public Action getAction() {
        return getDrone().stop();
    }

}
