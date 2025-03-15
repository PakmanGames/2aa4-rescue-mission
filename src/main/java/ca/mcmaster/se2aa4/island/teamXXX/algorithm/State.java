package ca.mcmaster.se2aa4.island.teamXXX.algorithm;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionResult;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;

public abstract class State {
    private Drone drone;

    public State(Drone drone) {
        this.drone = drone;
    }

    public Drone getDrone() {
        return drone;
    }

    public abstract State nextState(ActionResult action);

    public abstract JSONObject getAction();

}
