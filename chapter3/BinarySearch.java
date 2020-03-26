import java.util.Scanner;

public class BinarySearch
{
    public static int search(int[] a, int valueToFind)
    {
        assert isSorted(a);

        int low = 0; 
        int high = a.length - 1;
        int mid;

        while (low <= high)
        {
            mid = (low + high) / 2;
            
            if (a[mid] > valueToFind)
                high = mid - 1;
            else if (a[mid] < valueToFind)
                low = mid + 1;
            else
                return mid;
        }
        
        return -1;
    }

    public static boolean isSorted(int[] a)
    {
        for (int i = 0; i < a.length - 1; i++)
        {
            if (a[i] > a[i + 1])
                return false;
        }

        return true;
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