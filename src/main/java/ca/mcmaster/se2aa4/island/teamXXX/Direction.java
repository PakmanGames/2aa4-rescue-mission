package ca.mcmaster.se2aa4.island.teamXXX;

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

    public Boolean equals(Direction d) {
        return this.abbr.equals(d.abbr);
    }
}
