package com.in28minutes.todo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.todo.Todo;
import com.in28minutes.todo.TodoService;

@RestController
public class ToDoRestController {
	@Autowired
	TodoService service;
		
	
	@RequestMapping(path="/todos")
	public List<Todo> retrieveAllTodos(){
		return service.retrieveTodos("in28Minutes");
		
	}
	
}
