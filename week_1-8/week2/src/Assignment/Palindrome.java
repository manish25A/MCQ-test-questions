package Assignment;
import java.util.Scanner;

public class Palindrome {

    static boolean checkpalindrome(String word)
    {
        int i = 0, j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args)
    {
        String word;
        System.out.println("Enter the word: ");
        Scanner scanner = new Scanner(System.in);
        word = scanner.nextLine();
        if (checkpalindrome(word))
            System.out.print("Entered word is Palindrome.");
        else
            System.out.print("Entered word is not Palindrome.");
    }
}
