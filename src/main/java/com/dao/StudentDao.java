package com.dao;

import com.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Main Server on 04.01.2017.
 */
@Transactional
@Repository
public class StudentDao {
    @PersistenceContext(name = "collegePersistenceUnit")
    private EntityManager entityManager;

    public List<Student> selectAllElements() {
        try {
            Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM student", Student.class);
            List<Student> resultList = nativeQuery.getResultList();
            return resultList;
        } catch (Exception e) {
            System.out.println("Query failed. Please try again....");
            return null;
        }
    }
}
