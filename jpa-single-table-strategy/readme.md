##JPA Inheritance
Inheritence is a key feature of object-oriented programming language in which a child class can acquire the properties of its parent class. This feature enhances reusability of the code.

**JPA Inheritence Annotations**
- @Inheritence 
- @MappedSuperclass
- @DiscriminatorColumn 
- @DiscriminatorValue 

**JPA Inheritence Strategies**
- Single table strategy
- Joined strategy
- Table-per-class strategy

![image](https://www.tutorialspoint.com/jpa/images/inheritance_strategy.png)

1.*Single-Table strategy:*

It takes all classes fields (both super and sub classes) and map them down into a single table known as SINGLE_TABLE strategy. Here discriminator value plays key role in differentiating the values of three entities in one table. 

2.*Joined strategy:*

Joined table strategy is to share the referenced column which contains unique values to join the table and make easy transactions.

3.*Table per class strategy:*

Table per class strategy is to create a table for each sub entity. The staff table will be created but it will contain null records. The field values of Staff table must be shared by TeachingStaff and NonTeachingStaff tables.