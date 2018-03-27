package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ToDoService {

	@Autowired
	ToDoRepository toDoRepository;
	
	public ToDoService() {
		// TODO Auto-generated constructor stub
	}
	
	// method to create a task
	public ToDoEntity createTask(ToDoEntity task) {
		try {
		return toDoRepository.save(task);
		//return true;
		}
		catch(Exception e) {
		System.out.println("Error while saving" +e.getMessage());
		
		}
		return null;
	}
	
	
	// method to get all tasks
	public List<ToDoEntity> getTasks() {
		Iterator it = toDoRepository.findAll().iterator();
		List<ToDoEntity> toDoList = new ArrayList();
		while(it.hasNext()) {
			toDoList.add((ToDoEntity) it.next());
		}
		return toDoList;
	}
	
	//method to delete a task based on id
	public boolean deleteTask(int id) {
		try {
			toDoRepository.deleteById(id);
			return true;
		}
		catch(Exception e) {
			
		}
		
		return false;
	}
	
	
	// method to update a task
	public boolean updateTask(Integer id, ToDoEntity transferObject) {
		try {
			//ToDoEntity obj = toDoRepository.findById(id);
			//obj.getClass(ToDoEntity);
			//(ToDoEntity)obj.setStatus(transferObject.getStatus()); 
			toDoRepository.saveAndFlush(transferObject);
			return true;
		}
		catch(Exception e) {
			
		}
		return false;
	}

}
