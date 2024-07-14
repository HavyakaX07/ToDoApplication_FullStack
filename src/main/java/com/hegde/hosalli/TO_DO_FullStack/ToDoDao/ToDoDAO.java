package com.hegde.hosalli.TO_DO_FullStack.ToDoDao;

import java.util.List;
import java.util.Map;

import com.hegde.hosalli.TO_DO_FullStack.ToDoModel.Todo;

public interface ToDoDAO {

	public List<Map<String,Object>> getAllToDos(long id);
	
	public int deleteTodo(long id);
	
	public boolean createTodo(Todo obj,Long userId);
	
	public boolean updateTodo(Todo obj);
	
	public Map<String,Object> getTodo(long id);
}
