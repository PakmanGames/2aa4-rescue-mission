package ca.mcmaster.se2aa4.island.team037.actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team037.drone.Direction;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

public record HeadingAction(Direction heading) implements Action {

    @Override
    public void consume(Drone drone, ActionResult result) {
        drone.consumeHead(heading, result);
    }

    @Override
    public ActionType type() {
        return ActionType.HEADING;
    }

    @Override
    public JSONObject json() {
        JSONObject command = new JSONObject();
        command.put("action", "heading");

        // { 'direction': 'N' }
        JSONObject parameters = new JSONObject();
        parameters.put("direction", heading.toString());

        // { 'action': 'heading', 'parameters': { 'direction': 'N' } }
        command.put("parameters", parameters);
        return command;
    }
}
