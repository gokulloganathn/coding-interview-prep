# Coding Interview Prep - Solved Problems

> A comprehensive collection of coding problems solved with intuitions, explanations, and file references, organized by DSA Roadmap.

---

## Table of Contents

- [Arrays & Hashing](#arrays--hashing)
- [Two Pointers](#two-pointers)
- [Sliding Window](#sliding-window)
- [Strings](#strings)
- [Linked List](#linked-list)
- [Stack](#stack)
- [Queue & Deque](#queue--deque)
- [Trees & Tries](#trees--tries)
- [Heap / Priority Queue](#heap--priority-queue)
- [Backtracking](#backtracking)
- [Graphs](#graphs)
- [Dynamic Programming](#dynamic-programming)
- [Greedy](#greedy)
- [Intervals](#intervals)
- [Binary Search](#binary-search)
- [Bitwise Operations](#bitwise-operations)
- [Sorting](#sorting)
- [Recursion](#recursion)
- [Mathematics & Number Theory](#mathematics--number-theory)

---

## Arrays & Hashing

| # | Problem | Intuition | File |
|---|---------|-----------|------|
| 1 | **Reverse Array** | Two pointer approach: swap `arr[start]` with `arr[end]`, move start++, end--. O(n) time, O(1) space. | [ReverseArray.java](coding-prep/app/src/main/java/coding/prep/Arrays/ReverseArray.java) |
| 2 | **Prime Numbers** | Check divisibility from 2 to √n. If no divisor found, it's prime. | [PrimeNo.java](coding-prep/app/src/main/java/coding/prep/Arrays/PrimeNo.java) |
| 3 | **Count Numbers with Even Digits** | Count digits using while loop `numb /= 10` or `Math.log10(n) + 1`. Check if count % 2 == 0. | [EvenDigits.java](coding-prep/app/src/main/java/coding/prep/LinearSearch/EvenDigits.java) |
| 4 | **Richest Customer** | Sum each row using `Arrays.stream(row).sum()`. Track maximum wealth. | [Richest.java](coding-prep/app/src/main/java/coding/prep/twoDarrays/Richest.java) |

---

## Two Pointers

---

## Sliding Window

---

## Strings

| # | Problem | Intuition | File |
|---|---------|-----------|------|
| 1 | **String Modification** | String is immutable - each modification creates new object. Use StringBuilder for mutable strings to avoid O(n²) complexity. | [ModifyString.java](coding-prep/app/src/main/java/coding/prep/Strings/ModifyString.java) |

---

## Linked List

---

## Stack

---

## Queue & Deque

---

## Trees & Tries

---

## Heap / Priority Queue

---

## Backtracking

| # | Problem | Intuition | File |
|---|---------|-----------|------|
| 1 | **Generate Subsets (Iteration)** | Start with `[[]]`. For each number, duplicate existing subsets and add number to each copy. O(n × 2^n) time. | [SubSetWithIteration.java](coding-prep/app/src/main/java/coding/prep/recursionSubSet/SubSetWithIteration.java) |
| 2 | **Generate Subsets (Recursion)** | Two choices for each character: include or exclude. Recurse building string. Base: when string empty, print result. | [possibleSubsets.java](coding-prep/app/src/main/java/coding/prep/recursionSubSet/possibleSubsets.java) |
| 3 | **Skip Character** | If char == 'a', skip it. Otherwise include in result. Build string by concatenating valid chars. | [SkipCharacter.java](coding-prep/app/src/main/java/coding/prep/recursionSubSet/SkipCharacter.java) |

---

## Graphs

---

## Dynamic Programming

---

## Greedy

---

## Intervals

---

## Binary Search

| # | Problem | Intuition | File |
|---|---------|-----------|------|
| 1 | **Binary Search (Ascending/Descending)** | Use `start + (end - start) / 2` to avoid overflow. For ascending: move `end = mid - 1` if target < mid, else `start = mid + 1`. For descending, reverse logic. | [BinarySearch.java](coding-prep/app/src/main/java/coding/prep/BinarySearch/BinarySearch.java) |
| 2 | **Ceiling Number** | Find the smallest number >= target. When `arr[mid] > target`, potential answer found - move end to `mid - 1`. Continue until start exceeds end. | [CeilingAndFloorNumber.java](coding-prep/app/src/main/java/coding/prep/BinarySearch/CeilingAndFloorNumber.java) |
| 3 | **Ceiling Letter** | Find smallest character > target. Similar to ceiling number but wrap around using `arr[start % arr.length]` for edge cases like target > all chars. | [CeilingLetter.java](coding-prep/app/src/main/java/coding/prep/BinarySearch/CeilingLetter.java) |
| 4 | **First and Last Occurrence** | Two separate binary searches - one for leftmost (move end = mid - 1 when `arr[mid] >= target`), one for rightmost (move start = mid + 1 when `arr[mid] <= target`). | [FirstAndLastOccurence.java](coding-prep/app/src/main/java/coding/prep/BinarySearch/FirstAndLastOccurence.java) |
| 5 | **Infinite Array Search** | First find the range by doubling end: `end = end + (end - start + 1) * 2`. Then apply binary search within found range. | [InfiniteArraySearch.java](coding-prep/app/src/main/java/coding/prep/BinarySearch/InfiniteArraySearch.java) |
| 6 | **Peak in Mountain Array** | Compare `arr[mid]` with `arr[mid + 1]`. If increasing, peak is to right (`start = mid + 1`). If decreasing, peak is to left or at mid (`end = mid`). | [PeakInMountain.java](coding-prep/app/src/main/java/coding/prep/BinarySearch/PeakInMountain.java) |
| 7 | **Search in Mountain** | First find peak using mountain array logic, then binary search in left part (ascending), then right part (descending). | [SearchInMountain.java](coding-prep/app/src/main/java/coding/prep/BinarySearch/SearchInMountain.java) |
| 8 | **Find in Rotated Sorted Array** | Find pivot (largest element) first. Then determine which half contains target - check if target is between start and mid or mid and end. | [FIndInRotatedArray.java](coding-prep/app/src/main/java/coding/prep/BinarySearch/FIndInRotatedArray.java) |
| 9 | **Find in Rotated Array with Duplicates** | Same as above but handle duplicates by checking `arr[start] <= arr[middle]` to decide which half is sorted. | [FIndInRotatedArrayWithDup.java](coding-prep/app/src/main/java/coding/prep/BinarySearch/FIndInRotatedArrayWithDup.java) |
| 10 | **Largest Sum in Split Array** | Binary search on answer. Min = max element, Max = sum of all. For each mid, count subarrays needed - if sum exceeds mid, start new subarray. | [LargestSumInSplitArray.java](coding-prep/app/src/main/java/coding/prep/BinarySearch/LargestSumInSplitArray.java) |
| 11 | **My Sqrt** | Binary search to find integer square root. Search range [0, n]. If mid*mid == num, return mid. If mid*mid < num, search right half. | [MySqrt.java](coding-prep/app/src/main/java/coding/prep/BS_Assignments/MySqrt.java) |

---

## Bitwise Operations

| # | Problem | Intuition | File |
|---|---------|-----------|------|
| 1 | **Odd or Even** | LSB (Least Significant Bit) decides odd/even. If `n & 1 == 1` → odd, else even. Because `2^k` for k>0 is always even. | [OddOrEven.java](coding-prep/app/src/main/java/coding/prep/Bitwise/OddOrEven.java) |
| 2 | **Power of Two** | Use `n & (n - 1)` trick. If result is 0, it's a power of 2. Because `n-1` flips all bits after the single set bit. | [PowerOfTwoOrNot.java](coding-prep/app/src/main/java/coding/prep/Bitwise/PowerOfTwoOrNot.java) |
| 3 | **Magic Number** | Represent number in base 5 using bits. For each bit set in n, add `base^position`. Extract LSB with `n & 1`, then right shift. | [MagicNumber.java](coding-prep/app/src/main/java/coding/prep/Bitwise/MagicNumber.java) |
| 4 | **Value of A to Power of B** | Fast exponentiation using binary. For each set bit in exponent, multiply base. Square base each iteration. | [ValueOfAToPowerOfB.java](coding-prep/app/src/main/java/coding/prep/Bitwise/ValueOfAToPowerOfB.java) |
| 5 | **Total Digits in Any Base** | Use log formula: `log_base(n) + 1`. Formula: `(int)(Math.log(num) / Math.log(base)) + 1` | [TotalDigOfNo.java](coding-prep/app/src/main/java/coding/prep/Bitwise/TotalDigOfNo.java) |
| 6 | **Unique Digit in Array** | XOR all elements - duplicates cancel out (`x ^ x = 0`). Order doesn't matter due to associative property. | [UniqueDigitInArray.java](coding-prep/app/src/main/java/coding/prep/Bitwise/UniqueDigitInArray.java) |

---

## Sorting

### Cyclic Sort Problems

| # | Problem | Intuition | File |
|---|---------|-----------|------|
| 1 | **Cyclic Sort Basic** | Place each number at its correct index `arr[i] - 1`. Swap if not at correct position. O(n) time, O(1) space. | [CyclicSort.java](coding-prep/app/src/main/java/coding/prep/Sorting/CyclicSort/CyclicSort.java) |
| 2 | **Missing Number** | Apply cyclic sort, then find index where `arr[j] != j + 1`. Return `j + 1`. Edge: return `n` if all placed correctly. | [MissingNumber.java](coding-prep/app/src/main/java/coding/prep/Sorting/CyclicSort/problems/MissingNumber.java) |
| 3 | **Find Duplicate Number** | Same cyclic sort. Find where `arr[j] != j + 1` after sorting - that element is duplicate. | [OneDuplNumber.java](coding-prep/app/src/main/java/coding/prep/Sorting/CyclicSort/problems/OneDuplNumber.java) |
| 4 | **Set Mismatch** | After cyclic sort, element at wrong index gives duplicate, index+1 gives missing. | [SetMismatch.java](coding-prep/app/src/main/java/coding/prep/Sorting/CyclicSort/problems/SetMismatch.java) |
| 5 | **First Missing Positive** | Ignore negatives and numbers > n. After sorting, first index where `arr[j] != j+1` gives answer. Edge: return `n+1`. | [FirstMissingPositive.java](coding-prep/app/src/main/java/coding/prep/Sorting/CyclicSort/problems/FirstMissingPositive.java) |
| 6 | **All Missing Numbers** | After cyclic sort, collect all indices where `arr[j] != j + 1`. Add `j + 1` to result. | [AllMissingNumber.java](coding-prep/app/src/main/java/coding/prep/Sorting/CyclicSort/problems/AllMissingNumber.java) |
| 7 | **All Duplicate Numbers** | Use HashSet to collect elements at wrong indices. | [AllDuplNumber.java](coding-prep/app/src/main/java/coding/prep/Sorting/CyclicSort/problems/AllDuplNumber.java) |

### Basic Sorting Algorithms

| # | Problem | Intuition | File |
|---|---------|-----------|------|
| 1 | **Bubble Sort** | Compare adjacent elements and swap if wrong order. Repeat until sorted. O(n²) time. | [BubbleSort.java](coding-prep/app/src/main/java/coding/prep/Sorting/BubbleSort.java) |
| 2 | **Selection Sort** | Find minimum from unsorted portion, swap with first unsorted position. O(n²) time. | [SelectionSort.java](coding-prep/app/src/main/java/coding/prep/Sorting/SelectionSort.java) |
| 3 | **Insertion Sort** | Build sorted array one element at a time. Shift elements greater than current to right. O(n²) time. | [InsertionSort.java](coding-prep/app/src/main/java/coding/prep/Sorting/InsertionSort.java) |

---

## Recursion

| # | Problem | Intuition | File |
|---|---------|-----------|------|
| 1 | **Fibonacci** | `fb(n) = fb(n-1) + fb(n-2)`. Base: if n < 2 return n. Golden ratio formula: `(α^n / √5)` where α = (1+√5)/2 | [Fibonnaci.java](coding-prep/app/src/main/java/coding/prep/Recursion/Fibonnaci.java) |
| 2 | **Binary Search (Recursive)** | Divide array at mid. If `arr[mid] == target` return mid. If target < mid, search left `bs(s, mid-1)`. Else search right `bs(mid+1, e)`. | [BinarySearch.java](coding-prep/app/src/main/java/coding/prep/Recursion/BinarySearch.java) |
| 3 | **Check if Array Sorted** | Compare `arr[start] <= arr[start+1]`. Recurse with `start+1`. Base: `start == length-2`. | [IsSorted.java](coding-prep/app/src/main/java/coding/prep/recrsionArrays/IsSorted.java) |
| 4 | **Get All Target Indexes** | Add index to list if `arr[i] == target`. Recurse with `i+1`. Combine results from all calls. | [GetAllTrgtIndexes.java](coding-prep/app/src/main/java/coding/prep/recrsionArrays/GetAllTrgtIndexes.java) |
| 5 | **Print Pattern** | Two patterns - inverted and normal. Use recursion to print stars before and after recursive call for different patterns. | [PrintPatternWithRecursio.java](coding-prep/app/src/main/java/coding/prep/recrsionArrays/PrintPatternWithRecursio.java) |
| 6 | **Sort with Recursion** | Implement bubble sort, selection sort, merge sort, quick sort using recursion. Quick sort is not stable. | [SortWithRecc.java](coding-prep/app/src/main/java/coding/prep/recrsionArrays/SortWithRecc.java) |

---

## Mathematics & Number Theory

---

## Problem Count Summary

| Category | Count |
|----------|-------|
| Arrays & Hashing | 4 |
| Two Pointers | 0 |
| Sliding Window | 0 |
| Strings | 1 |
| Linked List | 0 |
| Stack | 0 |
| Queue & Deque | 0 |
| Trees & Tries | 0 |
| Heap / Priority Queue | 0 |
| Backtracking | 3 |
| Graphs | 0 |
| Dynamic Programming | 0 |
| Greedy | 0 |
| Intervals | 0 |
| Binary Search | 11 |
| Bitwise Operations | 6 |
| Sorting | 10 |
| Recursion | 6 |
| Mathematics & Number Theory | 0 |
| **Total** | **41** |

---

## Key Patterns & Intuitions

### Binary Search Variations
- **Standard BS**: `start + (end - start) / 2` to avoid overflow
- **Lower Bound**: Move `end = mid - 1` when `arr[mid] >= target`
- **Upper Bound**: Move `start = mid + 1` when `arr[mid] <= target`
- **Rotated Array**: Find pivot first, then search in correct half

### Cyclic Sort Pattern
- Place each element at index `value - 1`
- Swap until element is at correct position
- Time: O(n), Space: O(1)

### Bitwise Tricks
- **Power of 2**: `n & (n-1) == 0`
- **Odd/Even**: `n & 1`
- **Unique Element**: XOR all elements

### Recursion Template
```
function solve(params):
    if base_condition:
        return base_value
    // recursive calls
    return combine(results)
```

### Backtracking Pattern
- Include/exclude choices
- Explore all possibilities
- Backtrack when needed
- Base case: all choices made

---

## Next Steps to Expand

**Topics to add:**
- Two Pointers (e.g., container with most water, merge sorted arrays)
- Sliding Window (e.g., longest substring without repeating, min window substring)
- Linked List (e.g., reverse, merge, cycle detection)
- Stack (e.g., valid parentheses, next greater element)
- Trees & Tries (e.g., inorder/preorder/postorder, BST operations)
- Graphs (e.g., BFS, DFS, Dijkstra, topological sort)
- Dynamic Programming (e.g., knapsack, coin change, LIS)
- Greedy (e.g., interval scheduling, activity selection)

---

*Last Updated: April 2026*
