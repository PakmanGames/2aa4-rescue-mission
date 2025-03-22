package ca.mcmaster.se2aa4.island.teamXXX.actions;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.island.teamXXX.drone.DroneFactory;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

public class StopActionTest {
    private DroneFactory factory = new DroneFactory();

    @Test
    public void testStopAction() {
        StopAction action = new StopAction();
        assertEquals(ActionType.STOP, action.type());
        JSONObject json = action.json();
        assertEquals("stop", json.getString("action"));
    }

    @Test
    public void testStopActionConsume() {
        StopAction action = new StopAction();
        JSONObject json = new JSONObject();
        json.put("cost", 3);
        json.put("extras", new JSONObject());
        json.put("status", "OK");
        ActionResult result = new ActionResult(json);
        action.consume(factory.getDrone(), result);
    }
}
