package Assignment;
import java.util.Scanner;

public class ReverseString_Qn1 {

    public static void main(String[] args) {
        String inputword;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a word to reverse:");
        inputword = sc.nextLine();
        System.out.printf("Reverse of"+ inputword + " is " + reverse(inputword)+".");
    }

    private static String reverse(String inputword) {
        char[] arr = inputword.toCharArray();
        String revString = "";
        for (int i = arr.length - 1; i >= 0; i--)
            revString += arr[i];
        return revString;
    }
}
