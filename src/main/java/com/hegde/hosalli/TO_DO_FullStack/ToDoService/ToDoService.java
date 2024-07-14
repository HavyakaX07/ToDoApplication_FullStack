package com.hegde.hosalli.TO_DO_FullStack.ToDoService;

import java.util.List;

import com.hegde.hosalli.TO_DO_FullStack.ToDoModel.Todo;

public interface ToDoService {
	
	public List<Todo> getAllTodos(long id);
	
	public Todo getTodo(long userId,long todoId);
	
	public void updateTodo(Todo obj);
	
	public void deleteTodo(long todoId);
	
	public void createTodo(Todo obj);
}
