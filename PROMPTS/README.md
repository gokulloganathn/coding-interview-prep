# Prompts README

> Complete guide to all available prompts in this project - when to use them and how they work.

---

## Table of Contents

- [Prompts Overview](#prompts-overview)
- [Prompt Files](#prompt-files)
- [When to Use Each Prompt](#when-to-use-each-prompt)
- [How to Use](#how-to-use)
- [Project Structure](#project-structure)

---

## Prompts Overview

| Prompt File | Purpose | When to Use |
|-------------|---------|-------------|
| [update-coding-solved-prompt.md](update-coding-solved-prompt.md) | Update CODING_SOLVED.md with new coding problems | When you add new Java files to `coding-prep/app/src/main/java/coding/prep/` |
| [newInterview.md](newInterview.md) | Process and document new interview experiences | When you return from an interview and want to document it |
| [all-interview-questions.md](../all-interview-questions.md) | Master file containing all interview Q&A | Auto-updated by newInterview.md prompt |

---

## Prompt Files

### 1. update-coding-solved-prompt.md

**Location:** `PROMPTS/update-coding-solved-prompt.md`

**Purpose:** Update the CODING_SOLVED.md file when you solve new coding problems.

**What it does:**
- Scans all Java files in `coding-prep/app/src/main/java/coding/prep/`
- Categorizes problems by DSA Roadmap pattern (not folder structure)
- Discovers new topics (Dynamic Programming, Graphs, etc.)
- Updates problem count summary

**DSA Roadmap Order:**
```
Arrays & Hashing → Two Pointers → Sliding Window → Strings → 
Linked List → Stack → Queue → Trees & Tries → Heap → 
Backtracking → Graphs → Dynamic Programming → Greedy → 
Intervals → Binary Search → Bitwise → Sorting → Recursion → Math
```

**When to use:**
- After adding any new Java problem to the coding-prep folder

---

### 2. newInterview.md

**Location:** `PROMPTS/newInterview.md`

**Purpose:** Process and document new interview experiences.

**What it does:**
- Parses interview data (company, role, date, questions)
- Categorizes questions as SOLVED / NEEDS_HELP / NEEDS_EXPLANATION
- Creates company-specific markdown files in `interview-exp/`
- Adds questions to the master `all-interview-questions.md`

**When to use:**
- After returning from a technical interview
- When you want to document interview questions for future reference

**Output:**
- Creates `interview-exp/[company]-[role]-[date].md`
- Updates `all-interview-questions.md` with new questions

---

## When to Use Each Prompt

| Scenario | Prompt to Use |
|----------|---------------|
| I added a new LeetCode/HackerRank solution in Java | `update-coding-solved-prompt.md` |
| I just came back from an interview and want to document the questions | `newInterview.md` |
| I want to see all interview questions I've collected | `all-interview-questions.md` |

---

## How to Use

### Using update-coding-solved-prompt.md

1. Copy the prompt text from `PROMPTS/update-coding-solved-prompt.md`
2. Paste it into Copilot chat
3. Copilot will scan your Java files and update CODING_SOLVED.md automatically

### Using newInterview.md

1. Copy the prompt text from `PROMPTS/newInterview.md`
2. Paste your interview notes after `INTERVIEW DATA:`
3. Copilot will create proper documentation

---

## Project Structure

```
coding-interview-prep/
├── PROMPTS/                    # All prompt files
│   ├── README.md              # This file
│   ├── update-coding-solved-prompt.md
│   └── newInterview.md
├── CODING_SOLVED.md           # Auto-updated by prompts
├── all-interview-questions.md # Master interview Q&A
├── interview-exp/             # Individual interview docs
│   ├── Equitas.md
│   ├── PlatformScience.md
│   └── Walmart-coding-ques/
└── coding-prep/              # Your Java solutions
    └── app/src/main/java/coding/prep/
        ├── Arrays/
        ├── BinarySearch/
        ├── Bitwise/
        ├── Recursion/
        ├── Strings/
        └── ...
```

---

## DSA Roadmap Order (for categorization)

Problems are categorized in this order in CODING_SOLVED.md:

1. Arrays & Hashing
2. Two Pointers
3. Sliding Window
4. Strings
5. Linked List
6. Stack
7. Queue & Deque
8. Trees & Tries
9. Heap / Priority Queue
10. Backtracking
11. Graphs
12. Dynamic Programming
13. Greedy
14. Intervals
15. Binary Search
16. Bitwise Operations
17. Sorting
18. Recursion
19. Mathematics & Number Theory

---

*Last updated: April 26, 2026*