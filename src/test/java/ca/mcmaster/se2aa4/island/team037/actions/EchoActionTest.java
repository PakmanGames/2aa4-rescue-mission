package ca.mcmaster.se2aa4.island.team037.actions;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.island.team037.actions.ActionType;
import ca.mcmaster.se2aa4.island.team037.actions.EchoAction;
import ca.mcmaster.se2aa4.island.team037.actions.ActionType;
import ca.mcmaster.se2aa4.island.team037.actions.EchoAction;
import ca.mcmaster.se2aa4.island.team037.drone.Direction;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;
import ca.mcmaster.se2aa4.island.team037.drone.DroneFactory;

public class EchoActionTest {
    private DroneFactory factory = new DroneFactory();

    @Test
    public void testEchoAction() {
        EchoAction action = new EchoAction(Direction.NORTH);
        assertEquals(ActionType.ECHO, action.type());
        JSONObject json = action.json();
        assertEquals("echo", json.getString("action"));
        assertEquals("N", json.getJSONObject("parameters").getString("direction"));
    }

    @Test
    public void testEchoActionConsume() {
        EchoAction action = new EchoAction(Direction.NORTH);
        JSONObject json = new JSONObject();
        json.put("cost", 1);
        json.put("status", "OK");
        JSONObject extras = new JSONObject();
        extras.put("range", 3);
        extras.put("found", "GROUND");
        json.put("extras", extras);
        ActionResult result = new ActionResult(json);
        action.consume(factory.getDrone(), result);
    }
}
