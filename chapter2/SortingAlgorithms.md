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

### **Insertion Sort**

### **Bubble Sort**

### **Shell Sort**

### **Mergesort**

### **Quicksort**