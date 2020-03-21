/* Adapted code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to demonstrate the application of sorting algorithms to shuffle 
   an array to a uniformly random permutation of the original array */

import java.util.Scanner;

public class KnuthShuffle
{
    public static void shuffle(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int randomIndex = (int) Math.floor(Math.random() * (double) i);
            swap(array, i, randomIndex); 
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

        int[] unshuffledArray = new int[arrayLength];

        System.out.print("Enter the array values: ");
        for (int i = 0; i < arrayLength; i++)
            unshuffledArray[i] = s.nextInt();

        shuffle(unshuffledArray);

        System.out.print("Shuffled array: ");
        for (int n : unshuffledArray)
        {
            System.out.print(n + " ");
        }

        s.close();
    }
}