# **Sorting Algorithms**

## **Introduction**

In chapter 2, we learn about three elementary sorting algorithms (namely, selection sort, insertion sort, and Shell sort) and two classic divide-and-conquer sorting algorithms (mergesort and quicksort). Though not mentioned in the book/course, I've also included bubble sort for fun. Notes on each algorithm are given below.

---

## **Table of Contents**

* [Selection Sort](#selection-sort)
* [Insertion Sort](#insertion-sort)
* [Bubble Sort](#bubble-sort)
* [Shell Sort](#shell-sort)
* [Merge Sort](#merge-sort)
* [Quick Sort](#quick-sort)

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

The next sorting algorithm to consider is insertion sort. Insertion sort works by, like selection sort, dividing the array into a sorted and unsorted subarray. As the algorithm iterates through the unsorted subarray, it goes back into the sorted subarray to find where the current value should be placed such that the sorted subarray is still sorted.Unlike selection sort, insertion sort's speed drastically increases if the array's entries are partially (or even completely) sorted. This fact will play an important role when we study the last of the elementary sorting algorithms, Shell sort.

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

### **Shell Sort**

---

### **Mergesort**

---

### **Quicksort**