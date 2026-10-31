##Hibernate Framework
Hibernate is a Java framework that simplifies the development of Java application to interact with the database. It is an open source, lightweight, ORM (Object Relational Mapping) tool. Hibernate implements the specifications of JPA (Java Persistence API) for data persistence.
##Key features of Hibernate
- ORM Support: Maps Java objects to database tables, reducing boilerplate JDBC code.
- Database Independence: Works with multiple databases using SQL dialects.
- HQL (Hibernate Query Language): Provides database-independent, object-oriented querying.
- Caching Mechanism: Improves performance with first-level and second-level caching.
- LAZY Loading: It is used to delay the loading of associated entities until they are actually accessed. This helps optimize performance by avoiding unnecessary data retrieval at the time of the main entity loading.

##Elements of Hibernate Architecture 
![image](https://media.geeksforgeeks.org/wp-content/uploads/20250823123231351658/java_application.webp)

**1. Configuration**
Configuration is a class which is present in org.hibernate.cfg package. It activates Hibernate framework. It reads both configuration file and mapping files.

**2. SessionFactory**
The SessionFactory interface creates Session objects and maintains a second-level cache. It is heavyweight and thread-safe, so usually one per application.

**3. Session**
The Session interface interacts with the database and provides CRUD operations. It maintains a first-level cache (session-level).

**4. Transaction**
The Transaction interface handles atomic database operations, ensuring data integrity through commit or rollback.

**5. Query**
The Query interface executes HQL, Criteria API or native SQL queries to fetch or manipulate data.

**6. ConnectionProvider**
It is a factory of JDBC connections. It abstracts the application from DriverManager or DataSource

**7. Mapping**
Defines the relationship between Java classes and database tables. Can be done via annotations or XML files.

##Hibernate Workflow
- Application loads configuration (hibernate.cfg.xml).
- Hibernate builds a SessionFactory.
- Application requests a Session from SessionFactory.
- Inside a Session:
1. Begin Transaction
2. Perform CRUD operations
3. Commit or Rollback transaction
- Hibernate translates operations -> SQL-> executes via JDBC.
- Results are returned as Java objects

## Hibernate Caching Levels 
- First-Level Cache (Session-level): Always enabled
- Second-Level Cache (SessionFactory-level): Optional / Configurable

## Advantages Of Hibernate In Java
- Lightweight and open-source – Being lightweight and open-source makes it accessible and efficient.
- Increased performance – Using cache memory helps in fast performance.
- Database Independence – Being database-independent gives it the ability to work with different databases.
- Auto DDL Operations – automatic table creation saves us from manually creating tables.
- It takes care of mapping Java classes databases using XML files without writing any code. We can directly store and retrieve data directly from the database using simple APIs.
- It does not require any application server to operate.
- Minimizes database access with smart fetching strategies.
- It provides simple querying of data.

## Hibernate Mapping
- One-to-One Mapping
- One-to-Many Mapping
- Many-to-One Mapping
- Many-to-Many Mapping
- Component Mapping

## Hibernate/JPA Annotations
- @Embeddable vs @Embedded
- @Entity
- @Table
- @Column
- @Id
- @GeneratedValue
- @Version
- @OrderBy
- @Transient

## Hibernate Lifecycle or Entity Object Lifecycle in Hibernate Framework
- Transient State
- Persistent State
- Detached State
- Removed State

### Main Reference Link 
- [https://www.geeksforgeeks.org/java/hibernate-tutorial/](https://www.geeksforgeeks.org/java/hibernate-tutorial/)
- [https://www.tpointtech.com/hibernate-tutorial](https://www.tpointtech.com/hibernate-tutorial)

 

