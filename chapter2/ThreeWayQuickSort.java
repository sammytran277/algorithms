/* Adapted code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to implement quicksort with 3-way partitioning to handle duplicate keys */

import java.util.Scanner;

public class ThreeWayQuickSort
{
    public static void sort(int[] array)
    {
        KnuthShuffle.shuffle(array);
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int low, int high)
    {
        if (high <= low)
            return;

        int lt = low, i = low + 1, gt = high;
        int pivotValue = array[low];

        while (i <= gt)
        {
            if (array[i] < pivotValue)
                swap(array, lt++, i++);
            else if (array[i] > pivotValue)
                swap(array, i, gt--);
            else
                i++;
        }

        quicksort(array, low, lt - 1);
        quicksort(array, gt + 1, high);
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