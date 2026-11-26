# Hibernate Native SQL Query
Hibernate allows interaction with databases using HQL, but sometimes Native SQL Queries are required. These are direct SQL queries written in database-specific syntax (MySQL, PostgreSQL, etc.) and executed by Hibernate while still mapping results to entities.

**JPA Native Query**
- It is created via EntityManager.createNativeQuery(), returns Query.
- Can map results to entities or DTOs (limited).
- Purely standard, no Hibernate-specific extensions.

**Hibernate Native Query**
- It is created via Session.createSQLQuery(), returns SQLQuery.
- Supports extra features: addScalar() for non-entity mapping, cache control (setCacheable(), setCacheRegion(), etc.).
- Provides more flexibility than JPA.

Source - [Native SQL Query](https://www.geeksforgeeks.org/java/hibernate-native-sql-query-with-example/)