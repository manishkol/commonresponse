package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.domain.response.AbstractResponse;
import com.tech.entity.Response;
import com.tech.entity.Topic;
import com.tech.model.CommonResponseModel;
import com.tech.service.TopicService;

@RestController
public class TopicController extends AbstractResponse
{
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic )
	{
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id )
	{
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		topicService.deleteTopic(id);
	}
	
	@RequestMapping("/topics1")
	public ResponseEntity<List<Topic>> getAllTopics1()
	{
		//return new ResponseEntity<List<Topic>> (topicService.getAllTopics(),HttpStatus.NOT_FOUND);
		
		//HttpHeaders responseHeaders = new HttpHeaders();
	    //responseHeaders.set("Baeldung-Example-Header", "Value-ResponseEntityBuilderWithHttpHeaders");
	    //return ResponseEntity.ok().headers(responseHeaders).body(topicService.getAllTopics());
		
	    
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Custom-Example-Header", "Value-ResponseEntityBuilderWithHttpHeaders");
	    return new ResponseEntity<List<Topic>> (topicService.getAllTopics(), responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping("/topics2")
	public ResponseEntity<Response> getAllTopics2()
	{

		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Custom-Example-Header", "Value-ResponseEntityBuilderWithHttpHeaders");
	    return new ResponseEntity<Response> (new Response(true,topicService.getAllTopics()), responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping("/topics3")
	public ResponseEntity<CommonResponseModel<List<Topic>>> getAllTopics3()
	{
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Custom-Example-Header", "Value-ResponseEntityBuilderWithHttpHeaders");
	    return successResponse(topicService.getAllTopics(), responseHeaders);
	}
	
	@GetMapping("/topics3/{id}")
	public ResponseEntity<CommonResponseModel<Topic>> getTopic3(@PathVariable String id)
	{
		return successResponse(topicService.getTopic(id));
	}
} 
