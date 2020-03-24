/* Adapted code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to implement bottom-up mergesort */

import java.util.Scanner;

public class BottomUpMergeSort
{
    private static int[] aux;

    public static void sort(int[] array)
    {
        aux = new int[array.length];

        // Break the array into size 1, 2, 4, 8, ... subarrays for merging
        for (int size = 1; size < array.length; size += size)
        {
            // Merge all the tiny subarrays back together
            for (int low = 0; low < array.length - size; low += size + size)
                merge(array, low, low + size - 1, Math.min(low + size + size - 1, array.length - 1));
        }
    }

    public static void merge(int[] array, int low, int mid, int high)
    {
        // Copy the contents of array to the auxiliary array
        for (int k = low; k <= high; k++)
            aux[k] = array[k];

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++)
        {
            // i pointer is exhausted
            if (i > mid)
                array[k] = aux[j++];
            // j pointer is exhausted
            else if (j > high)
                array[k] = aux[i++];
            else if (aux[j] < aux[i])
                array[k] = aux[j++];
            else
                array[k] = aux[i++];
        }
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
            System.out.print(n + " ");

        s.close();
    }
}