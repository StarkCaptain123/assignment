package com.example.demo.model;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="Tasks")
public class Tasks
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@DateTimeFormat(iso=ISO.DATE)
	
	private LocalDate date;

	private String name;
	
	@DateTimeFormat(iso=ISO.NONE)
	
	private LocalDate execDate;
	
	@DateTimeFormat(iso=ISO.TIME)

	private LocalTime exectime;
	
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	
	private String task;

	

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public LocalDate getExecDate()
	{
		return execDate;
	}

	public void setExecDate(LocalDate execDate)
	{
		this.execDate = execDate;
	}

	public LocalTime getExectime()
	{
		return exectime;
	}

	public void setExectime(LocalTime exectime)
	{
		this.exectime = exectime;
	}

	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	public String getTask()
	{
		return task;
	}

	public void setTask(String task)
	{
		this.task = task;
	}
}
