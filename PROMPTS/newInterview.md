# New Interview Experience - AI Assistant Guide

> This guide helps the AI process new interview experiences and create proper documentation.

---

## How to Use

When you have a new interview experience to add, run this prompt:

```
Process my new interview experience and create proper documentation.

INTERVIEW DATA:
[Paste your interview notes here]

INSTRUCTIONS FOR AI:
1. Parse the interview data and identify:
   - Company name
   - Role applied for
   - Date of interview
   - All questions asked
   - Your answers (whether you solved/could answer or not)

2. For each question, check if you indicated you couldn't answer:
   - If you said "no", "couldn't", "didn't know", "didn't solve" → mark as NEEDS_HELP
   - If you solved it → mark as SOLVED
   - If it was a conceptual question you couldn't answer → mark as NEEDS_EXPLANATION

3. Create file: interview-exp/[company]-[role]-[date].md
   - Format: company-role-date.md (lowercase, hyphens)
   - Example: amazon-sde-2026-02-15.md

4. For SOLVED coding questions:
   - Include the problem description
   - Include your solution code in proper ```java code blocks
   - Add time/space complexity if mentioned

5. For NEEDS_HELP / NEEDS_EXPLANATION questions:
   - Create detailed explanation with:
     - Concept overview
     - Why the answer is what it is
     - Code examples if applicable
     - Related topics for further study

6. If the interview requires a complete project solution (like Spring Boot):
   - Create folder: interview-exp/[company]-[role]-[date]/
   - Create README.md with aggregated answers
   - Create necessary project files
```

---

## What This Prompt Does

### Input Processing
- Parses interview notes to extract company, role, date
- Identifies all technical questions asked
- Categorizes each question as:
  - **SOLVED** - You solved it correctly
  - **NEEDS_HELP** - Coding problem you couldn't solve
  - **NEEDS_EXPLANATION** - Conceptual question you couldn't answer

### Output Generation
- Creates `interview-exp/[company]-[role]-[date].md`
- Updates `all-interview-questions.md` with new questions
- For unsolved problems, adds detailed explanations

---

## When to Use

| Scenario | Action |
|----------|--------|
| Just returned from an interview | Use this prompt to document all questions |
| Want to track interview progress | Use this prompt after each interview |
| Need to review weak areas | Check the NEEDS_HELP questions in created files |

---

## Example

**Input:**
```
Company: Amazon
Role: SDE II
Date: 2026-02-15

Questions:
1. LRU Cache implementation - solved
2. Merge K sorted lists - couldn't solve
3. Explain OOP principles - explained but could go deeper
```

**Output:**
- Creates `interview-exp/amazon-sde-ii-2026-02-15.md`
- Adds LRU Cache to SOLVED section
- Adds Merge K sorted lists to NEEDS_HELP with explanation
- Adds OOP principles to NEEDS_EXPLANATION
- Updates `all-interview-questions.md`

---

## File Naming Convention

| Company | Role | Date | File Name |
|---------|------|-----|------------|
| Amazon | SDE II | 2026-02-15 | `amazon-sde-ii-2026-02-15.md` |
| Google | L4 | 2026-03-01 | `google-l4-2026-03-01.md` |
| Meta | E5 | 2026-03-10 | `meta-e5-2026-03-10.md` |

---

## Related Files

- [all-interview-questions.md](../all-interview-questions.md) - Master file with all Q&A
- [interview-exp/](../interview-exp/) - Individual interview documents