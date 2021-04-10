package Dominos;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            Domino domino1 = Domino.fromString(scanner.next());
            Domino domino2 = Domino.fromString(scanner.next());
            System.out.println(domino1.match(domino2));
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            scanner.close();
        }

    }
}

class Domino {
    final byte leftDots;
    final byte rightDots;

    Domino(byte a, byte b) {
        leftDots = a;
        rightDots = b;
    }
    
    Domino rotate() {
        return new Domino(this.rightDots, this.leftDots);
    }

    static Domino fromString(String input) {
        byte a = (byte) Integer.parseInt(input.substring(0, 1));
        byte b = (byte) Integer.parseInt(input.substring(2));
        return new Domino(a, b);
    }

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
        return this.leftDots + " " + this.rightDots;
    }
}