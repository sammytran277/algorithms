/* Adapted code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to implement heapsort */

import java.util.Scanner;

public class HeapSort
{
    public static void sort(Comparable[] a)
    {
        int n = a.length;
        for (int k = n / 2; k >= 1; k--)
            sink(a, k, n);
        while (n > 1)
        {
            swap(a, 1, n--);
            sink(a, 1, n);
        }
    }

    public static void sink(Comparable[] a, int k, int aLength)
    {
        while (2 * k <= aLength)
        {
            int j = 2 * k;
            if (j < aLength && less(a, j, j + 1))
                j++;
            if (!less(a, k, j))
                break;
            swap(a, k, j);
            k = j;
        }
    }

    /* We subtract 1 from i and j because the tree is indexed starting 
       from 1, but the array needs to obviously start from 0 */
    public static boolean less(Comparable[] a, int i, int j)
    {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    public static void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = temp;
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int arrayLength = s.nextInt();

        System.out.print("Enter the array values: ");
        Integer[] a = new Integer[arrayLength];
        for (int i = 0; i < arrayLength; i++)
            a[i] = s.nextInt();

        sort(a);

        System.out.print("Sorted array: ");
        for (int n : a)
            System.out.print(n + " ");

        s.close();
    }
}