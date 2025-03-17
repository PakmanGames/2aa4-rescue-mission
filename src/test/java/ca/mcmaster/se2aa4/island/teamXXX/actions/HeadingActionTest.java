package ca.mcmaster.se2aa4.island.teamXXX.actions;

import org.json.JSONObject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.island.teamXXX.drone.Direction;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

public class HeadingActionTest {
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
        //todo
    }
}
