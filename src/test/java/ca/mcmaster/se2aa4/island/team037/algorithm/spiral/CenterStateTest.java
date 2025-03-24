package ca.mcmaster.se2aa4.island.team037.algorithm.spiral;

import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.island.team037.actions.Action;
import ca.mcmaster.se2aa4.island.team037.actions.ActionManager;
import ca.mcmaster.se2aa4.island.team037.actions.ActionType;
import ca.mcmaster.se2aa4.island.team037.algorithm.State;
import ca.mcmaster.se2aa4.island.team037.drone.BaseDrone;
import ca.mcmaster.se2aa4.island.team037.drone.Direction;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.drone.Position;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

public class CenterStateTest {
    private Drone drone;
    private CenterState centerState;

    public void setUp(Direction direction, Position position) {
        drone = new BaseDrone(direction, 100, new ActionManager());
        drone.getMapInfo().setDimensions(10, 10);
        drone.setPosition(position);
        centerState = new CenterState(drone);
    }

    @Test
    public void testIsCenter() {

        setUp(Direction.EAST, new Position(5, 5));
        assertTrue(centerState.isCenter());

        drone.getPosition().setX(0);// drone is born at corner
        drone.getPosition().setY(0);
        assertFalse(centerState.isCenter());
    }

    @Test
    public void testGetActionHeading() {

        setUp(Direction.EAST, new Position(1, 1));

        Action action = centerState.getAction();
        assertNotNull(action);
        assertEquals(ActionType.FLY, action.type());
    }

    @Test
    public void testGetActionFly() {

        setUp(Direction.EAST, new Position(1, 5));

        Action action = centerState.getAction();
        assertNotNull(action);
        assertEquals(ActionType.FLY, action.type());
    }

    @Test
    public void testNextState() {
        setUp(Direction.NORTH, new Position(0, 0));
        JSONObject json = new JSONObject();
        json.put("cost", 1);
        json.put("status", "OK");
        JSONObject extras = new JSONObject();
        extras.put("someKey", "someValue");
        json.put("extras", extras);
        ActionResult result = new ActionResult(json);

        assertFalse(centerState.isCenter());

        State nextState = centerState.nextState(result);

        if (centerState.isCenter()) {
            assertTrue(nextState instanceof SpiralState);
        } else {
            assertTrue(nextState instanceof CenterState);
        }
    }
}
