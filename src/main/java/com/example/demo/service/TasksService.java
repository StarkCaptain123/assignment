package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TaskRepository;
import com.example.demo.model.Tasks;

@Service
public class TasksService
{
	@Autowired
	TaskRepository rep;
	
	
	
	public List<Tasks> getAllTasks()
	{
		return rep.findAll();
	}
	
	public Tasks getTaskById(Long id)
	{
		Tasks task=null;
		Optional<Tasks> t=rep.findById(id);
		if(t.equals(null))
		{
			return null;
		}
		else
		{
			task=t.get();
		}
		return task;
	}
	
	
	
	public Tasks addTask(Tasks task)
	{
		return rep.save(task);
	}
	
	
	public Tasks updateTask(Tasks task)
	{
		return rep.save(task);
	}
	
	
	public void deleteTask(Long id)
	{
		rep.deleteById(id);
	}
	
}
