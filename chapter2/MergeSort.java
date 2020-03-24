/* Adapted code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to implement mergesort and to learn about the usefulness of assertions,
   which we can enable in runtime with java -ea MergeSort */

import java.util.Scanner;

public class MergeSort
{
    private static int[] aux;

    // Top-level function that is called when we want an array to be sorted
    public static void sort(int[] array)
    {
        aux = new int[array.length];
        sortSubarray(array, 0, array.length - 1);
    }

    // Recursively sorts the left and right halves of the array
    public static void sortSubarray(int[] array, int low, int high)
    {
        if (high <= low)
            return;
        
        int mid = low + ((high - low) / 2);

        // Sort the left half of the array
        sortSubarray(array, low, mid);

        // Sort the right half of the array
        sortSubarray(array, mid + 1, high);

        // Combine the two sorted halves back together
        merge(array, low, mid, high);
    }

    public static void merge(int[] array, int low, int mid, int high)
    {
        // Precondition: array[low..mid] and array[mid + 1..high] is sorted
        assert isSorted(array, low, mid);
        assert isSorted(array, mid + 1, high);

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

        // Postcondition: array[low..high] is sorted
        assert isSorted(array, low, high);
    }

    public static boolean isSorted(int[] array, int low, int high)
    {
        for (int i = low; i <= high; i++)
        {
            if (array[i] > array[i + 1])
                return false;
        }

        return true;
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