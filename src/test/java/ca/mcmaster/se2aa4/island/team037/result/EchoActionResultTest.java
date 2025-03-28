package ca.mcmaster.se2aa4.island.team037.result;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EchoActionResultTest {
    @Test
    public void testEchoActionResult() {
        EchoActionResult result = new EchoActionResult(5, true);
        assertEquals(5, result.range());
        assertTrue(result.foundGround());
        assertEquals("EchoActionResult[range=5, found=GROUND]", result.toString());
    }

    @Test
    public void testEchoActionResultOutOfRange() {
        EchoActionResult result = new EchoActionResult(0, false);
        assertEquals(0, result.range());
        assertFalse(result.foundGround());
        assertEquals("EchoActionResult[range=0, found=OUT_OF_RANGE]", result.toString());
    }
}
