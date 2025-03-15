package ca.mcmaster.se2aa4.island.teamXXX.mvp;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.teamXXX.actions.ActionResult;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;

public class StartState extends State {

    public StartState(Drone drone) {
        super(drone);
    }

    @Override
    public State nextState(ActionResult action) {
        return new StopState(getDrone());
    }

    @Override
    public JSONObject getAction() {
        return getDrone().fly();
    }

}
