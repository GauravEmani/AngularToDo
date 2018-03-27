package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ToDo")
public class ToDoEntity {

	public ToDoEntity() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue( strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;

	//@JsonIgnore
	@Column(name= "title", unique=true, nullable=false)
	private String title;

	@Column(name = "status")
	private Boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	

}
