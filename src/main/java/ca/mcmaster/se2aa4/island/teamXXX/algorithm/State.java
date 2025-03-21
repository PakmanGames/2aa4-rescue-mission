package ca.mcmaster.se2aa4.island.teamXXX.algorithm;

import ca.mcmaster.se2aa4.island.teamXXX.actions.Action;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

public abstract class State {
    private Drone drone;

    public State(Drone drone) {
        this.drone = drone;
    }

    public Drone getDrone() {
        return drone;
    }

    public abstract State nextState(ActionResult action);

    public abstract Action getAction();

}
