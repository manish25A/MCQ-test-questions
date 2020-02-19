package Assignment;
import java.util.Scanner;

public class Qn6_Recursive_function_for_linear_search {
    int recursionSearch(int arr[], int start, int last, int x)
    {
        if (last < start)
            return -1;
        if (arr[start] == x)
            return start;
        return recursionSearch(arr, start+1, last, x);
    }
    public static void main(String args[])
    {
        Qn6_Recursive_function_for_linear_search rec=new Qn6_Recursive_function_for_linear_search();

        int i,len, key, array[];

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Array length:");

        len = input.nextInt();

        array = new int[len];

        System.out.println("Enter " + len + " elements");

        for (i = 0; i < len; i++)
        {
            array[i] = input.nextInt();
        }
        System.out.println("Enter the search key value:");

        key = input.nextInt();

        int index=rec.recursionSearch(array,0,len-1,key);

        if (index!=-1)
        {
            System.out.println(key+" is found at location "+(index+1));
        }
        else
        {
            System.out.println(key + " doesn't exist in array.");
        }
    }
}
