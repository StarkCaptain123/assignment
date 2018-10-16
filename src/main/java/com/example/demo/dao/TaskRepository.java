package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks,Long>
{

}
