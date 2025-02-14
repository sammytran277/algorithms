/* Adapted code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to implement quicksort */

import java.util.Scanner;

public class QuickSort
{
    public static void sort(int[] array)
    {
        /* We shuffle the array to avoid the worst case, which
           is an already sorted array */
        KnuthShuffle.shuffle(array);
        quicksort(array, 0, array.length - 1);

    }

    private static void quicksort(int[] array, int low, int high)
    {
        if (high <= low)
            return;
        int pivotIndex = partition(array, low, high);
        quicksort(array, low, pivotIndex - 1);
        quicksort(array, pivotIndex + 1, high);
    }

    public static int partition(int[] array, int low, int high)
    {
        int i = low, j = high + 1;
        int pivotValue = array[low];
        while (true)
        {
            /* Keep moving the i pointer to the right until it 
               finds a key greater than the pivot */
            while (array[++i] < pivotValue)
            {
                if (i == high)
                    break;
            }

            /* Keep moving the j pointer to the left until it
               finds a key less than the pivot */
            while (array[--j] > pivotValue)
            {
                if (j == low)
                    break;
            }

            // We're done partitioning if i and j cross
            if (i >= j)
                break;
            
            swap(array, i, j);
        }

        // Puts pivot where it belongs in the array
        swap(array, low, j);
        return j;
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
            System.out.print(n + " ");

        s.close();
    }
}