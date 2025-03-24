package ca.mcmaster.se2aa4.island.team037.actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

public class FlyAction implements Action {

    public ActionType type() {
        return ActionType.FLY;
    }

    public JSONObject json() {
        JSONObject command = new JSONObject();
        command.put("action", "fly");
        return command;
    }

    public void consume(Drone drone, ActionResult result) {
        drone.consumeFly(result);
    }

}
