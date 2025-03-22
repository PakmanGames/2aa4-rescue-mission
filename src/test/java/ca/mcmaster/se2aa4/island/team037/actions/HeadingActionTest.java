package ca.mcmaster.se2aa4.island.team037.actions;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.island.team037.drone.Direction;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.drone.Position;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

import static org.junit.jupiter.api.Assertions.*;

public class HeadingActionTest {
    private Drone drone;

    @BeforeEach
    public void initialize() {
        drone = new Drone(Direction.NORTH, 100, new ActionManager());
        drone.setPosition(new Position(0, 0));
    }

    @Test
    public void testHeadingAction() {
        HeadingAction action = new HeadingAction(Direction.NORTH);
        assertEquals(ActionType.HEADING, action.type());
        JSONObject json = action.json();
        assertEquals("heading", json.getString("action"));
        assertEquals("N", json.getJSONObject("parameters").getString("direction"));
    }

    @Test
    public void testHeadingActionConsume() {
        HeadingAction action = new HeadingAction(Direction.EAST);
        JSONObject json = new JSONObject();
        json.put("cost", 1);
        json.put("status", "OK");
        JSONObject extras = new JSONObject();
        extras.put("direction", "EAST");
        json.put("extras", extras);
        ActionResult result = new ActionResult(json);

        action.consume(drone, result);
        assertEquals(Direction.EAST, drone.getDirection());
        assertEquals(new Position(3, -3), drone.getPosition());
    }
}
