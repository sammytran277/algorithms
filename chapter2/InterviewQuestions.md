# **Interview Questions: Sorting Algorithms**

## Table of Contents
* [Elementary Sorts](#i.-elementary-sorts)
* [Mergesort](#ii.-mergesort)
* [Quicksort](#iii.-quicksort)

## **I. Elementary Sorts**

#### 1) **Intersection of two sets.** Given two arrays a[] and b[], each containing n distinct 2D points in the plane, design a subquadratic algorithm to count the number of points that are contained both in array a[] and array b[].

To solve this problem, we'll start by first sorting both arrays. Since the problem explicitly asks for a subquadratic algorithm, we need to use the fastest elementary sort we know of, which is Shellsort. How exactly the points are sorted does not matter as we implement a total order, which means that for all points x, y, and z:

Reflective: x = x <br>
Antisymmetric: if (x < y), then (y > x) and if (x = y), then (y = x) <br>
Transitive: if (x <= y) and (y <= z), then (x <= z) <br>

Once the two arrays are sorted, we want to quickly identify points that are in both a[] and b[]. A brute force solution would be to use nested for-loops, but that would cause the entire algorithm's runtime to be dominated by n<sup>2</sup>. Binary search seems like a smart choice because it makes use of the sorted nature of the arrays.

#### Pseudocode:

    def setIntersectionLength(Point[] a, Point[] b):
        shellsort array a
        shellsort array b

        initialize counter to 0
        for i from 0 to the length of a:
            if binary search for a[i] in b finds a[i]:
                increment the counter by 1
        
        return the counter

#### Time/Space Complexity:

Shellsorting each array on average is an O(n<sup>3/2</sup>) operation. <br>
Binary search has a time complexity of O(log<sub>2</sub>n) and is called n times <br>

Writing the number of operations as a function of the array size, n:
f(n) = (2 * n<sup>3/2</sup>) + (n * log<sub>2</sub>n) <br>
~f(n) = 2 * n<sup>3/2</sup>

The entire algorithm is bottlenecked by ~f(n), so the time complexity is O(n<sup>3/2</sup>) after dropping the constant 2, which is indeed subquadratic as the problem asks for.

The space complexity for this algorithm is O(1) because shellsort and binary search have a space complexity of O(1). We only really need to allocate some space for an integer to count how many intersections we've seen.

#### 2) **Permutation.** Given two integer arrays of size n, design a subquadratic algorithm to determine whether one is a permutation of the other. That is, do they contain exactly the same entries but, possibly, in a different order.

To determine if two arrays are permutations of each other, we can sort both of them and then compare both arrays, one item at a time. If they are indeed permutations of each other, they should look the same when sorted.

#### Pseudocode:

    def isPermutation(int[] a, int[] b):
        shellsort array a
        shellsort array b

        for i from 0 to the length of a:
            if a[i] is not equal to b[i]:
                return false
        
        return true

#### Time/Space Complexity:

Like before, we will consider Shellsort to be a O(n<sup>3/2</sup>) operation. After shellsorting both arrays, we just need to scan through each element of the arrays, one item at a time.

f(n) = (2 * n<sup>3/2</sup>) + n <br>
~f(n) = (2 * n<sup>3/2</sup>)

The largest term is the first one, so the entire algorithm has a time complexity of O(n<sup>3/2</sup>).

Like in the previous problem (and for similar reasons), the space complexity is O(1).

#### 3) **Dutch national flag.** Given an array of n buckets, each containing a red, white, or blue pebble, sort them by color. The allowed operations are below:

* swap(i, j): swap the pebble in bucket i with the pebble in bucket j.
* color(i): determine the color of the pebble in bucket i.

The performance requirements are as follows:
* At most n calls to color().
* At most n calls to swap().
* Constant extra space.

The Dutch national flag is a horizontal bar of red, then white, then blue, so for this problem, we will consider red < white < blue. We'll assume the input looks something like: [b1, b2, ..., bn]. Since we know that there are only three colors to consider and we know the order of the colors, we can divide the array into three parts: red, white, and blue. We then make use of three pointers to do the partitioning in place, in a style similar to the partitioning done in quicksort.

#### Pseudocode:

    def flagSort(Bucket[] a):
        initialize a variable called current color
        set pointer i and j to index 0
        set pointer k to index length of a - 1

        while j is less than k:
            set current color to color(j)
            if the current color is red:
                swap(j, i)
                increment i and j
            else if the current color is white:
                increment j
            else:
                swap(j, k) 
                decrement k

        set current color to color(k)

        if the current color is red:
            swap(k, i)

#### Time/Space Complexity:

Since the algorithm above meets the requirement of at most n calls to color() and swap(), the time complexity is O(n).

The space complexity (as required above) is constant, or O(1).

---

## II. Mergesort

#### 1) Merging with smaller auxiliary array. Suppose that the subarray a[0] to a[*n−1*] is sorted and the subarray a[*n*] to a[*2\*n−1*] is sorted. How can you merge the two subarrays so that a[0] to a[*2\*n−1*] is sorted using an auxiliary array of length n (instead of *2n*)?

To merge with a smaller auxiliary array, we'll just copy a[0..n - 1] to aux[] and use three pointers i, j, and k to do the merging in a similar way to the normal merge with an auxiliary array of size *2n*.

#### Pseudocode:

    def merge(int[] a, int n):
        initialize aux[] to have size n

        for every item from index 0 to n:
            copy the item to aux[]
        
        initialize and set point i and k to 0
        initialize and set pointer j to n

        while the i or j pointer have not been exhausted:
            if the i pointer is exhausted:
                break out of the loop
            else if the j pointer is exhausted:
                set a[k] to aux[i]
                increment i and k
            else if aux[i] < a[j]:
                set a[k] to aux[i]
                increment i and k
            else:
                set a[k] to a[j]
                increment j and k

#### Time/Space Complexity:

The time complexity of the merging algorithm is O(n) because we need to compare all the items in the array in order to merge them back together properly.

The space complexity is O(n/2) in practice (n/2 because we're typically merging two subarrays of roughly the same size), but from a theoretical standpoint, this is still O(n).

#### 2) Counting inversions. An inversion in an array a[] is a pair of entries a[i] and a[j] such that i < j but a[i] > a[j]. Given an array, design a linearithmic algorithm to count the number of inversions.

TBD


#### 3) Shuffling a linked list. Given a singly-linked list containing n items, rearrange the items uniformly at random. Your algorithm should consume a logarithmic (or constant) amount of extra memory and run in time proportional to *n\*logn* in the worst case.

TBD

---

## III. Quicksort
        
#### 1) Nuts and bolts. A disorganized carpenter has a mixed pile of n nuts and n bolts. The goal is to find the corresponding pairs of nuts and bolts. Each nut fits exactly one bolt and each bolt fits exactly one nut. By fitting a nut and a bolt together, the carpenter can see which one is bigger (but the carpenter cannot compare two nuts or two bolts directly). Design an algorithm for the problem that uses at most proportional to *n\*logn* compares (probabilistically).

TBD

#### 2) Selection in two sorted arrays. Given two sorted arrays a[] and b[], of lengths *n<sub>1</sub>* and *n<sub>2</sub>* and an integer 0 <= *k* <= *n<sub>1</sub>* + *n<sub>2</sub>*, design an algorithm to find a key of rank *k*. The order of growth of the worst case running time of your algorithm should be *logn*, where *n* = *n<sub>1</sub>* + *n<sub>2</sub>.*

TBD

#### 3) Decimal dominants. Given an array with nn keys, design an algorithm to find all values that occur more than *n/10* times. The expected running time of your algorithm should be linear.

TBD