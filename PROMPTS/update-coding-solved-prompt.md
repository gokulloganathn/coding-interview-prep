# Prompt: Update CODING_SOLVED.md

> Use this prompt to update the coding solved problems documentation when new problems are added to the coding-prep folder.

---

## Prompt Text

```
Analyze the Java source files in the coding-prep workspace and update the CODING_SOLVED.md file with any new solved problems.

WORKSPACE PATH: c:\Users\gokul\OneDrive\Desktop\gokulloganathn-github\coding-interview-prep\coding-prep\app\src\main\java\coding\prep

INSTRUCTIONS:
1. Search for all .java files recursively in the coding-prep source folder (do not limit to existing categories)
2. For each new Java file found (that isn't already documented):
   - Read the file to understand the problem and solution
   - Extract the intuition from comments and code
   - Determine the DSA pattern/category it belongs to
   - Add entry to the appropriate section in CODING_SOLVED.md following the DSA Roadmap order

3. DSA Roadmap Order (in priority order):
   - Arrays & Hashing
   - Two Pointers
   - Sliding Window
   - Strings
   - Linked List
   - Stack
   - Queue & Deque
   - Trees & Tries
   - Heap / Priority Queue
   - Backtracking
   - Graphs
   - Dynamic Programming
   - Greedy
   - Intervals
   - Binary Search
   - Bitwise Operations
   - Sorting
   - Recursion
   - Mathematics & Number Theory

4. If a new topic is discovered (e.g., Dynamic Programming, Graphs), create a new section for it

5. Update the "Problem Count Summary" table at the end of the file

6. Maintain the existing format:
   - Table with: #, Problem Name, Intuition, File Link
   - Grouped by DSA pattern/category in roadmap order
   - Include key patterns section

7. If a file has explanatory comments at the top, use those as the intuition
8. If the solution uses a known algorithm pattern, note that in the intuition

OUTPUT FILE: c:\Users\gokul\OneDrive\Desktop\gokulloganathn-github\coding-interview-prep\CODING_SOLVED.md
```

---

## What This Prompt Handles

The prompt is designed to discover and categorize problems regardless of folder structure. It maps folders to DSA patterns:

| Folder | DSA Pattern |
|--------|-------------|
| Arrays | Arrays & Hashing |
| LinearSearch | Arrays & Hashing |
| BinarySearch | Binary Search |
| Bitwise | Bitwise Operations |
| Sorting / CyclicSort | Sorting |
| Recursion / recrsionArrays | Recursion |
| recursionSubSet | Backtracking |
| Strings | Strings |
| twoDarrays | Arrays (2D) |
| BS_Assignments | Binary Search |

**New topics not in existing folders will create new sections:**

| New Topic | DSA Pattern |
|-----------|-------------|
| Dynamic Programming | Dynamic Programming |
| Graphs | Graphs |
| Trees / Tries | Trees & Tries |
| Heap | Heap / Priority Queue |
| Greedy | Greedy |

---

## Example Usage

When you add a new file like `coding-prep/app/src/main/java/coding/prep/DP/Knapsack.java`:

1. Copy this prompt
2. Paste into Copilot chat
3. Copilot will:
   - Scan all Java files
   - Identify the new DP category
   - Add Knapsack problem to the Dynamic Programming section
   - Update the summary table

---

## When to Use

- After adding any new Java problem to the coding-prep folder
- When you want to keep your solved problems documentation up to date
- Before preparing for interviews to review all solved problems