package com.controller;

import com.model.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Main Server on 04.01.2017.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {
    Date dob;
    Date doj;
    int id;
    @Autowired
    private StudentService studentService;
    private List<String> collegeCampuses = Arrays.asList("Hialeah", "Homestead", "InterAmerican", "Kendall", "MDC-West",
            "Medical", "North", "Wolfson");
    private List<String> statesUS = Arrays.asList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
            "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky",
            "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
            "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
            "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia",
            "Washington", "West Virginia", "Wisconsin", "Wyoming");
    private String message;

    @RequestMapping(method = RequestMethod.GET, value = "/createStudent")
    public String createStudent() {
        return "createStudent";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createStudent")
    public String createStudent(@RequestParam(value = "surname") String surname,
                                @RequestParam(value = "name") String name,
                                @RequestParam(value = "dateOfBirth") String dateOfBirth,
                                @RequestParam(value = "state") String state,
                                @RequestParam(value = "campus") String campus,
                                @RequestParam(value = "dateOfJoin") String dateOfJoin,
                                Model model) {

        if (!surname.matches("[A-Z][a-z]+")) {
            message = "Wrong Family Name format! Please write letters only. For example: Johnson";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        if (!name.matches("[A-Z][a-z]+")) {
            message = "Wrong First Name format! Please write letters only. For example: Johnson";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        try {
            dob = Date.valueOf(dateOfBirth);
        } catch (IllegalArgumentException e) {
            message = "Wrong Date format! Please write: yyyy-MM-dd only";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        if (!collegeCampuses.contains(campus)) {
            message = "Wrong Campus Name! Please try again";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        if (!statesUS.contains(state)) {
            message = "Wrong State Name! Please try again";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        try {
            doj = Date.valueOf(dateOfJoin);
        } catch (IllegalArgumentException e) {
            message = "Wrong Date format! Please write: yyyy-MM-dd only";
            model.addAttribute("message", message);
            return "wrongFormat";
        }

        Student student = new Student(surname, name, dob, state, campus, doj);
        studentService.createStudent(student);
        message = "Student was successfully created!";
        model.addAttribute("message", message);
        return "operationSuccessful";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateStudent")
    public String updateStudent() {
        return "updateStudent";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateStudent")
    public String updateStudent(@RequestParam(value = "id") String ids,
                                @RequestParam(value = "surname") String surname,
                                @RequestParam(value = "name") String name,
                                @RequestParam(value = "dateOfBirth") String dateOfBirth,
                                @RequestParam(value = "state") String state,
                                @RequestParam(value = "campus") String campus,
                                @RequestParam(value = "dateOfJoin") String dateOfJoin,
                                Model model) {

        try {
            id = Integer.parseInt(ids);
        } catch (NumberFormatException e) {
            message = "Wrong Mumber format! Please write digits only!";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        if (!surname.matches("[A-Z][a-z]+")) {
            message = "Wrong Family Name format! Please write letters only. For example: Johnson";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        if (!name.matches("[A-Z][a-z]+")) {
            message = "Wrong First Name format! Please write letters only. For example: Johnson";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        try {
            dob = Date.valueOf(dateOfBirth);
        } catch (IllegalArgumentException e) {
            message = "Wrong Date format! Please write: yyyy-MM-dd only";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        if (!collegeCampuses.contains(campus)) {
            message = "Wrong Campus Name! Please try again";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        if (!statesUS.contains(state)) {
            message = "Wrong State Name! Please try again";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        try {
            doj = Date.valueOf(dateOfJoin);
        } catch (IllegalArgumentException e) {
            message = "Wrong Date format! Please write: yyyy-MM-dd only";
            model.addAttribute("message", message);
            return "wrongFormat";
        }

        Student student = new Student(id, surname, name, dob, state, campus, doj);
        if (studentService.updateStudent(student)) {
            message = "Student was successfully updated!";
            model.addAttribute("message", message);
            return "operationSuccessful";
        } else {
            message = "Student with typed id does not exist.Impossible to update student!";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteStudent")
    public String deleteStudent() {
        return "deleteStudent";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteStudent")
    public String deleteStudent(@RequestParam(value = "id") String ids,
                                Model model) {
        try {
            id = Integer.parseInt(ids);
        } catch (NumberFormatException e) {
            message = "Wrong Mumber format! Please write digits only!";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        if (studentService.deleteStudent(id)) {
            message = "Student was successfully deleted!";
            model.addAttribute("message", message);
            return "operationSuccessful";
        } else {
            message = "Student with typed id does not exist.Impossible to delete student!";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
    }

}
