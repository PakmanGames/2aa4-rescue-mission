package ca.mcmaster.se2aa4.island.teamXXX.actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.teamXXX.drone.Direction;

public class EchoAction implements DroneAction {
    private Direction direction;

    public EchoAction(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String execute() {
        JSONObject command = new JSONObject();
        command.put("action", "echo");

        JSONObject parameters = new JSONObject();
        parameters.put("direction", direction.toString());

        command.put("parameters", parameters);
        return command.toString();
    }
}
