package com.acme.todolist.application.service;



import javax.inject.Inject;
import org.springframework.stereotype.Component;

import com.acme.todolist.application.port.in.AddTodoItem;
import com.acme.todolist.application.port.out.UpdateTodoItem;

import com.acme.todolist.domain.TodoItem;

@Component
public class CreateTodoItemService implements AddTodoItem{
	
	private UpdateTodoItem updateTodoItem;
	
	@Inject
	public CreateTodoItemService(UpdateTodoItem item) {
		this.updateTodoItem = item;
	}
	
	@Override
	public void AddTodoItem(TodoItem item) {
		this.updateTodoItem.storeNewTodoItem(item);
	}

}
