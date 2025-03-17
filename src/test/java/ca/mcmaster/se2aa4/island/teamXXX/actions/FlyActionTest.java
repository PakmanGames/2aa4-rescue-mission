package ca.mcmaster.se2aa4.island.teamXXX.actions;

import org.json.JSONObject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

public class FlyActionTest {
    @Test
    public void testFlyAction() {
        FlyAction action = new FlyAction();
        assertEquals(ActionType.FLY, action.type());
        JSONObject json = action.json();
        assertEquals("fly", json.getString("action"));
    }

    @Test
    public void testFlyActionConsume() {
        //todo
    }
}
