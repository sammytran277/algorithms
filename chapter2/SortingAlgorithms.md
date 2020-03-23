# **Sorting Algorithms**

## **Introduction**

In chapter 2, we learn about three elementary sorting algorithms (namely, selection sort, insertion sort, and Shellsort) and two classic divide-and-conquer sorting algorithms (mergesort and quicksort). Though not mentioned in the book/course, I've also included bubble sort for fun. Notes on each algorithm are given below.

---

## **Table of Contents**

* [Selection Sort](#selection-sort)
* [Insertion Sort](#insertion-sort)
* [Bubble Sort](#bubble-sort)
* [Shellsort](#shell-sort)
* [Mergesort](#merge-sort)
* [Quicksort](#quick-sort)

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

---

### **Quicksort**