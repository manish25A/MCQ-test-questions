package Assignment;
import java.util.Scanner;

 class Reversing_Using_Recursive_Function {


    public static void main(String[] args) {
        String word;
        System.out.println("Enter the word: ");
        Scanner scanner = new Scanner(System.in);
        word = scanner.nextLine();
        String reversed = reverseString(word);
        System.out.println("The reversed string is: " + reversed);
    }

    public static String reverseString(String word)
    {
        if (word.isEmpty())
            return word;//calling a function recursively
        return reverseString(word.substring(1)) + word.charAt(0);
    }
}
