package ca.mcmaster.se2aa4.island.team037.actions;

import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.island.team037.drone.Direction;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.drone.POI;
import ca.mcmaster.se2aa4.island.team037.drone.Position;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;
import ca.mcmaster.se2aa4.island.team037.result.ScanActionResultFactory;

public class ScanActionTest {
    private Drone drone;
    private ScanActionResultFactory factory;

    @BeforeEach
    public void initialize() {
        drone = new Drone(Direction.NORTH, 100, new ActionManager());
        drone.setPosition(new Position(0, 0));
        factory = new ScanActionResultFactory();
    }

    @Test
    public void testScanAction() {
        ScanAction action = new ScanAction();
        assertEquals(ActionType.SCAN, action.type());
        JSONObject json = action.json();
        assertEquals("scan", json.getString("action"));
    }

    @Test
    public void testScanActionConsume() {
        ScanAction action = new ScanAction();
        JSONObject json = new JSONObject();
        json.put("cost", 10);
        json.put("status", "OK");
        JSONObject extras = new JSONObject();
        extras.put("creeks", factory.createCreeks());
        extras.put("sites", factory.createSites());
        extras.put("biomes",List.of());
        json.put("extras", extras);
        ActionResult result = new ActionResult(json);

        action.consume(drone, result);
        assertTrue(drone.getMapInfo().hasCreeks());
        assertTrue(drone.getMapInfo().hasSite());

        assertEquals(factory.createCreeks(), drone.getMapInfo().getCreeks().stream().map(POI::id).collect(Collectors.toList()));
    }
}
