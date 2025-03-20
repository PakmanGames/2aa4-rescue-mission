package ca.mcmaster.se2aa4.island.teamXXX.actions;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.teamXXX.drone.Direction;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

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
        drone.expend(result.getCost());
        Direction direction = drone.getDirection();

        switch (direction) {
            case NORTH:
                drone.getPosition().setY(drone.getPosition().getY() - 3);
                break;
            case EAST:
                drone.getPosition().setX(drone.getPosition().getX() + 3);
                break;
            case SOUTH:
                drone.getPosition().setY(drone.getPosition().getY() + 3);
                break;
            case WEST:
                drone.getPosition().setX(drone.getPosition().getX() - 3);
                break;
        }

    }

}
