package com.service;

import com.dao.StudentDao;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Main Server on 04.01.2017.
 */
@Service
public class StatisticsService {
    @Autowired
    private StudentDao studentDao;

    public List<Student> selectAllStudents(){
        return studentDao.selectAllStudents();

    }

    public Student selectStudent(int id){
        return studentDao.selectStudent(id);
    }

    public List<Student> selectStudentByState(String state){
        List<Student> students = studentDao.selectAllStudents();
        List<Student> studentsSelected = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getState().equals(state)){
                studentsSelected.add(student);
            }
        }
        return studentsSelected;
    }

    public List<Student> selectStudentByCampus(String campus){
        List<Student> students = studentDao.selectAllStudents();
        List<Student> studentsSelected = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getCampus().equals(campus)){
                studentsSelected.add(student);
            }
        }
        return studentsSelected;
    }
}
