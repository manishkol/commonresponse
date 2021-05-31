package com.tech.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.entity.Topic;

@Service
public class TopicService 
{
	private List<Topic> topics= Arrays.asList(
			new Topic("Spring", "Spring Framework", "Spring Description"),
			new Topic("Java", "Core Java", "Java Description"),
			new Topic("Java Script", "Java Script", "Java Script Description")
		);
	
	public List<Topic> getAllTopics()
	{
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		return topics.stream()
				.filter(t-> t.getId().equalsIgnoreCase(id))
				.findFirst().get();

	}
	public void addTopic(Topic topic)
	{
		topics.add(topic);
	} 
	
	public void updateTopic(Topic topic, String id)
	{	
		for(int i=0; i<topics.size(); i++)
		{
			Topic t = topics.get(i);
			if( t.getId().equalsIgnoreCase(id) )
			{
				topics.set(i, topic);
				return;
			}
			
		}
	} 
	public void deleteTopic(String id)
	{
		topics.removeIf(t-> t.getId().equalsIgnoreCase(id));  
	}
}
