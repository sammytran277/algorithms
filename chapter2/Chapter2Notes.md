# **Notes on Sorting Algorithms and Priority Queues/Heaps**

## **Introduction**

In chapter 2, we learn about three elementary sorting algorithms (namely, selection sort, insertion sort, and Shellsort), two classic divide-and-conquer sorting algorithms (mergesort and quicksort), and priority queues, which will be used to introduce heaps as well as heapsort. Though not mentioned in the book/course, I've also included bubble sort for fun. Notes on everything are given below. The images/gifs below are not mine.

---

## **Table of Contents**

* [Selection Sort](#selection-sort)
* [Insertion Sort](#insertion-sort)
* [Bubble Sort](#bubble-sort)
* [Shellsort](#shellsort)
* [Mergesort](#mergesort)
* [Quicksort](#quicksort)
* [Priority Queues](#priority-queues)
* [Heaps](#heaps)
* [Heapsort](#heapsort)

---

### **Selection Sort**

![Selection Sort GIF](/images/SelectionSort.gif)

Our study of sorting algorithms begins with one of the simplest of them all: selection sort. Selection sort works by dividing the array into two subarrays: sorted and unsorted. At the beginning, the entire array is unsorted. To start, we scan through the entire array, starting at index 1, to find the smallest value in the array and swap that value with the value that is at index 0. We know that index 0 now contains the smallest value in the entire array, so we no longer have to compare that value to anything else. During the next iteration of the loop, we start at index 2 and scan through the rest of the array, finding the smallest value in the subarray and swapping it with whatever is in index 1. This pattern repeats over and over again until the entire array is sorted.

#### **Time/Space Complexity for Selection Sort**

The time complexity for selection sort is O(n<sup>2</sup>). This can be proven by observing how many comparisons are being made at every iteration. The first iteration scans through the entire array besides index 0, which is (n - 1) comparisons. The next iteration scans through the entire array besides indexes 0 and 1, which is (n - 2) comparisons. In total, there will be (n - 1) + (n - 2) + (n - 3) + ... + 2 + 1 + 0 comparisons, which can be proven to be equivalent to n * (n - 1) / 2. If we take the largest term, we indeed arrive at n<sup>2</sup>.

The space complexity is O(1) because the algorithm allocates the same amount of space regardless of how large the array is.

---

### **Insertion Sort**

![Insertion Sort GIF](/images/InsertionSort.gif)

The next sorting algorithm to consider is insertion sort. Insertion sort works by, like selection sort, dividing the array into a sorted and unsorted subarray. As the algorithm iterates through the unsorted subarray, it goes back into the sorted subarray to find where the current value should be placed such that the sorted subarray is still sorted.Unlike selection sort, insertion sort's speed drastically increases if the array's entries are partially (or even completely) sorted. This fact will play an important role when we study the last of the elementary sorting algorithms, Shellsort.

#### Time/Space Complexity for Insertion Sort

The time complexity for insertion sort is O(n<sup>2</sup>). The reasoning is similar to that of selection sort, and if we assume that on average, a value is sent about halfway back, then there will be n<sup>2</sup> / 4 comparisons.

The space complexity for insertion sort is O(1) for the same reason as selection sort.

---

### **Bubble Sort**

![Bubble Sort GIF](/images/BubbleSort.gif)

Bubble sort gets its name from the way the values in the array seem to "bubble" towards the end of the array. Unlike selection and insertion sort, bubble sort seems to sort the array by bringing the largest values to their correct position first, which is the exact opposite of what happens during selection or insertion sort. In this sorting algorithm, we keep scanning through the entire array, comparing values to their right neighbor. If the neighbor's value is smaller, then the two values are swapped. This process repeats itself over and over until we make it through the entire array without having to swap anything, which tells us that the array is sorted.

#### Time/Space Complexity for Bubble Sort

Like the other elementary sorting algorithms, the time complexity for bubble sort is O(n<sup>2</sup>). At this point, we begin to see a pattern in the code. In cases where the sorting algorithms make use of nested loops, the time complexity seems to always be quadratic. In terms of practicality, insertion sort seems to just be equally good, if not better in all categories (especially in the case of partially sorted arrays), so bubble sort is not considered to be a practical sorting algorithm.

The space complexity for bubble sort is O(1), like the other elementary sorting algorithms we've seen so far.

---

### **Shellsort**

![Shellsort GIF](/images/ShellSort.gif)

Shellsort is the last of the elementary sorting algorithms we will consider, and unlike all of the sorting algorithms we have seen so far, the jury is still out regarding just how good this sort can be.

Shellsort works by utilizing the fact that the time complexity for insertion sort approaches O(n) when the array to sort is partially sorted. The idea is then to find a way to quickly "partially sort" an array and then feed it to insertion sort. Shellsort does this by introducing a concept known as "h-sorting" an array.

When we say that an array is h-sorted, we are saying that, for a gap of size h, the values of the array are sorted. For example, the array containing [5, 1, 6, 2, 7] is said to be 2-sorted becayse 5 < 6 < 7 and 1 < 2. The whole point of h-sorting an array is to eliminate the issue of having to move a value in insertion sort from one side of the array to the other, one swap at a time. For example, in the case of a reverse sorted array like [5, 4, 3, 2 1], the value 1 would ultimately need (n - 1) swaps to get to index 0.

To h-sort an array, we just consider the subarray containing values that are h indexes apart from each other and sort that subarray using a method like insertion sort. For example, to 2-sort [4, 2, 1, 2, 5], we would consider the subarrays [4, 1, 5] and [2, 2]. By sorting both arrays, we end up with [1, 4, 5] and [2, 3]. Combining the subarrays back together, we have [1, 2, 3, 2, 5], which insertion sort can iterate through very quickly.

The real question is then, what should h be in order to maximize the efficiency of Shellsort? This is still open for debate, and many sequences have been tried. For my implementation, I used Donald Knuth's 3h + 1 sequence, which is simple to compute. Much more complex sequences exist, and much research has been done to analyze their performance.

#### **Time/Space Complexity for Shellsort**

As stated earlier, the time complexity for Shellsort is not easy to pinpoint. This is because the speed of the algorithm is heavily dependent on the gap sequence chosen by the programmer. Because Shellsort is an improvement of insertion sort, we can only say that it performs no worse than O(n<sup>2</sup>) and, on average, is O(n<sup>3/2</sup>).

Like the other elementary sorting algorithms, Shellsort has a space complexity of O(1).

---

### **Mergesort**

![Merge Sort GIF](/images/MergeSort.gif)

Mergesort (also called *top-down* mergesort) is one of the fastest sorting algorithms out there and is a great example of the *divide-and-conquer* technique for efficient algorithm design. What mergesort does is it recursively sorts the left half of the array, then the right, and then merges the two sorted subarrays back together. Studying a stack trace (like the one below) is helpful to understand what is actually happening in the recursive calls.

    sort(T E S T)
      sortSubarray(T E S T, index 0 and 1)
        sortSubarray(T E S T, index 0 and 0)
        sortSubarray(T E S T, index 1 and 1)
        merge(T E S T, index 0, 0 and 1)
      sortSubarray(E T S T, index 2 and 3)
        sortSubarray(E T S T, index 2 and 2)
        sortSubarray(E T S T, index 3 and 3)
        merge(E T S T, index 2, 2 and 3)
      merge(E T S T, index 0, 1, and 3)

    RESULT: E S T T

#### Time/Space Complexity for Mergesort

The time complexity for mergesort is O(n * log<sub>2</sub>n), making it the fastest sort we've studied thus far. In fact, analysis of the complexity of sorting suggests that the lower bound for sorting, in general, is n * log<sub>2</sub>n, which means a sorting algorithm that does less comparisons than mergesort does not exist. With that being said, there are a few optimizations that can be done to speed up mergesort:

* Use insertion sort for sorting the small subarrays
* Test whether the two subarrays are already in order so we can skip the call to merge(). This can be done by testing if array[mid] <= array[mid + 1]
* Eliminate the copy to the auxiliary array by swapping the role of input array and auxiliary array at each level (a bit complicated)

The downside to mergesort is the space complexity, which is O(n). This is due to the use of an auxiliary array with size n to hold the last two sorted subarrays as we merge them back together. While it is possible to do the merging in-place, the solutions are too complicated in practice.

---

### **Bottom-up Mergesort**

Bottom-up mergesort is conceptually similar to top-down mergesort, but instead of merging two larger subarrays, bottom-up mergesort starts by breaking the array into subarrays of size 1, doing 1-by-1 merges, then 2-by-2 merges, then 4-by-4 merges, and so on. The benefit of this approach is shorter code that does not need recursive calls. The tradeoff, however, is code that is more complicated. Like before, I've included a stack trace to show the difference between top-down mergesort and bottom-up mergesort.

    sort(T E S T)
      size = 1:
        merge(T E S T, index 0, 0, and 1)
        merge(E T S T, index 2, 2, and 3)
      size = 2:
        merge(E T S T, index 0, 1, and 3)

    RESULT: E S T T 

I will also note that a modified version of bottom-up mergesort is the method of choice when sorting a linked list because it rearranges the links to sort the list in place.

#### **Time/Space Complexity for Bottom-up Mergesort**

Like mergesort, the time complexity is O(n * log<sub>2</sub>n). When the array length is a power of 2, top-down mergesort and bottom-up mergesort, the same exact number of comparisons are made, just in a different order. If the array length is not a power of 2, the number of comparisons vary.

The space complexity is O(n), just like the top-down version and for the exact same reasons.

---

### **Quicksort**

![Quick Sort GIF](/images/QuickSort.gif)

Finally, we get to quicksort, one of the quickest and most reliable sorting algorithms out there (only worthy competitors are mergesort and heapsort, which we have not covered). Quicksort works by partitioning the array into two parts (stay tuned for 3-way quicksort, which partitions the array into three parts). One part of the array, to the left of the partition, contains all the items less than the partition item, and the other side of the array, to the right of the partition, contains all the items greater than the partition. The left and right side are then quicksorted recursively until the entire array is sorted. Unlike mergesort, which recursively does the left subarray, then the right subarray, and merges the subarrays back together, quicksort partitions the array, and then recursively quicksorts the left and right subarrays.

#### **Time/Space Complexity for Quicksort**

The time complexity for quicksort is O(n * log<sub>2</sub>n), making it just as fast as (on a theoretical level) mergesort. The worst case runtime, however, is O(n<sup>2</sup>) in the case of an already sorted array, because the partitioning scheme just iterates through the array to validate that the pivot is where it should be. To reduce this possibility from happening, the implementation of quicksort in this repository shuffles the array before quicksorting it. The possibility of you shuffling an unsorted array into sorted order is *incredibly* rare.

The space complexity of quicksort is O(log<sub>2</sub>n) because the smallest subarray less than half the size of the entire array, so the recursive call stack is guaranteed to be O(log<sub>2</sub>n).

---

### 3-Way Quicksort

When we implemented quicksort, we partitioned the array into 2 subarrays: the subarray of items less than the pivot and the subarray of items to the right of the pivot. The million dollar question, then, is what do we do about items that are equal to the partitioning item (known as the pivot)? 3-way quicksort seeks to answer this question better than the normal quicksort, which just iterates past items equal to the pivot. In 3-way quicksort, the array is partitioned into 3 parts: less than, equal to, and greater than. This 3-way partitioning scheme is accredited to Edsger Djikstra, who used it to solve the Dutch national flag problem (see the "InterviewQuestions" markdown file in this repository to see my solution to the problem, which is based on 3-way partitioning). 

#### **Time/Space Complexity for 3-Way Quicksort**

Like quicksort, the time complexity is O(n * log<sub>2</sub>n), but the 3-way partitioning scheme allows the algorithm to work faster in the presence of duplicate keys, which is very common in practice. 

The space complexity is O(log<sub>2</sub>n), same as quicksort and for the same reasons.

---

### **Priority Queues**

A priority queue is an *abstract data type* that has the following operations: <br>
* insert(): Inserts a key into the priority queue
* max(): Returns the largest key
* delMax(): Pops the largest key out of the priority queue
* isEmpty(): Returns a boolean representing whether or not the priority queue is empty
* size(): Returns the number of keys in the priority queue

The operations above are for a priority queue that cares about maximum keys. We could easy change the implementation to build a priority queue that works with minimum keys instead if we need to.

#### **Time Complexity for Priority Queue Operations**

The time complexity of basic priority queue operations depends on the implementation details. For instance, we could store the keys in an array, a linked list, or a heap, which we will cover next. For either data structure, we could either sort the keys or choose not to.

For an unordered array:
* Insertion - O(1)
* Popping - O(n)

For a sorted array:
* Insertion - O(n)
* Popping - O(1)

For a heap:
* Insertion - O(logn)
* Popping - O(logn)

---

### **Heaps**

![Example of a Heap](/images/Heaps.png)

A heap looks a lot like a binary search tree, but there are a few key differences:

1. In a heap, the parent node's key is always greater than or equal to the keys of its child.
2. Heaps are *complete* binary trees (all levels except bottom must be full and the bottom level's nodes must be on the left).
3. Heaps are actually implemented in priority queues as arrays in *level-order* (root at index 1, children at index 2 and 3, and so forth). This allows us to represent the tree without having to manage explicit links between the nodes.

If you read (3) carefully, you may be curious as to why the root is at index 1, instead of 0. The simple reason is because starting at index 1 allows us to use two generalized formulas for computing where a node's parent or children are. For the k'th node (in level-order) in a heap, its parent is at index *k / 2* (this is *integer* division) and its children are at indexes *2k* and *2k + 1*.

#### **Heap Maintenance**

As new nodes are added or removed from the heap, the heap may no longer be *heap-ordered*. Luckily for us, there are two ways to restore order to (or *re-heapify*) a heap: swimming and sinking.

#### **Swimming up a Heap**

![Heap Swimming Example](/images/HeapSwim.png)

Sometimes, for whatever reason, a node with a key that is greater than its parent ends up violating the heap invariant. In order to restore order to the heap, the node is said to *swim* up the heap. Pseudocode is given below:

    def swim(int k):
        while we aren't at the root and the parent of the node is less than the node itself:
          swap the k'th node with its parent
          set k to k / 2

#### **Sinking Down a Heap**

![Heap Sinking Example](/images/HeapSink.png)

Another case that might occur is a node with a key that is smaller than its children. To fix this, the node is said to *sink* down the heap. Like before, pseudocode is given below:

    def sink(int k):
        while k still has children nodes:
            set j to the index of the left child
            if the right child is bigger than the left child:
                increment j by 1  
            if the children are both smaller:
                stop
            swap the k'th node with the larger of the two children
            set k to j   

#### **Time Complexity for Heap-based Priority Queues**

Because of the smart design of the data structure, heaps are able to insert and remove the greatest key from a priority queue with a runtime of O(log<sub>2</sub>n). This is significantly faster than the basic implementation we've seen before, and is the basis for the next topic, which is a sorting algorithm that utilizes the power of heaps.

---

### **Heapsort**

![Heap Sort GIF](/images/HeapSort.gif)

Heapsort is, with mergesort and quicksort, considered one of the fastest general sorting algorithms. This sorting algorithm works by taking an array, transforming it into a heap, and then sorting the heap by popping off the max key. In practice, heapsort is not always the best choice because of 3 main reasons:
1. Heapsort's inner loop is longer than quicksort's inner loop
2. Heapsort makes poor use of cache memory (does "index arithmetic" rather than comparisons with nearby keys like other sorting algorithms)
3. Not stable, like mergesort

#### **Building a Heap**

To build a heap from an array, it is possible to build by scanning the array from left to right, calling swim() to properly swap problematic nodes, but we will be clever and go from right to left because it allows us to build smaller subheaps so that our calls to sink() have less to do. Actually, the code for build a heap from an array is so simple that full code is given below:

    public static void heapify(Comparable[] a)
    {
        int N = a.length();
        for (int k = N / 2; k <= 1; k--)
            sink(a, k, N);
    }

Essentially, all we're doing is starting from the middle of the array and calling sink() on each node until we reach index 0. The reason why we can afford to start in the middle of the array is because the right side contains leaf nodes (no children), so they would be subheaps of size 1, meaning there is nothing to sink. Remarkably, this entire process of building a heap can be done in O(n) time.

#### **Sorting a Max Heap**

Once we have a max heap, it is time to actually do the sorting. Like with building the heap, the code is actually very intuitive. To do the sorting, all we do is swap the root node with the last node in the heap and decrement the variable containing the size of the heap (we aren't actually changing the size of the heap, just the index so the code is tricked into thinking the root node that was swapped is gone). After that is done, we call sink() on the new root node to kep everything back in heap-order. We repeat this until there's nothing left in the heap (according to that variable) besides the root. The full heapsort code, including heap construction, is given below:

    public static void heapsort(Comparable[] a)
    {
        // Heap construction
        int N = a.length();
        for (int k = N / 2; k <= 1; k--)
            sink(a, k, N);

        // Sorting the heap
        while (N > 1)
        {
            swap(a, 1, N--);
            sink(a, 1, N);
        }
    }

#### **Time/Space Complexity for Heapsort**

The time complexity for heapsort is O(n * log<sub>2</sub>n) for all cases, making it edge out over quicksort in theory because of quicksort's O(n<sup>2</sup>) worst case runtime. The time complexity for the heap construction is O(n), which gets dominated by the time it takes to sort the heap itself.

The space complexity for heapsort is O(1) because it does the heap construction and sorting in-place. This is the advantage heapsort has over mergesort. Instead of need O(n) space for an auxiliary array like mergesort, heapsort trades stability for the ability to sort in-place, making it ideal for when space is at a premium (think embedded systems, mobile devices).