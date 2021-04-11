package Dominos;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws IOException {

        Scanner scanner = null;

        try {

            scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");

            Domino domino1 = new Domino(scanner.next());
            Domino domino2 = new Domino(scanner.next());

            System.out.println(domino1.match(domino2));

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            scanner.close();
        }

    }
    
}