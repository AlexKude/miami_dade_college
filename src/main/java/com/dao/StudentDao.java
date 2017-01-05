package com.dao;

import com.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Main Server on 04.01.2017.
 */
@Transactional
@Repository
public class StudentDao {
    @PersistenceContext(name = "collegePersistenceUnit")
    private EntityManager entityManager;

    public List<Student> selectAllStudents() throws RuntimeException {
        try {
            Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM student", Student.class);
            List<Student> resultList = nativeQuery.getResultList();
            return resultList;
        } catch (Exception e) {
            throw new RuntimeException("Query failed. Please try again....");
        }
    }

    public Student selectStudent(int id) throws RuntimeException {
        try {
            Student student = entityManager.find(Student.class, id);

            return student;
        } catch (Exception e) {
            throw new RuntimeException("Query failed. Please try again....");
        }
    }

    public void createStudent(Student student) throws RuntimeException {
        try {
            entityManager.merge(student);
        } catch (Exception e) {
            throw new RuntimeException("Query failed. Please try again....");
        }
    }

    public void updateStudent(Student student) throws RuntimeException {
        try {
            entityManager.merge(student);
         } catch (Exception e) {
            throw new RuntimeException("Query failed. Please try again....");
        }
    }

    public void deleteStudent(int id) throws RuntimeException{
        try {
            Student student = entityManager.find(Student.class, id);
            entityManager.remove(student);
        } catch (Exception e) {
            throw new RuntimeException("Query failed. Please try again....");
        }
    }


}
