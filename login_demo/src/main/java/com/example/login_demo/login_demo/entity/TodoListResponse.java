package com.example.login_demo.login_demo.entity;

import java.util.List;

import lombok.Data;

@Data
public class TodoListResponse {

	int count;
	List<Todo> data;
	
	public TodoListResponse(List<Todo> data) {
		this.data = data;
		count = data.size();
	}
}
