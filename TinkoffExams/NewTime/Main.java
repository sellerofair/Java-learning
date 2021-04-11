package NewTime;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws IOException {

        Scanner scanner = null;

        try {

            scanner = new Scanner(System.in);

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int t = scanner.nextInt();

            StringBuilder result = new StringBuilder();

            result.append(t % c);
            result.append(' ');

            t = t / c;

            result.append(t % b);
            result.append(' ');

            t = t / b;

            result.append(t % a);

            System.out.println(result.toString());

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            scanner.close();
        }
        
    }

}