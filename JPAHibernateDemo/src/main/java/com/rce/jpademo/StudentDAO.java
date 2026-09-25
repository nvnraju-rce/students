package com.rce.jpademo;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//In JPA (Java Persistence API), persistent data means data from a 
//Java object that is stored permanently in a database.
public class StudentDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("StudentPU");

    public void save(Student student) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(student);

            em.getTransaction().commit();

            System.out.println("Student saved successfully.");

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("Error while saving: " + e.getMessage());

        } finally {
            em.close();
        }
    }

    public List<Student> findAll() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT s FROM Students s",
                    Student.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}
