package com.controller;

import com.model.Student;
import com.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Main Server on 04.01.2017.
 */
@Controller
@RequestMapping(value = "/statistics")
public class StatisticsController {
    @Autowired
    public StatisticsService statisticsService;
    int id;
    String message;
    Student student;
    List<Student> studentsSelected;
    private List<String> collegeCampuses = Arrays.asList("Hialeah", "Homestead", "InterAmerican", "Kendall", "MDC-West",
            "Medical", "North", "Wolfson");
    private List<String> statesUS = Arrays.asList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
            "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky",
            "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
            "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
            "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia",
            "Washington", "West Virginia", "Wisconsin", "Wyoming");

    @RequestMapping(method = RequestMethod.GET, value = "/selectAllStudents")
    public String selectAllStudents(Model model) {
        model.addAttribute("studentList", statisticsService.selectAllStudents());
        return "findAllStudents";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectStudentByID")
    public String selectStudentById() {
        return "queryId";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/selectStudentByID")
    public String selectStudentById(@RequestParam(value = "id") String ids,
                                    Model model) {
        try {
            id = Integer.parseInt(ids);
        } catch (NumberFormatException e) {
            message = "Wrong Mumber format! Please write digits only!";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        student = statisticsService.selectStudent(id);
        if (student == null) {
            message = "Student with typed id does not exists. Impossible to find student!";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        model.addAttribute("student", student);
        return "findStudentByID";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectStudentsByState")
    public String selectStudentsByState() {
        return "queryState";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/selectStudentsByState")
    public String selectStudentsByState(@RequestParam(value = "state") String state,
                                        Model model) {
        if (!statesUS.contains(state)) {
            message = "Wrong State Name! Please try again";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        studentsSelected = statisticsService.selectStudentByState(state);
        model.addAttribute("studentList", studentsSelected);
        return "findStudentsByState";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectStudentsByCampus")
    public String selectStudentsByCampus() {
        return "queryCampus";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/selectStudentsByCampus")
    public String selectStudentsByCampus(@RequestParam(value = "campus") String campus,
                                         Model model) {
        if (!collegeCampuses.contains(campus)) {
            message = "Wrong Campus Name! Please try again";
            model.addAttribute("message", message);
            return "wrongFormat";
        }
        studentsSelected = statisticsService.selectStudentByCampus(campus);
        model.addAttribute("studentList", studentsSelected);
        return "FindStudentsByCampus";
    }

}
