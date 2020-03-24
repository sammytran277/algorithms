/* Adapted code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to implement quickselect, which finds the k'th largest item in an array */

import java.util.Scanner;

public class QuickSelect
{
    public static int select(int[] array, int k)
    {
        KnuthShuffle.shuffle(array);
        int low = 0, high = array.length - 1;
        while (high > low)
        {
            int j = QuickSort.partition(array, low, high);
            if (j < k)
                low = j + 1;
            else if (j > k)
                high = j - 1;
            else
                return array[k];
        }

        return array[k];
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the array length: ");
        int arrayLength = s.nextInt();

        int[] array = new int[arrayLength];

        System.out.print("Enter the array values: ");
        for (int i = 0; i < arrayLength; i++)
            array[i] = s.nextInt();

        System.out.print("Enter k: ");
        int k = s.nextInt();
        int kLargest = select(array, k);

        System.out.println(String.format("The %dth largest value in the array is: %d", k, kLargest));

        s.close();
    }
}