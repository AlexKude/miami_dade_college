package com.controller;

import com.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Main Server on 04.01.2017.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    @RequestMapping(method = RequestMethod.GET, value = "/allStudents")
    public String getAllUsers(Model model){
        model.addAttribute("studentList", studentDao.selectAllElements());
        return "student";
    }

}
