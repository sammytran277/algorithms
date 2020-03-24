import java.util.Scanner;

public class BubbleSort
{
    public static void sort(int[] array)
    {
        boolean isSorted = false;

        while (!isSorted)
        {
            isSorted = true;

            for (int i = 0; i < array.length - 1; i++)
            {
                if (array[i + 1] < array[i])
                {
                    swap(array, i + 1, i);
                    isSorted = false;
                }
            }
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
            System.out.print(n + " ");

        s.close();
    }
}