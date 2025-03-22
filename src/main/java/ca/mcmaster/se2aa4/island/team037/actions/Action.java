package ca.mcmaster.se2aa4.island.team037.actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

public interface Action {
    public ActionType type();

    public JSONObject json();

    public void consume(Drone drone, ActionResult result);
}
