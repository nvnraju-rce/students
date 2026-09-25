JPA + Hibernate + H2 - Simple Eclipse Demo

Purpose:
A beginner-friendly example for engineering students.

Technologies:
- JPA (Jakarta Persistence API)
- Hibernate (JPA implementation)
- H2 in-memory/file database
- Maven
- Java 17

Project Structure:

JPAHibernateDemo
|
+-- pom.xml
|
+-- src/main/java/com/rce/jpademo/
|   +-- Student.java
|   +-- StudentDAO.java
|   +-- Main.java
|
+-- src/main/resources/META-INF/
    +-- persistence.xml

How to import into Eclipse:
1. Extract the ZIP.
2. Open Eclipse.
3. File -> Import.
4. Maven -> Existing Maven Projects.
5. Select the extracted JPAHibernateDemo folder.
6. Finish.
7. Wait for Maven dependencies to download.
8. Open Main.java.
9. Right-click -> Run As -> Java Application.

Expected result:
Two Student records are inserted and then read from the H2 database.

Important annotations to explain:
@Entity       -> Java class becomes a database entity/table mapping.
@Table        -> Specifies table name.
@Id           -> Primary key.
@GeneratedValue -> Database/JPA generates the ID.

Important JPA objects:
EntityManagerFactory -> creates EntityManager objects.
EntityManager         -> communicates with persistence context/database.
EntityTransaction     -> begin/commit/rollback.
persist()              -> inserts a new entity.
createQuery()          -> executes JPQL.

Simple architecture:

Main
 |
 v
StudentDAO
 |
 v
EntityManager
 |
 v
JPA
 |
 v
Hibernate
 |
 v
H2 Database

JPQL example:
SELECT s FROM Student s

This is NOT SQL table syntax. "Student" is the entity class name.

Note:
The project uses Java 17 and Maven. Internet is needed the first time Maven downloads Hibernate, JPA and H2 dependencies.
