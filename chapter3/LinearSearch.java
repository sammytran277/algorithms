import java.util.Scanner;

public class LinearSearch
{
    /* Returns first occurrence of valueToFind in a[]
       or -1 if not in a[] */
    public static int search(int[] a, int valueToFind)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] == valueToFind)
                return i;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the array length: ");
        int arrayLength = s.nextInt();

        int[] a = new int[arrayLength];
        System.out.print("Enter the array values: ");
        for (int i = 0; i < arrayLength; i++)
            a[i] = s.nextInt();

        System.out.print("Enter the value to find: ");
        int valueToFind = s.nextInt();

        int resultOfSearch = search(a, valueToFind);
        if (resultOfSearch == -1)
            System.out.println("Could not find " + valueToFind + "!");
        else
            System.out.println("Found " + valueToFind + " at index " + resultOfSearch + "!");

        s.close();
    }
}