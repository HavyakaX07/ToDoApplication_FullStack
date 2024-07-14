package com.hegde.hosalli.TO_DO_FullStack.ToDoDao;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Component;

import com.hegde.hosalli.TO_DO_FullStack.ToDoModel.Todo;

@Component("devH2")
public class TodoDaoH2Impl implements ToDoDAO {

	@Autowired
	private JdbcTemplate jdpcTemplate;
	
	@Override
	public List<Map<String,Object>> getAllToDos(long id) {
		final String sqlQuery = "SELECT TODO_ID, TODO_NAME, TODO_DESC, TODO_END_DATE, TODO_DONE FROM TODOS WHERE USER_ID in (?)";
		Object[] params = {id};	
		int[] types = {Types.BIGINT};
		//Named param wont work with h2 db.
		//MapSqlParameterSource parameters = new MapSqlParameterSource();
		//parameters.addValue("userId", id, Types.BIGINT);
		//NamedParameterJdbcTemplate namedSql = new NamedParameterJdbcTemplate(jdpcTemplate);
		List<Map<String, Object>> response = jdpcTemplate.queryForList(sqlQuery, params,types);
		return response;
	}

	@Override
	public int deleteTodo(long id) {
		final String sql= "DELETE FROM TODOS WHERE TODO_ID = ?";
		Object[] params = {id};	
		int[] types = {Types.BIGINT};
		int result = jdpcTemplate.update(sql, params,types);
		return result;
	}

	@Override
	public boolean createTodo(Todo obj,Long userId) {
		String sql = """
				INSERT INTO todos (todo_name, todo_desc, todo_end_date, todo_done, user_id)
				VALUES (?, ?, ?, ?, ?);
				""";
		Object[] params = {obj.getTodoName(),obj.getTodoDescription(),obj.getTargetDate(),obj.isDone(),userId};	
		int[] types = {Types.VARCHAR,Types.VARCHAR,Types.DATE,Types.BOOLEAN,Types.BIGINT};
		int result = jdpcTemplate.update(sql, params,types);
		return result!=0;
	}

	@Override
	public boolean updateTodo(Todo obj) {
		String sql = """
				UPDATE todos 
					SET 
					todo_name = ?,
					todo_desc = ?,
					todo_end_date = ?,
					todo_done = ?
					WHERE
					todo_id = ?;
				""";
		Object[] params = {obj.getTodoName(),obj.getTodoDescription(),obj.getTargetDate(),obj.isDone(),obj.getTodoId()};	
		int[] types = {Types.VARCHAR,Types.VARCHAR,Types.DATE,Types.BOOLEAN,Types.BIGINT};
		int result = jdpcTemplate.update(sql, params,types);
		return result!=0;
	}

	@Override
	public Map<String, Object> getTodo(long id) {
		String sql = "SELECT * FROM todos WHERE todo_id = ?";
		Object[] params = {id};	
		int[] types = {Types.BIGINT};
		Map<String, Object> todoMap = jdpcTemplate.queryForMap(sql, params,types);
       return  todoMap;
	}

}
