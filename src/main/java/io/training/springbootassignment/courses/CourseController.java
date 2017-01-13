package io.training.springbootassignment.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/courses/{id}")
	public Course getCourses(@PathVariable String id){
		return courseService.getCourse(id);
	}

	@RequestMapping("/courses")
	public List<Course> getAllCourses(){
		return courseService.getCourses();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/courses")
	public String addCourse(@RequestBody Course course){
		
		courseService.addCourse(course);
		return "Course Added Successfull";
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}")
	public String removeCourse(@PathVariable String id){
		
		courseService.removeCourse(id);
		return "Course Removed Successfull";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/courses")
	public String updateCourse(@RequestBody Course course){
		return courseService.updateCourse(course);
	}	
	
}
