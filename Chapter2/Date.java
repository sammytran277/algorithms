/* Example code from "Algorithms" by Robert Sedgewick and Thomas Wayne 
   to illustrate the implementation of the Comparable interface */

public class Date implements Comparable<Date>
{
    /* We use final here so that the month, day and year
       can not be changed */
    private final int month, day, year;

    public Date(int month, int day, int year)
    {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /* Implementing the compareTo() method so we know how
       to compare two Date objects to each other using
       =, >, <. >=, <= */
    public int compareTo(Date that)
    {
        if (this.year < that.year)
            return -1;
        if (this.year > that.year)
            return 1;
        if (this.month < that.month)
            return -1;
        if (this.month > that.month)
            return 1;
        if (this.day < that.day)
            return -1;
        if (this.day > that.day)
            return 1;
        
        return 0;
    }

    public static boolean equal(Date a, Date b)
    {
        return a.compareTo(b) == 0;
    }

    public static boolean less(Date a, Date b)
    {
        return a.compareTo(b) < 0;
    }

    public static boolean greater(Date a, Date b)
    {
        return a.compareTo(b) > 0;
    }

    public String toString()
    {
        return String.format("%d/%d/%d", this.month, this.day, this.year);
    }

    public static void main(String[] args)
    {
        Date myBirthday = new Date(2, 1, 2000);
        Date today = new Date(3, 32, 2020);

        if (greater(today, myBirthday))
            System.out.println(today + " > " + myBirthday);

        if (less(myBirthday, today))
            System.out.println(myBirthday + " < " + today);

        if (equal(myBirthday, myBirthday))
            System.out.println(myBirthday + " = " + myBirthday);
    }
}