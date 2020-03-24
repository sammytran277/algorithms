/* Adapted code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to implement the elementary Shell sort algorithm */

   import java.util.Scanner;

   public class ShellSort
   {
        public static void sort(int[] array)
        {
            int h = 1;

            /* Donald Knuth's 3h + 1 incrementing sequence:
               1, 4, 13, 40, 121, 364, ... */
            while (h < array.length / 3)
                h = (3 * h) + 1;
            
            while (h >= 1)
            {
                // h-sort the array
                for (int i = h; i < array.length; i++)
                {
                    for (int j = i; j >= h && array[j] < array[j - h]; j -= h)
                        swap(array, j, j - h);
                }

                h /= 3;
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