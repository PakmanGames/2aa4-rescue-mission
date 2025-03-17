package ca.mcmaster.se2aa4.island.teamXXX.algorithm;

import ca.mcmaster.se2aa4.island.teamXXX.actions.Action;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

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
