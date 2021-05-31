package com.tech.entity;

import java.util.List;

import com.tech.service.TopicService;

public class Response {
	
	private Boolean confirmed;

    private List<Topic> data;
    
    
	public Response(Boolean confirmed, List<Topic> data) {
		super();
		this.confirmed = confirmed;
		this.data = data;
	}


	public Boolean getConfirmed() {
		return confirmed;
	}


	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}


	public List<Topic> getData() {
		return data;
	}


	public void setData(List<Topic> data) {
		this.data = data;
	}
}
