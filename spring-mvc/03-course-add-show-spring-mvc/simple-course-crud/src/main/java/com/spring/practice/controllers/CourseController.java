package com.spring.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.practice.model.Course;
import com.spring.practice.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value="/course/add",method = RequestMethod.GET)	
	public String addCountry_GET(Model model) {
		model.addAttribute("course", new Course());
		model.addAttribute("message", "Please add a course");
		return "course/add";
	}
	@PostMapping("/course/add")
	public String addCourse(Model model, @ModelAttribute(name = "course") Course course) {
		courseService.addCourse(course);
		model.addAttribute("message", "Course added successfully");
		return "redirect:/course/show-all";
	}
	@RequestMapping(value="/course/show-all",method = RequestMethod.GET)	
	public String showAll_GET(Model model) {
		model.addAttribute("courses", courseService.getAll());
		model.addAttribute("message", "Showing all courses");
		return "course/show-all";
	}

}
