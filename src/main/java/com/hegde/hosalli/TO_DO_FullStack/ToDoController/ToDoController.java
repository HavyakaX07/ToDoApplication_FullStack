package com.hegde.hosalli.TO_DO_FullStack.ToDoController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hegde.hosalli.TO_DO_FullStack.ToDoExceptions.TodoIlligalArgumentException;
import com.hegde.hosalli.TO_DO_FullStack.ToDoModel.TODOEums;
import com.hegde.hosalli.TO_DO_FullStack.ToDoModel.Todo;
import com.hegde.hosalli.TO_DO_FullStack.ToDoService.ToDoService;

import jakarta.validation.Valid;


@RestController
public class ToDoController {
	
	@Autowired
	private ToDoService todoService;

	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@GetMapping("users/{userId}/todos")
	public List<Todo> getAllTodos(@PathVariable("userId") Long userId) throws TodoIlligalArgumentException{
		if(userId==null)
			throw new TodoIlligalArgumentException("Bad Argument exception.Please send valid argument");
		List<Todo> todosList = todoService.getAllTodos(userId);
		
		return todosList;
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@GetMapping("users/{userId}/todos/{todoId}")
	public Todo getTodo(@PathVariable("userId") Long userId,@PathVariable("todoId") Long todoId) throws TodoIlligalArgumentException{
		if(todoId==null || userId==null)
			throw new TodoIlligalArgumentException("Bad Argument exception.Please send valid argument");
		Todo todo = todoService.getTodo(userId,todoId);
		return todo;
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@RequestMapping(value = "addTodos", method = RequestMethod.POST)
	public TODOEums createTodos(@RequestBody @Valid Todo todo,BindingResult result) {
		
		//Add Validation result handling 
		if(result.hasErrors())
			return TODOEums.ERROR_IN_CREATE;

		todoService.createTodo(todo);
		return TODOEums.CREATED;
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@RequestMapping(value = "updateTodos", method = RequestMethod.POST)
	public TODOEums updateTodos(@RequestBody @Valid Todo todo,BindingResult result) {
		
		//Add Validation result handling 
		if(result.hasErrors())
			return TODOEums.ERROR_IN_UPDATE;

		todoService.updateTodo(todo);
		return TODOEums.UPDATED;
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@RequestMapping(value = "deleteTodos/{todoId}", method = RequestMethod.DELETE)
	public TODOEums deleteTodos(@PathVariable("todoId") Long todoId) throws TodoIlligalArgumentException {
		
		if(todoId==null)
			throw new TodoIlligalArgumentException("Bad Argument exception.Please send valid argument");
		
		//Add Validation result handling 
		todoService.deleteTodo(todoId);
		
		return TODOEums.DELETED;
	}
	
	
	
}
