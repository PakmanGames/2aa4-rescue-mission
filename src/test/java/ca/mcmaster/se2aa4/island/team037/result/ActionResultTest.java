package ca.mcmaster.se2aa4.island.team037.result;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.island.team037.result.ActionResult;

public class ActionResultTest {
    private ActionResultFactory factory = new ActionResultFactory();
    private ActionResult actionResultWithEcho;
    private ActionResult actionResultWithScan;
    private ActionResult actionResultWithEchoOOR;
    private ActionResult actionResultOOR;

    @BeforeEach
    public void initialize() {
        this.actionResultWithEcho = factory.createActionResultWithEcho(10, "OK", 5, "GROUND");
        this.actionResultWithEchoOOR = factory.createActionResultWithEcho(10, "OK", 0, "OUT_OF_RANGE");
        this.actionResultWithScan = factory.createActionResultWithScan(10, "OK");
        this.actionResultOOR = factory.createAROOR(10, "OK");
    }

    public ActionResult getActionResultWithEcho() {
        return actionResultWithEcho;
    }

    public ActionResult getActionResultWithScan() {
        return actionResultWithScan;
    }

    public ActionResult getActionResultOOR(){
        return actionResultOOR;
    }

    public ActionResult getActionResultwithEchoOOR(){
        return actionResultWithEchoOOR;
    }

    @Test
    public void testActionResultWithEcho() {
        ActionResult result = this.getActionResultWithEcho();
        assertEquals(10, result.getCost());
        assertTrue(result.isOk());
        assertNotNull(result.getEchoResult());
        assertEquals(5, result.getEchoResult().range());
        assertTrue(result.getEchoResult().foundGround());
    }

    @Test
    public void testActionResultWithScan() {
        ActionResult result = this.getActionResultWithScan();
        assertEquals(10, result.getCost());
        assertTrue(result.isOk());
        assertNotNull(result.getScanResult());
        assertTrue(result.getScanResult().creeks().isEmpty());
        assertTrue(result.getScanResult().sites().isEmpty());
    }

    @Test
    public void testActionResultWithEchoAndScanIsNull() {
        ActionResult result = this.getActionResultWithEcho();
        assertNotNull(result.getEchoResult());
        assertNull(result.getScanResult());
    }

    @Test
    public void testActionResultWithScanAndEchoIsNull() {
        ActionResult result = this.getActionResultWithScan();
        assertNotNull(result.getScanResult());
        assertNull(result.getEchoResult());
    }

    @Test
public void testActionResultWithOutOfRangeEcho() {
    ActionResult result = factory.createAROOR(10, "OK");

    assertEquals(10, result.getCost());
    assertTrue(result.isOk());
    assertNotNull(result.getEchoResult());
    assertEquals(0, result.getEchoResult().range()); 
    assertFalse(result.getEchoResult().foundGround()); 
}

}