package io.training.springbootassignment.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	public Course getCourse(String id) {
		return courseRepo.findOne(id);
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public List<Course> getCourses() {
		List<Course> courses = new ArrayList<Course>();
		courseRepo.findAll().forEach(courses::add);
		return courses;
	}

	public void addCourse(Course course) {
		courseRepo.save(course);
		//topics.add(course);
	}

	public void removeCourse(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		courseRepo.delete(id);
	}

	public String updateCourse(Course courseToBeUpdated) {
			courseRepo.save(courseToBeUpdated);
			return "Course Updatd Successfully";
	}
}
