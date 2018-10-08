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
		inputForm.setId("idididid");
		Date date = new Date(0);
		inputForm.setPublishedDate(date);
		todoRepository.put(inputForm.getId(), inputForm);
		
		Todo inputForm2 = new Todo();
		inputForm2.setId("idididid2");
		inputForm2.setPublishedDate(date);
		todoRepository.put(inputForm2.getId(), inputForm2);
	}
	
	public Todo create(Todo todo) {
		//UUIDを生成
		String inputFormId = UUID.randomUUID().toString();
		todo.setId(inputFormId);
		//登録したばっかなのでデフォルトでやってない
		todo.setIsFix(false);
		//現在時間をセット
		long systemCurrentTimeMillis = System.currentTimeMillis();
		todo.setPublishedDate(new Date(systemCurrentTimeMillis));
		//セット
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
