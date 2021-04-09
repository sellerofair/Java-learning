import java.io.IOException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();

            int[] a = new int[n];


            for (int i = 0; i < a.length; i++) {
                a[i] = scanner.nextInt();
            }

            int price = 0;

            int i0 = 0;

            while (i0 < a.length) {
                int minPrice = a[i0];
                int maxPrice = a[i0];
                int boxPrice = k;

                int end = i0 + m;
                if (i0 + m > a.length) { end = a.length; }
                System.out.println(" =>  " + (i0 + 1) + ", " + end);
                System.out.println((i0 + 1) + ". " + a[i0]);

                for (int i = i0 + 1; i < end; i++) {
                    System.out.println((i + 1) + ". " + a[i]);
                    int x = i - i0 + 1;
                    if (a[i] < minPrice) { minPrice = a[i]; }
                    if (a[i] > maxPrice) { maxPrice = a[i]; }
                    System.out.println(minPrice + " <= price <= " + maxPrice);
                    int newPrice = (maxPrice - minPrice) * x * x + k;
                    System.out.println(newPrice);
                    if (boxPrice + k > newPrice) {
                        System.out.println("GOOD");
                        boxPrice = newPrice;
                    } else {
                        System.out.println("BAD");
                        end = i;
                        break;
                    }
                }
                System.out.println("Box price = " + boxPrice + '\n');

                i0 = end;
                price += boxPrice;
            }

            System.out.println(price);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            scanner.close();
        }
    }
}