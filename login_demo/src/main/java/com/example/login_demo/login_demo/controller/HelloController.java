package com.example.login_demo.login_demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.login_demo.login_demo.entity.Todo;
import com.example.login_demo.login_demo.entity.TodoDoingResource;
import com.example.login_demo.login_demo.entity.TodoListResponse;
import com.example.login_demo.login_demo.entity.TodoResource;
import com.example.login_demo.login_demo.service.TodoService;

@RestController
public class HelloController {

	@Autowired
	TodoService inputFormService;

	// ホーム
	@RequestMapping(value = "/")
	private String hello() {
		return "Hello world!!";
	}

	// Todo新規登録
	@RequestMapping(value = "/inputform", method = RequestMethod.POST)
	private Todo post(@Validated @RequestBody TodoResource newResource) {
		Todo todo = new Todo();
		todo.setTitle(newResource.getTitle());
		todo.setDescription(newResource.getDescription());
		todo.setStartDate(newResource.getStartDate());
		todo.setLimitDate(newResource.getLimitDate());
		return inputFormService.create(todo);
	}

	// Todo更新
	@RequestMapping(value = "/inputform/{inputFormId}", method = RequestMethod.PUT)
	private Todo put(@PathVariable String inputFormId, @Validated @RequestBody TodoResource updateResource) {
		Todo inputForm = inputFormService.find(inputFormId);
		if (updateResource.getTitle() != null)
			inputForm.setTitle(updateResource.getTitle());
		if (updateResource.getDescription() != null)
			inputForm.setDescription(updateResource.getDescription());
		if (updateResource.getStartDate() != null)
			inputForm.setStartDate(updateResource.getStartDate());
		if (updateResource.getLimitDate() != null)
			inputForm.setLimitDate(updateResource.getLimitDate());
		return inputFormService.update(inputForm);
	}

	// Todo完了更新
	@RequestMapping(value = "/inputform/{inputFormId}/fix", method = RequestMethod.PUT)
	private Todo put(@PathVariable String inputFormId, @Validated @RequestBody TodoDoingResource updateResource) {
		Todo inputForm = inputFormService.find(inputFormId);
		inputForm.setIsFix(updateResource.getIsFix());
		return inputFormService.update(inputForm);
	}

	// Todo一覧取得
	@RequestMapping(value = "/inputform", method = RequestMethod.GET)
	private TodoListResponse getAll() {
		return new TodoListResponse(inputFormService.findAll());
	}

	// Todo単体取得
	@RequestMapping(value = "/inputform/{inputFormId}", method = RequestMethod.GET)
	private Todo get(@PathVariable String inputFormId) {
		Todo inputForm = inputFormService.find(inputFormId);
		return inputForm;
	}
}
