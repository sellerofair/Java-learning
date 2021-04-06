package JavaBaseSyntax;

import java.math.BigInteger;

public class JavaBaseSyntax {
    public static void main(String[] args) {
        String[] roles = {
            "Городничий",
            "Аммос Федорович",
            "Артемий Филиппович",
            "Лука Лукич"
        };
        String[] text = {
            "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
            "Аммос Федорович: Как ревизор?",
            "Артемий Филиппович: Как ревизор?",
            "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
            "Аммос Федорович: Вот те на!",
            "Артемий Филиппович: Вот не было заботы, так подай!",
            "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };

        System.out.println(printTextPerRole(roles, text));
    }

// 2.1 Core types
  // Step 15
    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << (bitIndex - 1));
    }

// 2.2 Type casting
  // Step 9
    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        return (value != 0) && ((value & (-value)) == Math.abs(value));
    }

// 2.3 Arrays & Strings
  // Step 10
    /**     * 
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        text = text.toUpperCase().replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder reverse = new StringBuilder(text).reverse();
        return text.equals(reverse.toString());
    }

// 2.4 Control flow
  // Step 8
    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

  // Step 9
    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
    */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        byte i = 0;
        byte i1 = 0;
        byte i2 = 0;
        while (i < result.length) {
            if (i2 >= a2.length || i1 < a1.length && a1[i1] <= a2[i2]) {
                result[i] = a1[i1];
                i1 += 1;
            } else {
                result[i] = a2[i2];
                i2 += 1;
            }
            i += 1;
        }
        return result;
    }


  // Step 10
    /**
     * Merges roles and scenario lines in the following format
     * <Role>
     * i) <Text1>
     * j) <Text2>
     * ...
     * 
     * where i, j - text position in scenario
     *
     * @param roles array
     * @param textLines array
     * @return formatted scenario
    */
    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder();
        String pattern = "%d) %s\n";
        for (String role : roles) {
            result.append(role + ":\n");
            for (int i = 0; i < textLines.length; i++) {
                String line = textLines[i];
                int sepIndex = line.indexOf(':');
                if (role.equals(line.substring(0, sepIndex))) {
                    result.append(String.format(pattern, i + 1, line.substring(sepIndex+ 2)));
                }
            }
        result.append('\n');
        }
        return String.valueOf(result).trim();
    }
}