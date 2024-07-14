package com.hegde.hosalli.TO_DO_FullStack.ToDoModel;

import java.time.LocalDate;
import java.util.Date;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Todo {

	private Long todoId;
	@NotNull
	@NotEmpty
	@Size(max=255)
	private String todoName;
	@NotNull
	@NotEmpty
	@Size(max=255)
	private String todoDescription;
	@Future
	private Date targetDate;
	private Boolean isDone = false;
	public Long getTodoId() {
		return todoId;
	}
	public void setTodoId(Long todoId) {
		this.todoId = todoId;
	}
	public String getTodoName() {
		return todoName;
	}
	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}
	public String getTodoDescription() {
		return todoDescription;
	}
	public void setTodoDescription(String todoDescription) {
		this.todoDescription = todoDescription;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public Boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public Todo(Long todoId, String todoName, String todoDescription, Date targetDate, boolean isDone) {
		super();
		this.todoId = todoId;
		this.todoName = todoName;
		this.todoDescription = todoDescription;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}
	public Todo() {
		super();
	}
	
	
}
