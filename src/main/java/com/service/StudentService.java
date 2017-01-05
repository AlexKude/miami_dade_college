package com.service;

import com.dao.StudentDao;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Main Server on 04.01.2017.
 */
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    List<Student> studentsSelected;

    public void createStudent(Student student){
        studentDao.createStudent(student);
    }

    public boolean updateStudent(Student student){
        boolean flag = false;
        studentsSelected = studentDao.selectAllStudents();
        for (Student studentSelected : studentsSelected) {
            if(student.getId() == studentSelected.getId()){
                flag = true;
            }
        }
        if(!flag){
            return flag;
        }
        studentDao.updateStudent(student);
        return flag;
    }

    public boolean deleteStudent(int id){
        boolean flag = false;
        studentsSelected = studentDao.selectAllStudents();
        for (Student studentSelected : studentsSelected) {
            if(id == studentSelected.getId()){
                flag = true;
            }
        }
        if(!flag){
            return flag;
        }
        studentDao.deleteStudent(id);
        return flag;
    }
}
