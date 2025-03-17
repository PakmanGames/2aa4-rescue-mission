package ca.mcmaster.se2aa4.island.teamXXX.actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

public class StopAction implements Action {

    @Override
    public void consume(Drone drone, ActionResult result) {
    }

    @Override
    public ActionType type() {
        return ActionType.STOP;
    }

    @Override
    public JSONObject json() {
        JSONObject command = new JSONObject();
        command.put("action", "stop");
        return command;
    }
}
