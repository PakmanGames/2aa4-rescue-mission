package ca.mcmaster.se2aa4.island.teamXXX;

public class DynamicPosition extends Position {
    public DynamicPosition(int x, int y) {
        super(x, y);
    }

    public void move(Direction direction) {
        switch (direction) {
            case NORTH:
                setY(getY() + 1);
                break;
            case EAST:
                setX(getX() + 1);
                break;
            case SOUTH:
                setY(getY() - 1);
                break;
            case WEST:
                setX(getX() - 1);
                break;
        }
    }
}
