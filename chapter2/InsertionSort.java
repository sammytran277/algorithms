/* Adapted code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to implement the elementary insertion sort algorithm */

import java.util.Scanner;

public class InsertionSort
{
    public static void sort(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--)
                swap(array, j, j - 1);
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