public class ObjectsClassesPackages {
    public static void main(String[] args) {
        // Robot robot = new Robot(0, 0, Direction.UP);
        // moveRobot(robot, -3, 4);
        byte[] acs = {100, 101, 102, 103};
        AsciiCharSequence acs1 = new AsciiCharSequence(acs);
        System.out.println(acs1);
        System.out.println(acs1.length());
        System.out.println(acs1.subSequence(1, 3));
    }

// 3.3 Class declaration
  // Step 12
    /**
     * Class of robot. He can make a step forward, turn left/right in 90 degrees
     */
    public static class Robot {

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

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    /**
     * 
     * Moves the Robot to new position (toX. toY).
     * 
     * @param robot Instance of class Robot
     * @param toX axis of endpoint
     * @param toY axis of endpoint
     */
    public static void moveRobot(Robot robot, int toX, int toY) {
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

// 3.4 Inheritance. Class Object
  // Step 9
    /**
     * Class of complex numbers.
     */
    public static class ComplexNumber {
        private final double re;
        private final double im;
    
        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }
    
        public double getRe() {
            return re;
        }
    
        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) { return true; }
            if (!(obj instanceof ComplexNumber)) { return false; }
            ComplexNumber number = (ComplexNumber) obj;
            return number.im == this.im && number.re == this.re;
        }

        @Override
        public int hashCode() {
            long h = (
                Double.doubleToLongBits(re) +
                Double.doubleToLongBits(im)
            );
            return (int)h ^ (int)(h >>> 32);
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append(re);
            result.append(im > 0 ? " + " : " - ");
            result.append(Math.abs(im));
            result.append('i');
            return result.toString();
        }
    }

// 3.5 Abstract classes & Interfaces
  // Step 8
    /**
     * Sequence of ASCII symbols.
     */
    public static class AsciiCharSequence implements CharSequence {
        
        byte[] sequence;

        public AsciiCharSequence(byte[] seq) {
            sequence = new byte[seq.length];
            for (int i = 0; i < seq.length; i++) {
                sequence[i] = seq[i];
            }
        }

        @Override
        public CharSequence subSequence(int arg0, int arg1) {
            byte[] subSeq = new byte[arg1 - arg0];
            for (int i = 0; i < subSeq.length; i++) {
                subSeq[i] = sequence[i + arg0];
            }

            return new AsciiCharSequence(subSeq);
        }

        @Override
        public char charAt(int arg0) {
            return (char) sequence[arg0];
        }

        @Override
        public int length() {
            return sequence.length;
        }

        @Override
        public String toString() {
            if (sequence.length == 0) { return ""; }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < sequence.length; i++) {
                result.append((char) sequence[i]);
            }
            return result.toString();
        }
    }
}