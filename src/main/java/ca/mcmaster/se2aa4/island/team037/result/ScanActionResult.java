package ca.mcmaster.se2aa4.island.team037.result;

import java.util.List;

/**
 * Represents the result of a scan action.
 */
public record ScanActionResult(
        /**
         * The list of creeks detected in the scan action.
         */
        List<String> creeks,
        /**
         * The list of emergency sites detected in the scan action.
         */
        List<String> sites) {

    /**
     * Constructs a new instance of the scan action result.
     * 
     * @param creeks the creeks of the scan action
     * @param sites  the emergency sites of the scan action
     * @throws IllegalArgumentException if either creeks or sites are null
     */
    public ScanActionResult {
        if (creeks == null || sites == null) {
            throw new IllegalArgumentException("Creeks and sites must not be null");
        }
    }

    @Override
    public String toString() {
        return String.format("ScanActionResult[creeks=%s, sites=%s]", creeks, sites);
    }
}
