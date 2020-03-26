/* Adapted code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to implement a max priority queue using a heap */

public class HeapMaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int pqSize = 0;

    public HeapMaxPQ(int capacity)
    {
        // capacity + 1 because index 0 won't be used
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty()
    {
        return pqSize == 0;
    }

    public int size()
    {
        return pqSize;
    }

    public void insert(Key newKey)
    {
        pq[++pqSize] = newKey;
        swim(pqSize);
    }

    public Key delMax()
    {
        Key maxKey = pq[1];         // Store the max key, located at the root
        swap(1, pqSize--);          // Replace root with the last node in pq[]
        pq[pqSize + 1] = null;      // Remove the node with the max key
        sink(1);                    // Reheapify by sinking the root node
        return maxKey;

    }

    // Takes an int k, the k'th node in the heap
    private void swim(int k)
    {
        while (k > 1 && less(k/2, k))
        {
            swap(k/2, k);
            k /= 2;
        }
    }

    private void sink(int k)
    {
        while (2 * k <= pqSize)
        {
            int j = 2 * k;
            if (j < pqSize && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int a, int b)
    {
        return pq[a].compareTo(pq[b]) < 0;
    }

    private void swap(int i, int j)
    {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args)
    {
        Date d1 = new Date(2, 1, 2000);
        Date d2 = new Date(3, 9, 1961);
        Date d3 = new Date(10, 14, 2000);
        Date d4 = new Date(10, 22, 1959);

        UnorderedMaxPQ<Date> pq = new UnorderedMaxPQ<Date>(4);
        System.out.println(pq.isEmpty());

        pq.insert(d1);
        pq.insert(d2);
        pq.insert(d3);
        pq.insert(d4);

        System.out.println(pq.isEmpty());
        System.out.println("Most recent date: " + pq.deleteMax());

        int n = pq.size();
        for (int i = 0; i < n; i++)
            System.out.println("Next recent date: " + pq.deleteMax());

        System.out.println(pq.isEmpty());
    }
}