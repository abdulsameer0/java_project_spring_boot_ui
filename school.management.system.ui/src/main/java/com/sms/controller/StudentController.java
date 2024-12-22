package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.sms.entity.Student;
import com.sms.service.StudentService;

@Controller
public class StudentController {
    
     @Autowired
        private StudentService service;
        @GetMapping("/")
        public String viewHomePage(Model model) {
            List<Student> liststudent = service.listAll();
            model.addAttribute("liststudent", liststudent);
            System.out.print("Get / ");    
            return "index";
        }
        @GetMapping("/new")
        public String add(Model model) {
            model.addAttribute("student", new Student());
            return "new";
        }
        @PostMapping("/save")
        public String saveStudent(@ModelAttribute("student") Student std) {
            service.save(std);
            return "redirect:/";
        }
        @RequestMapping("/edit/{id}")
        public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("new");
            Student std = service.get(id);
            mav.addObject("student", std);
            return mav;
            
        }
        @RequestMapping("/delete/{id}")
        public String deletestudent(@PathVariable(name = "id") int id) {
            service.delete(id);
            return "redirect:/";
        }
}