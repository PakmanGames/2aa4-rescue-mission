package ca.mcmaster.se2aa4.island.teamXXX.actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.teamXXX.drone.Direction;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

public record EchoAction(Direction heading) implements Action {

    @Override
    public void consume(Drone drone, ActionResult result) {
    }

    @Override
    public ActionType type() {
        return ActionType.ECHO;
    }

    @Override
    public JSONObject json() {
        JSONObject command = new JSONObject();
        command.put("action", "echo");

        // { 'direction': 'N' }
        JSONObject parameters = new JSONObject();
        parameters.put("direction", heading.toString());

        // { 'action': 'heading', 'parameters': { 'direction': 'N' } }
        command.put("parameters", parameters);
        return command;
    }

}
