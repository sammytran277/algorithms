public class UnorderedMaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int sizeOfPQ;

    public UnorderedMaxPQ(int capacity)
    {
        pq = (Key[]) new Comparable[capacity];
        sizeOfPQ = 0;
    }

    public int size()
    {
        return sizeOfPQ;
    }

    public boolean isEmpty()
    {
        return sizeOfPQ == 0;
    }

    public void insert(Key newKey)
    {
        pq[sizeOfPQ++] = newKey;
    }

    public Key deleteMax()
    {
        int max = 0;
        for (int i = 1; i < sizeOfPQ; i++)
        {
            if (less(pq[max], pq[i]))
                max = i;
        }
        swap(max, sizeOfPQ - 1);
        return pq[--sizeOfPQ];
    }

    private boolean less(Key a, Key b)
    {
        return a.compareTo(b) < 0;
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