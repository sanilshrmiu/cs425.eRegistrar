package com.miu.cs.cs425.assg.eregistrar.eregistrarapp.controller;

import com.miu.cs.cs425.assg.eregistrar.eregistrarapp.model.Student;
import com.miu.cs.cs425.assg.eregistrar.eregistrarapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/eregistrar/home")
    public String home() {
        return "home";
    }

    @GetMapping
    public String homeRedirect() {
        return "redirect:/eregistrar/home";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "list";
    }

    @GetMapping("/students/new")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "new";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditStudentForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit";
    }

    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        student.setStudentId(id);
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    // Search feature (Extra credit)
    @GetMapping("/students/search")
    public String searchStudents(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("students", studentService.searchStudents(keyword));
        return "list";
    }
}

