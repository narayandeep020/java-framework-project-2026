# Cascade Types in JPA and Hibernate

Source code for study [jpa-and-hibernate-cascade-types](https://www.javaguides.net/2018/11/guide-to-jpa-and-hibernate-cascade-types.html)

## Different Cascade Types in Hibernate

- **CascadeType.ALL** − A cascading type in Hibernate that specifies that all state transitions (create, update, delete, and refresh) should be cascaded from the parent entity to the child entities.


- **CascadeType.PERSIST** − A cascading type in Hibernate that specifies that the create (or persist) operation should be cascaded from the parent entity to the child entities.


- **CascadeType.MERGE** − A cascading type in Hibernate that specifies that the update (or merge) operation should be cascaded from the parent entity to the child entities.


- **CascadeType.REMOVE** − A cascading type in Hibernate that specifies that the delete operation should be cascaded from the parent entity to the child entities.

- **CascadeType.REFRESH** − A cascading type in Hibernate that specifies that the refresh operation should be cascaded from the parent entity to the child entities.


- **CascadeType.DETACH** − A cascading type in Hibernate that specifies that the detach operation should be cascaded from the parent entity to the child entities.


- **CascadeType.REPLICATE** − A cascading type in Hibernate that specifies that the replicate operation should be cascaded from the parent entity to the child entities.


- **CascadeType.SAVE_UPDATE** − A cascading type in Hibernate that specifies that the save or update operation should be cascaded from the parent entity to the child entities.