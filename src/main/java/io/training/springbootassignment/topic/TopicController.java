package io.training.springbootassignment.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id){
		return topicService.getTopic(id);
	}

	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getTopics();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public String addTopic(@RequestBody Topic topic){
		
		topicService.addTopic(topic);
		return "Topic Added Successfull";
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public String removeTopic(@PathVariable String id){
		
		topicService.removeTopic(id);
		return "Topic Removed Successfull";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics")
	public String updateTopic(@RequestBody Topic topic){
		return topicService.updateTopic(topic);
	}	
	
}
