package ObjectsClassesPackages.RoboMoving;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);
        moveRobot(robot, -3, 4);        
    }

    /**
     * 
     * Moves the Robot to new position (toX. toY).
     * 
     * @param robot Instance of class Robot
     * @param toX axis of endpoint
     * @param toY axis of endpoint
     */
    static void moveRobot(Robot robot, int toX, int toY) {
        int dX = 0;
        int dY = 0;

        // Moving of the axes to (0, 0) and rotating to the top 
        switch (robot.getDirection()) {
            case UP:
                dX = toX - robot.getX();
                dY = toY - robot.getY();
                break;
            case RIGHT:
                dX = robot.getY() - toY;
                dY = toX - robot.getX();
                break;
            case DOWN:
                dX = robot.getX() - toX;
                dY = robot.getY() - toY;
                break;
            case LEFT:
                dX = toY - robot.getY();
                dY = robot.getX() - toX;
            break;
        }
        System.out.println(String.format("%s %d, %s %d)", dY >= 0 ? "Вперед" : "Назад", dY, dX >= 0 ? "вправо" : "влево", dX));

        // Turning of the Robot if dY < 0
        if (dY < 0) {
            if (dX >= 0) {
                robot.turnRight();
                dY *= -1;
            } else {
                robot.turnLeft();
            }
            dX = dX + dY;
            dY = dX - dY;
            dX = dX - dY;
        }

        for (int i = 0; i < Math.abs(dY); i++) {
            robot.stepForward();
        }

        if (dX != 0) {
            if (dX > 0) {
                robot.turnRight();
            } else {
                robot.turnLeft();
            }
            for (int i = 0; i < Math.abs(dX); i++) {
                robot.stepForward();
            }
        }
    System.out.println("\n   !!!Прибыли!!!");
    robot.printInfo();
    }
}