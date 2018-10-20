package com.example.login_demo.login_demo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.login_demo.login_demo.entity.Todo;

@Service
public class TodoService {
	
	private final Map<String, Todo> todoRepository = new ConcurrentHashMap<>();
	
	@PostConstruct
	public void loadDummyData() {
		Todo inputForm = new Todo();
		inputForm.setId(UUID.randomUUID().toString());
		Long date = System.currentTimeMillis();
		Long limitDate = date + (60 * 60 * 24 * 10 * 1000);
		inputForm.setTitle("サンプルタイトル01");
		inputForm.setDescription("サンプル説明01");
		inputForm.setPublishedDate(date);
		inputForm.setLimitDate(limitDate);
		inputForm.setStartDate(date);
		inputForm.setIsFix(false);

		todoRepository.put(inputForm.getId(), inputForm);
		
		Todo inputForm2 = new Todo();
		inputForm2.setId(UUID.randomUUID().toString());
		inputForm2.setTitle("サンプルタイトル02");
		inputForm2.setDescription("サンプル説明02");
		inputForm2.setPublishedDate(date);
		inputForm2.setStartDate(date);
		inputForm2.setLimitDate(limitDate);
		inputForm2.setIsFix(false);
		todoRepository.put(inputForm2.getId(), inputForm2);
	}
	
	public Todo create(Todo todo) {
		//UUIDを生成
		String inputFormId = UUID.randomUUID().toString();
		todo.setId(inputFormId);
		//
		todo.setIsFix(false);
		//
		long systemCurrentTimeMillis = System.currentTimeMillis();
		todo.setPublishedDate(systemCurrentTimeMillis);
		//
		todoRepository.put(todo.getId(), todo);
		return todo;
	}
	
	public Todo update(Todo inputForm) {
		return todoRepository.put(inputForm.getId(), inputForm);
	}
	
	public List<Todo> findAll() {
		List<Todo> list = new ArrayList<>(todoRepository.values());
		return list;
	}
	
	public Todo find(String bookId) {
		Todo inputForm = todoRepository.get(bookId);
		return inputForm;
	}
}
