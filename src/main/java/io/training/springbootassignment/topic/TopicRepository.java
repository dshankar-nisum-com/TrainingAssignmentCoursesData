package io.training.springbootassignment.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>{
	public List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("basicjava", "Basic Java", "Basic Java Course"),
					new Topic("advjava", "Advanced Java", "Advanced Java Course")));


}
