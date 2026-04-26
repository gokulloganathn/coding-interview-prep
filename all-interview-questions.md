# Interview Questions & Answers

> Comprehensive collection of interview questions from various companies with detailed answers and code solutions.

---

## Table of Contents

- [Equitas (Java Full-Stack)](#equitas-java-full-stack)
- [Platform Science](#platform-science)
- [Walmart](#walmart)
- [Coding Challenges](#coding-challenges)

---

## Equitas (Java Full-Stack)

*Date: 2026-01-31*

### 1. How do you authenticate the user in a Spring Boot API?

**Answer:**
- Use Spring Security to secure endpoints
- Typical flow: user submits credentials → server authenticates using `UserDetailsService` + `PasswordEncoder` → on success returns a JWT access token → client includes token in `Authorization` header → `OncePerRequestFilter` validates token and sets `SecurityContext`

**Code:**

```java
package com.example.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class JwtUtil {
    private final String secret = "replace_with_strong_secret_here_change_me_please_!";
    private final long expirationMs = 1000L * 60 * 60; // 1 hour

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String username, Map<String, Object> claims) {
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims != null ? claims : new HashMap<>())
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expirationMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token, String username) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
```

---

### 2. What are the real-time use cases and where/how do you use tokens in Spring Boot?

**Answer:**
- **Stateless authentication** for REST APIs and microservices
- **Mobile clients / SPAs**: token-based auth decouples server-side sessions
- **Authorization** via claims/roles in token
- **Microservice-to-microservice** auth
- **Signed URLs** for temporary access (cloud storage)

---

### 3. What are methods in REST API?

**Answer:**

| Method | Description | Safe | Idempotent |
|--------|-------------|------|------------|
| GET | Retrieve resource | ✓ | ✓ |
| POST | Create new resource | ✗ | ✗ |
| PUT | Replace resource | ✗ | ✓ |
| PATCH | Partial update | ✗ | ✗ |
| DELETE | Remove resource | ✗ | ✓ |
| HEAD | Get headers only | ✓ | ✓ |
| OPTIONS | Supported methods | ✓ | ✓ |

---

### 4. How do you build the API into a jar file?

**Answer:**

```bash
# With Maven
mvn clean package

# With Gradle
./gradlew bootJar
```

The `spring-boot-maven-plugin` produces an executable jar with embedded Tomcat server.

---

### 5. What is use of GCP Cloud Storage bucket?

**Answer:**
- Object storage for images, backups, static assets
- ETL staging area
- Signed URLs for temporary access
- Lifecycle rules for automatic archiving
- Integration with Cloud Functions

**Code:**

```java
package com.example.gcp;

import com.google.cloud.storage.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SignedUrlExample {
    public URL generateV4UploadSignedUrl(String bucketName, String objectName) {
        Storage storage = StorageOptions.getDefaultInstance().getService();
        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, objectName).build();

        URL signedUrl = storage.signUrl(blobInfo, 15, TimeUnit.MINUTES,
                Storage.SignUrlOption.httpMethod(HttpMethod.PUT),
                Storage.SignUrlOption.withV4Signature());
        return signedUrl;
    }
}
```

---

### 6. What is JWT token?

**Answer:**
- **JWT (JSON Web Token)** is a compact, URL-safe token format
- Contains three parts: `header.payload.signature`
- Header: algorithm and token type
- Payload: claims (subject, expiration, roles)
- Signature: verified with secret/key

---

## Platform Science

*Date: 2026-01-23*

### 1. Have you used SQL?

**Answer:**
Yes, extensively for data manipulation and retrieval. Key concepts:
- DDL (Data Definition Language): CREATE, ALTER, DROP
- DML (Data Manipulation Language): SELECT, INSERT, UPDATE, DELETE
- DCL (Data Control Language): GRANT, REVOKE
- TCL (Transaction Control): COMMIT, ROLLBACK, SAVEPOINT

---

### 2. What is flush() method used for?

**Answer:**
- Synchronizes the persistence context with the underlying database
- Pending transactions are pushed to DB before:
  - Executing a query
  - Committing a transaction
  - Closing EntityManager

```java
@EntityTransaction
public void saveEntity(EntityManager em, Entity entity) {
    em.persist(entity);
    em.flush(); // Force SQL INSERT immediately
    // Continue with other operations
}
```

---

### 3. How do you authenticate & authorize a user?

**High Level:**
1. User submits credentials → Authentication endpoint
2. Server validates against UserDetailsService
3. On success, generate JWT with roles/claims
4. Client sends JWT in Authorization header
5. Filter validates token and sets SecurityContext
6. Authorization checks if user has required roles

**Deep Dive (OAuth2):**
- OAuth2 uses authorization code flow
- User authenticates via identity provider
- Authorization server issues access token
- Resource server validates token
- JWT contains user info and scopes

---

### 4. Implement streams to find the number of letters in a string

**Code:**

```java
import java.util.*;
import java.util.stream.*;

public class LetterCounter {
    public static void main(String[] args) {
        String str = "hello world";
        
        // Count each letter
        Map<Character, Long> letterCount = str.chars()
            .mapToObj(c -> (char) c)
            .filter(c -> c != ' ')
            .collect(Collectors.groupingBy(
                c -> c,
                Collectors.counting()
            ));
        
        System.out.println(letterCount);
        // Output: {h=1, e=1, l=3, o=2, w=1, r=1, d=1}
    }
}
```

---

### 5. Feedback from HR

> - Focus on integrating SQL with Spring using Hibernate
> - Focus on Authentication mechanism internal working

---

## Walmart

### 1. Print items in A not in B, B not in A, and count difference

**Problem:**
```
A = ["t1","t2","t3","t2","t4"]
B = ["t2","t3","t2","t5"]
Output:
- Items only in A: {"t1","t4"}
- Items only in B: {"t5"}
- Count difference: { "t1": (A:1,B:0), "t4": (A:1,B:0), "t5": (A:0,B:1) }
```

**Solution:**

```java
import java.util.*;

public class SetDifference {
    public static void main(String[] args) {
        String[] A = new String[] {"t1","t2","t3","t2","t4"};
        String[] B = new String[] {"t2","t3","t2","t5"};
        
        // Count frequencies
        Map<String, Integer> cntMapA = new HashMap<>(); 
        Map<String, Integer> cntMapB = new HashMap<>(); 
        
        for(String a : A) {
            cntMapA.put(a, cntMapA.getOrDefault(a, 0) + 1);
        }
        
        for(String b : B) {
            cntMapB.put(b, cntMapB.getOrDefault(b, 0) + 1);
        }
        
        // Items only in A
        Set<String> onlyInA = new HashSet<>(cntMapA.keySet());
        onlyInA.removeAll(cntMapB.keySet());
        System.out.println("Only in A: " + onlyInA);
        
        // Items only in B
        Set<String> onlyInB = new HashSet<>(cntMapB.keySet());
        onlyInB.removeAll(cntMapA.keySet());
        System.out.println("Only in B: " + onlyInB);
        
        // Count difference
        Map<String, int[]> countDiff = new HashMap<>();
        Set<String> allKeys = new HashSet<>(cntMapA.keySet());
        allKeys.addAll(cntMapB.keySet());
        
        for(String key : allKeys) {
            int countA = cntMapA.getOrDefault(key, 0);
            int countB = cntMapB.getOrDefault(key, 0);
            countDiff.put(key, new int[]{countA, countB});
        }
        
        System.out.println("Count difference: " + countDiff);
    }
}
```

**Output:**
```
Only in A: [t1, t4]
Only in B: [t5]
Count difference: {t1=[1,0], t2=[2,2], t3=[1,1], t4=[1,0], t5=[0,1]}
```

---

### 2. Print max amount I can avail within gift limit

**Problem:**
```
Gift Limit: 300
Item values: [120, 90, 250, 30]
Output: [250+30] -> 280 (max within 300)
```

**Solution:**

```java
import java.util.*;

public class MaxGiftAmount {
    public static void main(String[] args) {
        int maxRedeemAmt = 300;
        int[] itemVal = new int[]{120, 90, 250, 30};
        
        // Sort items ascending for greedy approach
        Arrays.sort(itemVal);
        
        int sum = 0;
        List<Integer> selectedItems = new ArrayList<>();
        
        for(int item : itemVal) {
            if(sum + item <= maxRedeemAmt) {
                sum += item;
                selectedItems.add(item);
            }
        }
        
        System.out.println("Selected items: " + selectedItems);
        System.out.println("Total: " + sum);
    }
}
```

**Output:**
```
Selected items: [30, 90, 120]
Total: 240
```

**Note:** For optimal solution (knapsack problem), use dynamic programming:

```java
public class KnapsackDP {
    public static int maxValue(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];
        
        for(int i = 0; i <= n; i++) {
            for(int w = 0; w <= W; w++) {
                if(i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if(wt[i-1] <= w) {
                    dp[i][w] = Math.max(
                        val[i-1] + dp[i-1][w - wt[i-1]],
                        dp[i-1][w]
                    );
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[n][W];
    }
    
    public static void main(String[] args) {
        int W = 300;
        int[] val = new int[]{120, 90, 250, 30};
        int[] wt = new int[]{120, 90, 250, 30};
        int n = val.length;
        
        System.out.println(maxValue(W, wt, val, n));
    }
}
```

---

## Key Interview Topics Summary

| Topic | Priority | Questions |
|-------|----------|-----------|
| Spring Security & JWT | High | Authentication, Token generation, Validation |
| REST API Design | High | HTTP methods, Status codes, Best practices |
| SQL & Hibernate | High | Queries, Joins, Entity relationships |
| OAuth2 | Medium | Flow, Token types, Security |
| GCP Cloud Storage | Medium | Signed URLs, Bucket operations |
| Data Structures | High | Arrays, Maps, Sets, Streams |
| Algorithms | High | Sorting, Searching, DP |

---

*Last Updated: April 2026*