package ObjectsClassesPackages.RoboMoving;

/**
 * Class of robot. He can make a step forward, turn left/right in 90 degrees
 */
class Robot {

    private int currentX;
    private int currentY;
    private Direction currentDirection;

    public Robot(int x, int y, Direction direction) {
        currentX = x;
        currentY = y;
        currentDirection = direction;
    }

    public Direction getDirection() { return currentDirection; }

    public int getX() { return currentX; }

    public int getY() { return currentY; }

    public void turnLeft() {
        switch (currentDirection) {
            case UP:
                currentDirection = Direction.LEFT;
                break;
            case RIGHT:
                currentDirection = Direction.UP;
                break;
            case DOWN:
                currentDirection = Direction.RIGHT;
                break;
            case LEFT:
                currentDirection = Direction.DOWN;
                break;
        }

        printInfo();
    }

    public void turnRight() {
        switch (currentDirection) {
            case UP:
                currentDirection = Direction.RIGHT;
                break;
            case RIGHT:
                currentDirection = Direction.DOWN;
                break;
            case DOWN:
                currentDirection = Direction.LEFT;
                break;
            case LEFT:
                currentDirection = Direction.UP;
                break;
        }

        printInfo();
    }

    public void stepForward() {
        switch (currentDirection) {
            case UP:
                currentY += 1;
                break;
            case RIGHT:
                currentX += 1;
                break;
            case DOWN:
                currentY -= 1;
                break;
            case LEFT:
                currentX -= 1;
                break;
        }

        printInfo();
    }

    public void printInfo() { 
        System.out.println(String.format("(%d, %d), %s", currentX, currentY, currentDirection));
    }
    
}