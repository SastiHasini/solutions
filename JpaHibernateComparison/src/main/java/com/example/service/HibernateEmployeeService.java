package com.example.service;

import com.example.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;

@Service
public class HibernateEmployeeService {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateEmployeeService(EntityManagerFactory entityManagerFactory) {
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    public Integer addEmployee(Employee employee) {
        // Hibernate is the ORM implementation that executes the persistence work.
        // Unlike Spring Data JPA, this uses the native SessionFactory/Session API.
        Session session = null;
        Transaction transaction = null;
        Integer employeeId = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            employeeId = (Integer) session.save(employee);
            transaction.commit();
        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw exception;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return employeeId;
    }
}