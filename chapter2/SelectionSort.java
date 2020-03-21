/* Adapted code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to implement the elementary selection sort algorithm */

import java.util.Scanner;

public class SelectionSort
{
    public static void sort(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int indexOfMin = i;

            /* iterate through the all indexes > i to find
               the index of the minimum value in the subarray */
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < array[indexOfMin])
                    indexOfMin = j;
            }

            swap(array, i, indexOfMin);
        }
    }

    private static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the array length: ");
        int arrayLength = s.nextInt();

        int[] unsortedArray = new int[arrayLength];

        System.out.print("Enter the array values: ");
        for (int i = 0; i < arrayLength; i++)
            unsortedArray[i] = s.nextInt();

        sort(unsortedArray);

        System.out.print("Sorted array: ");
        for (int n : unsortedArray)
        {
            System.out.print(n + " ");
        }

        s.close();
    }
}