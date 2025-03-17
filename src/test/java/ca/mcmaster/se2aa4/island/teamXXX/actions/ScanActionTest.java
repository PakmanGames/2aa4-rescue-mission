package ca.mcmaster.se2aa4.island.teamXXX.actions;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ca.mcmaster.se2aa4.island.teamXXX.actions.ScanAction;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;
import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResultFactory;

public class ScanActionTest {
    private ActionResultFactory factory = new ActionResultFactory();

    @Test
    public void testScanAction() {
        ScanAction action = new ScanAction();
        assertEquals(ActionType.SCAN, action.type());
        JSONObject json = action.json();
        assertEquals("scan", json.getString("action"));
    }

    @Test
    public void testScanActionConsume() {
        //todo
    }
}
