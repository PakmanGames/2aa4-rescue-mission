package ca.mcmaster.se2aa4.island.teamXXX.actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

public interface Action {
    public ActionType type();

    public JSONObject json();

    public void consume(Drone drone, ActionResult result);
}
