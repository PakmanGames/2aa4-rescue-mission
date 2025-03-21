package ca.mcmaster.se2aa4.island.teamXXX.result;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ScanActionResultTest {
    private ScanActionResultFactory factory = new ScanActionResultFactory();

    @Test
    public void testScanActionResult() {
        ScanActionResult result = factory.createScanActionResult();
        List<String> creeks = factory.createCreeks();
        List<String> sites = factory.createSites();

        assertEquals(creeks, result.creeks());
        assertEquals(sites, result.sites());
        assertEquals(String.format("ScanActionResult[creeks=%s, sites=%s]", creeks, sites), result.toString());
    }

    @Test
    public void testScanActionResultWithNullCreeks() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.createScanActionResultWithNullCreeks();
        });

        assertEquals("Creeks and sites must not be null", exception.getMessage());
    }

    @Test
    public void testScanActionResultWithNullSites() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.createScanActionResultWithNullSites();
        });

        assertEquals("Creeks and sites must not be null", exception.getMessage());
    }
}
