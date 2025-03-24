package ca.mcmaster.se2aa4.island.team037.actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

public class ScanAction implements Action {

    @Override
    public void consume(Drone drone, ActionResult result) {
        drone.consumeScan(result);
    }

    @Override
    public ActionType type() {
        return ActionType.SCAN;
    }

    @Override
    public JSONObject json() {
        JSONObject command = new JSONObject();
        command.put("action", "scan");
        return command;
    }
}
