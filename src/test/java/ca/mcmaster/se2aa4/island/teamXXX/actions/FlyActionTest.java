package ca.mcmaster.se2aa4.island.teamXXX.actions;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Drone;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Position;
import ca.mcmaster.se2aa4.island.teamXXX.drone.Direction;

public class FlyActionTest {
    private Drone drone;

    @BeforeEach
    public void initialize() {
        drone = new Drone(Direction.NORTH, 100, new ActionManager());
        drone.setPosition(new Position(0, 0));
    }

    @Test
    public void testFlyAction() {
        FlyAction action = new FlyAction();
        assertEquals(ActionType.FLY, action.type());
        JSONObject json = action.json();
        assertEquals("fly", json.getString("action"));
    }

    @Test
    public void testFlyActionConsume() {
        FlyAction action = new FlyAction();
        JSONObject json = new JSONObject();
        json.put("cost", 3);
        json.put("status", "OK");
        json.put("extras", new JSONObject());
        ActionResult result = new ActionResult(json);

        action.consume(drone, result);
        assertEquals(new Position(0, -3), drone.getPosition());
    }
}
