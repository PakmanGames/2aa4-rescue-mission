package ca.mcmaster.se2aa4.island.team037.algorithm.spiral;

import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.island.team037.actions.Action;
import ca.mcmaster.se2aa4.island.team037.actions.ActionManager;
import ca.mcmaster.se2aa4.island.team037.actions.ActionType;
import ca.mcmaster.se2aa4.island.team037.algorithm.State;
import ca.mcmaster.se2aa4.island.team037.drone.Direction;
import ca.mcmaster.se2aa4.island.team037.drone.Drone;
import ca.mcmaster.se2aa4.island.team037.drone.Position;
import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

public class CenterStateTest {
    private Drone drone;
    private CenterState centerState;
    private Action action;

    @BeforeEach
    public void setUp() {
        drone = new Drone(Direction.NORTH, 100, new ActionManager());
        drone.getMapInfo().setDimensions(10, 10);
        drone.setPosition(new Position(0, 0));
        centerState = new CenterState(drone);
    }

    @Test
    public void testIsCenter() {

        drone.getPosition().setX(5);// drone is born at center
        drone.getPosition().setY(5);
        assertTrue(centerState.isCenter());

        drone.getPosition().setX(0);// drone is born at corner
        drone.getPosition().setY(0);
        assertFalse(centerState.isCenter());
    }

    @Test
    public void testGetActionHeading() {

        drone.getPosition().setX(1);
        drone.getPosition().setY(1);
        drone.setDirection(Direction.EAST);

        Action action = centerState.getAction();
        assertNotNull(action);
        assertEquals(ActionType.FLY, action.type());
    }

    @Test
    public void testGetActionFly() {

        drone.getPosition().setX(1);
        drone.getPosition().setY(5);
        drone.setDirection(Direction.EAST);

        Action action = centerState.getAction();
        assertNotNull(action);
        assertEquals(ActionType.FLY, action.type());
    }

    @Test
    public void testNextState() {
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
