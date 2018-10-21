package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.ui.Model;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import java.util.List;

import demo.model.Student;
import demo.service.IStudentService;

@Controller
public class StudentController {

	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	IStudentService studentService;

	@RequestMapping("/students")
	public String findAllStudents(Model model) {

		List<Student> students = (List<Student>) studentService.findAll();

			log.info("@StudentController Students found with findAll():");
			log.info("-------------------------------");
			for (Student student : students) {
				log.info(student.toString());
			}
			log.info("");

		model.addAttribute("students", students);

		return "listStudents";
	}



}
