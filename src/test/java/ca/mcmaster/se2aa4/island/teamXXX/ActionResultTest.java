package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

import static org.junit.jupiter.api.Assertions.*;

public class ActionResultTest {
    @Test
    public void testActionResultWithEcho() {
        JSONObject json = new JSONObject();
        json.put("cost", 10);
        json.put("status", "OK");
        JSONObject extras = new JSONObject();
        extras.put("range", 5);
        extras.put("found", "GROUND");
        json.put("extras", extras);

        ActionResult result = new ActionResult(json);
        assertEquals(10, result.getCost());
        assertTrue(result.isOk());
        assertNotNull(result.getEchoResult());
        assertNull(result.getScanResult());
        assertEquals(5, result.getEchoResult().range());
        assertTrue(result.getEchoResult().foundGround());
    }

    @Test
    public void testActionResultWithScan() {
        JSONObject json = new JSONObject();
        json.put("cost", 10);
        json.put("status", "OK");
        JSONObject extras = new JSONObject();
        extras.put("biomes", new JSONArray());
        extras.put("creeks", new JSONArray());
        extras.put("sites", new JSONArray());
        json.put("extras", extras);

        ActionResult result = new ActionResult(json);
        assertEquals(10, result.getCost());
        assertTrue(result.isOk());
        assertNotNull(result.getScanResult());
        assertNull(result.getEchoResult());
        assertTrue(result.getScanResult().creeks().isEmpty());
        assertTrue(result.getScanResult().sites().isEmpty());
    }
}