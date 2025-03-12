package ca.mcmaster.se2aa4.island.team37.drone;

/**
 * Represents a Point of Interest (POI) on the island. A POI is a location with
 * a specific type.
 */
public record POI(
        /**
         * ID of the POI
         */
        String id,
        /**
         * Position detected of the POI
         */
        Position position,
        /**
         * Type of the POI
         */
        POIType type) {

    @Override
    public String toString() {
        return String.format("POI[id=%s, position=%s, type=%s]", id, position, type);
    }
}
