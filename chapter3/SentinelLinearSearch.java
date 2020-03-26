import java.util.Scanner;

public class SentinelLinearSearch
{
    /* Returns first occurrence of valueToFind in a[]
       or -1 if not in a[] */
    public static int search(int[] a, int valueToFind)
    {
        // Store last item in the array and replace with sentinel
        int last = a[a.length - 1];
        a[a.length - 1] = valueToFind;

        // Iterate through the array until you find what you're looking for
        int i = 0;
        while (a[i] != valueToFind)
            i++;
        
        a[a.length - 1] = last;
        if (i < a.length - 1 || a[a.length - 1] == valueToFind)
            return i;
        else
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