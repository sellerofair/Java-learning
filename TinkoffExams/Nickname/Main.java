import java.io.IOException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            String nick = scanner.nextLine();
            System.out.println(nickIsPretty(nick.toString()));
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            scanner.close();
        }
    }

    static String nickIsPretty(String nick) {
        for (int i = 0; i < nick.length() - 1; i++) {
            if (isVowel(nick.charAt(i))) {
                if (isVowel(nick.charAt(i + 1))) {
                    return "NO";
                }
            } else {
                if (!isVowel(nick.charAt(i + 1))) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    static boolean isVowel(char letter) {
        return "aeiouy".indexOf(letter) != -1;
    }
}