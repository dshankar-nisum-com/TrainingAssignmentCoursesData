package io.training.springbootassignment.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepo;
	
	public Topic getTopic(String id) {
		return topicRepo.findOne(id);
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public List<Topic> getTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		topicRepo.findAll().forEach(topics::add);
		return topics;
	}

	public void addTopic(Topic topic) {
		topicRepo.save(topic);
		//topics.add(topic);
	}

	public void removeTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepo.delete(id);
	}

	public String updateTopic(Topic topicToBeUpdated) {
			topicRepo.save(topicToBeUpdated);
			return "Topic Updatd Successfully";
	}
}
