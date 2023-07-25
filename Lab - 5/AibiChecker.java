/* 30. Write a program to determine if an input character string is of the form aibi where i >= 1 i.e., Number of ‘a’ should be equal to number of ‘b’.  */

import java.util.Scanner;

public class AibiChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.next();

        CheckFormat cf = new CheckFormat();
        boolean isAibi = cf.checkAibi(input);

        if (isAibi) {
            System.out.println("The input string is of the form a^ib^i.");
        } else {
            System.out.println("The input string is not of the form a^ib^i.");
        }
    }

}
class CheckFormat {
    public static boolean checkAibi(String str) {
        int countA = 0;
        int countB = 0;

        for (char c : str.toCharArray()) {
            if (c == 'a') {
                countA++;
            } else if (c == 'b') {
                countB++;
            } else {
                // Character other than 'a' or 'b' found, not of the required form
                return false;
            }
        }

        return countA > 0 && countA == countB;
    }
}
