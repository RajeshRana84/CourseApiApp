package os.javabrains.start.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import os.javabrains.start.model.Topic;

@Service
public class TopicService {

	
	List<Topic> topics = new  ArrayList<>(Arrays.asList(
			new Topic("11","AngularJS","The frontend Course"),
			new Topic("12","Java8","The Backend Course"),
			new Topic("13","JMS","The Message Broker")

			));
	
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	
	public Topic getTopic(String id){
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get() ;
	}
	
	
	public void addTopic(Topic topic){
		topics.add(topic);
	}


	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));	
	}


	public void updateTopic(Topic topic, String id) {
		
		for(int i =0 ; i<topics.size(); i++){
			
			Topic t = topics.get(i);
			
			if(t.getId().equals(id)){
				topics.set(i, topic);
				break;
			}
		}
	}
}
