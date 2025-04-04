package ca.mcmaster.se2aa4.island.team037.drone;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object p) {
        if (p == null || !(p instanceof Position))
            return false;
        Position position = (Position) p;
        return this.x == position.getX() && this.y == position.getY();
    }

    public double distanceTo(Position p) {
        return Math.hypot(this.x - p.getX(), this.y - p.getY());
    }
}
