package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ToDoController {

	@Autowired
	ToDoService todoservice;

	public ToDoController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<ToDoEntity>> getToDosList() {

		return new ResponseEntity<>(todoservice.getTasks(), HttpStatus.OK);
	}

	@RequestMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<ToDoEntity> createEntry(@RequestBody ToDoEntity transferObject) {
		ToDoEntity toDo = null;
		toDo = todoservice.createTask(transferObject);

		return new ResponseEntity<>(toDo, HttpStatus.OK);
	}

	// Delete the list entry
	@RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> deleteTask(@PathVariable("id") int id) {
		try {
			todoservice.deleteTask(id);
			// return "Delete Successful";
		} catch (Exception e) {
			return new ResponseEntity<>("Deletion Error", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Task Deleted Successfully", HttpStatus.OK);

	}

	// Update the status
	@RequestMapping(method = RequestMethod.PUT, path = "/todos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> updateTask(@PathVariable("id") int id,
			@RequestBody ToDoEntity transferObject) {
		try {
			todoservice.updateTask(id, transferObject);
		} catch (Exception e) {
			return new ResponseEntity<>("Updation Error", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Task Updated Successfully", HttpStatus.OK);

	}

}
