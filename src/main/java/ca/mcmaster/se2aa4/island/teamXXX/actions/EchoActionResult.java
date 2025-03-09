package ca.mcmaster.se2aa4.island.teamXXX.actions;

/**
 * Represents information about the ground from range when using the echo
 * command. When the command is invoked at a direction, it either hits island
 * ground or hits the boundary of the map. This can then be used to determine
 * the bounds of the island wherever we start.
 */
public record EchoActionResult(
                /**
                 * The number of 3x3 squares to cross to reach the detected element (either
                 * ground or out of range).
                 */
                int range,
                /**
                 * Whether the detected element is ground or out of range.
                 */
                boolean foundGround) {

        @Override
        public String toString() {
                return String.format("EchoActionResult[range=%d, found=%s]", range,
                                foundGround ? "GROUND" : "OUT_OF_RANGE");
        }
}