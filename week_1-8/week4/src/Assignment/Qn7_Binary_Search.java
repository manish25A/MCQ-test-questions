package Assignment;
import java.util.Scanner;

class Qn7_Binary_Search{
    public static void main(String args[]) {
        int i, arrlength, item, firstvalue = 0, endvalue, middlevalue;
        int[] array;

        Scanner s = new Scanner(System.in); //For user input
        System.out.println("Enter the number of elements you want to keep it in array:");
        arrlength = s.nextInt();

        array = new int[arrlength]; //Creating an array to store the numbers
        System.out.println("Enter " + arrlength + " integers:");

        for (i = 0; i < arrlength; i++)//using loop to store every numbers
            array[i] = s.nextInt();

        System.out.println("Enter the search value:");
        item = s.nextInt();
        endvalue = arrlength - 1;
        middlevalue = (firstvalue + endvalue)/2;

        while( firstvalue <= endvalue )
        {
            if ( array[middlevalue] < item )
                firstvalue = middlevalue + 1;
            else if ( array[middlevalue] == item )
            {
                System.out.println(item + " is found at the location " + (middlevalue + 1) + ".");
                break;
            }
            else
            {
                endvalue = middlevalue - 1;
            }
            middlevalue = (firstvalue + endvalue)/2;
        }
        if ( firstvalue > endvalue )
            System.out.println(item + " is not found at any location.");
    }
}