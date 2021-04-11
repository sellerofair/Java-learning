package Dominos;

class Domino {

    final byte leftDots;
    final byte rightDots;

    /**
     * 
     * Create domino from bytes.
     * 
     * @param a
     * @param b
     */
    Domino(byte a, byte b) {
        leftDots = a;
        rightDots = b;
    }

    /**
     * 
     * Create domino from String formatted "leftDots rightDots".
     * 
     * @param input
     */
    Domino(String input) {

        leftDots = (byte) Integer.parseInt(input.substring(0, 1));
        rightDots = (byte) Integer.parseInt(input.substring(2));

    }

    Domino rotate() {
        return new Domino(this.rightDots, this.leftDots);
    }

    /**
     * 
     * Cheik if dominos have equal dots in one side.
     * 
     * @param other
     * @return -1 if thereis no match; String of 2 dominos separated with space.
     */
    String match(Domino other) {

        String result = "-1";

        if (this.rightDots == other.leftDots) {
            result = String.format("%s %s",
                this.toString(),
                other.toString());
        }
        if (this.rightDots == other.rightDots) {
            result = String.format("%s %s",
                this.toString(),
                other.rotate().toString());
        }
        if (this.leftDots == other.leftDots) {
            result = String.format("%s %s",
                this.rotate().toString(),
                other.toString());
        }
        if (this.leftDots == other.rightDots) {
            result = String.format("%s %s",
                this.rotate().toString(),
                other.rotate().toString());
        }

        return result;

    }

    @Override
    public String toString() {
        return leftDots + " " + rightDots;
    }

}