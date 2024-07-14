package com.hegde.hosalli.TO_DO_FullStack.ToDoService;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.hegde.hosalli.TO_DO_FullStack.ToDoDao.ToDoDAO;
import com.hegde.hosalli.TO_DO_FullStack.ToDoModel.Todo;

@Component
public class TodoServiceImpl implements ToDoService {

	private Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);
	
	@Autowired
	@Qualifier("devH2")
	private ToDoDAO todoDao;

	@Override
	public List<Todo> getAllTodos(long id) {
		ArrayList<Todo> listTodos = new ArrayList<Todo>();
		try {
			List<Map<String, Object>> dbData = todoDao.getAllToDos(id);
			processDBData(listTodos, dbData);
		} catch (Exception exception) {
			logger.error("Exception while fetching data ", exception);
		}
		return listTodos;
	}

	@Override
	public Todo getTodo(long userId, long todoId) {
		Map<String,Object> obj = null;
		try {
			obj = todoDao.getTodo(todoId);
		}
		catch(EmptyResultDataAccessException ex) {
			logger.error("No result found for todoId {}",todoId);
		}
		catch(Exception exception) {
			logger.error("Exception while fetching data ", exception);
		}
		return mapToTodo(obj);
	}

	@Override
	public void updateTodo(Todo obj) {
		try {
			todoDao.updateTodo(obj);
		}
		catch(Exception exception) {
			logger.error("Exception while updating the todo ",exception);
		}

	}

	@Override
	public void deleteTodo(long todoId) {
		try {
			todoDao.deleteTodo(todoId);
		}
		catch(Exception exception) {
			logger.error("Exception while updating the todo ",exception);
		}

	}

	@Override
	public void createTodo(Todo obj) {
		try {
			//Get it from context
			Long userId = 1L;
			todoDao.createTodo(obj,userId );
		}
		catch(Exception exception) {
			logger.error("Exception while updating the todo ",exception);
		}

	}

	private void processDBData(ArrayList<Todo> retunList, List<Map<String, Object>> dbData) {
		for(Map<String,Object> obj : dbData) {
			Todo todo = mapToTodo(obj);
			retunList.add(todo);
		}
	}

	private Todo mapToTodo(Map<String, Object> todoMap) {
	        Todo todo = new Todo();
	        todo.setTodoId((Long) todoMap.get("todo_id"));
	        todo.setTodoName((String) todoMap.get("todo_name"));
	        todo.setTodoDescription((String) todoMap.get("todo_desc"));
	        Date date = (Date) todoMap.get("todo_end_date");
//	        LocalDate localdate = null;
//	        if(date!=null)
//	        	 localdate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        todo.setTargetDate(date);
	        todo.setDone((Boolean) todoMap.get("todo_done"));
	        return todo;
	    }

}
