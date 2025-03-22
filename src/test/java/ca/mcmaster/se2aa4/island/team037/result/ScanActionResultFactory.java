package ca.mcmaster.se2aa4.island.team037.result;

import java.util.Arrays;
import java.util.List;

public class ScanActionResultFactory {
    public List<String> createCreeks() {
        return Arrays.asList("creek_id1", "creek_id2");
    }

    public List<String> createSites() {
        return Arrays.asList("site_id1", "site_id2");
    }

    public ScanActionResult createScanActionResult() {
        List<String> creeks = this.createCreeks();
        List<String> sites = this.createSites();

        return new ScanActionResult(creeks, sites);
    }

    public ScanActionResult createScanActionResultWithNullCreeks() {
        List<String> sites = this.createSites();

        return new ScanActionResult(null, sites);
    }

    public ScanActionResult createScanActionResultWithNullSites() {
        List<String> creeks = this.createCreeks();

        return new ScanActionResult(creeks, null);
    }
}
