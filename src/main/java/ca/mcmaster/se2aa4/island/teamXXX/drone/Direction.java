package ca.mcmaster.se2aa4.island.teamXXX.drone;

public enum Direction {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private final String abbr;
    private Direction left;
    private Direction right;

    Direction(String abbr) {
        this.abbr = abbr;
    }

    static {
        NORTH.left = WEST;
        NORTH.right = EAST;
        EAST.left = NORTH;
        EAST.right = SOUTH;
        SOUTH.left = EAST;
        SOUTH.right = WEST;
        WEST.left = SOUTH;
        WEST.right = NORTH;
    }

    public String getAbbr() {
        return abbr;
    }

    public Direction getLeft() {
        return left;
    }

    public Direction getRight() {
        return right;
    }

    @Override
    public String toString() {
        return abbr;
    }

    public static Direction getFromAbbr(String abbr) {
        for (Direction dir : Direction.values())
            if (dir.getAbbr().equals(abbr))
                return dir;
        return null;
    }

    public int angleTo(Direction target) {//calculate the angle difference between current direction and target direction
        int currentIndex = this.ordinal();
        int targetIndex = target.ordinal();
        int diff = Math.abs(currentIndex - targetIndex);
        
        if (diff > 2) {
            diff = 4 - diff;//so that the angle difference won't be 270 degrees
        }

        return diff * 90;  
    }

    }
}
