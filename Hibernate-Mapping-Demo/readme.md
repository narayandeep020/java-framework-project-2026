# Hibernate Mapping

### One-to-One Mapping
In Hibernate, one-to-one mapping defines a relationship where one entity instance is associated with exactly one instance of another entity. It represents a real-world relationship such as:

- A employee has one address.
- A student has one college ID.
- A vehicle has one engine.

**Types of One-to-One Mapping**

- **Unidirectional**: Only one entity maintains the reference of the other.
- **Bidirectional**: Both entities hold references to each other, allowing navigation from either side.

Source - [one-to-one-mapping](https://www.tpointtech.com/hibernate-one-to-one-example-using-annotation)
### One-to-Many Mapping
Hibernate One-to-Many mapping defines a relationship where one entity is associated with multiple instances of another entity. It is commonly used to model parent-child relationships in database-driven applications.
- Supports bidirectional mapping for navigation from both parent and child
- Provides cascade options to propagate operations like save and delete

Source - [one-to-many-mapping](https://www.tpointtech.com/hibernate-one-to-many-mapping-using-annotation-example)
### Many-to-One Mapping
In relational databases, a Many-to-One relationship occurs when multiple records in one table are associated with a single record in another table.

For example, in a workplace scenario:

- Many employees come from same address.
- Each employee is linked to a single company address.

Source - [many-to-one-mapping](https://www.tpointtech.com/hibernate-many-to-one-example-using-annotation)
### Many-to-Many Mapping
A Many-to-Many relationship occurs when multiple records in one table are associated with multiple records in another table. For example:

- An employee can have multiple skills.
- A skill can belong to multiple employees.

Source - [many-to-many-mapping](https://www.geeksforgeeks.org/java/hibernate-many-to-many-mapping/)