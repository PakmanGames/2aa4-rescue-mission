package ca.mcmaster.se2aa4.island.teamXXX.actions;
import org.json.JSONObject;

public class FlyAction implements DroneAction {
    @Override
    public String execute() {
        JSONObject command = new JSONObject();
        command.put("action", "fly");
        return command.toString();
    }
}
