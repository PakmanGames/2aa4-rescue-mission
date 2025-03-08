package ca.mcmaster.se2aa4.island.teamXXX;

public class DynamicPosition extends Position {
    public DynamicPosition(int x, int y) {
        super(x, y);
    }

    public void fly(Direction direction) {
        switch (direction) {
            case NORTH:
                setY(getY() + 3);
                break;
            case EAST:
                setX(getX() + 3);
                break;
            case SOUTH:
                setY(getY() - 3);
                break;
            case WEST:
                setX(getX() - 3);
                break;
        }
    }

    private boolean isValidHeading(Direction currentDirection, Direction newDirection) {
        return currentDirection.getOppositeDirection() != newDirection;
    }

    // TODO mediocre software design, there's probably a better way to do this instead of all the if and else if :skull:
    public void heading(Direction currentDirection, Direction newDirection) {
        if (!isValidHeading(currentDirection, newDirection)) {
            throw new IllegalArgumentException("Invalid heading");
        }

        switch (newDirection) {
            case NORTH:
                if (currentDirection.equals("E")) {
                    setY(getY() + 3);
                    setX(getX() + 3);
                } else if (currentDirection.equals("W")) {
                    setY(getY() + 3);
                    setX(getX() - 3);
                }
                break;
            case SOUTH:
                if (currentDirection.equals("E")) {
                    setY(getY() - 3);
                    setX(getX() + 3);
                } else if (currentDirection.equals("W")) {
                    setY(getY() - 3);
                    setX(getX() - 3);
                }
                break;
            case EAST:
                if (currentDirection.equals("N")) {
                    setX(getX() + 3);
                    setY(getY() + 3);
                } else if (currentDirection.equals("S")) {
                    setX(getX() + 3);
                    setY(getY() - 3);
                }
                break;
            case WEST:
                if (currentDirection.equals("N")) {
                    setX(getX() - 3);
                    setY(getY() + 3);
                } else if (currentDirection.equals("S")) {
                    setX(getX() - 3);
                    setY(getY() - 3);
                }
                break;
        }
    }
}