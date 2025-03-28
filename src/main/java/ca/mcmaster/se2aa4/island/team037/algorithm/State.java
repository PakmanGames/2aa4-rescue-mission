package ca.mcmaster.se2aa4.island.team037.algorithm;

import ca.mcmaster.se2aa4.island.team037.actions.Action;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

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
