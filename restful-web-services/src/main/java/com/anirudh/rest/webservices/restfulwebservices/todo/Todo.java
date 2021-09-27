package com.anirudh.rest.webservices.restfulwebservices.todo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private String description;
	private Date targetDate;
	private boolean isDone;

	
	public Todo() {
		
	}
	public Todo(Long id, String name, String description, Date date, boolean isDone) {
		this.username = name;
		this.description = description;
		this.id = id;
		this.targetDate = date;
		this.isDone = isDone;
	}

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return username;
	}

	public String getDescription() {
		return description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public void setDiscription(String description) {
		this.description = description;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	

}
