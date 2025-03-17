package ca.mcmaster.se2aa4.island.teamXXX;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.island.teamXXX.result.ActionResult;

import static org.junit.jupiter.api.Assertions.*;

public class ActionResultTest {
    private ActionResultFactory factory = new ActionResultFactory();
    private ActionResult actionResultWithEcho;
    private ActionResult actionResultWithScan;

    @BeforeEach
    public void initialize() {
        this.actionResultWithEcho = factory.createActionResultWithEcho(10, "OK", 5, "GROUND");
        this.actionResultWithScan = factory.createActionResultWithScan(10, "OK");
    }

    public ActionResult getActionResultWithEcho() {
        return actionResultWithEcho;
    }

    public ActionResult getActionResultWithScan() {
        return actionResultWithScan;
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
}