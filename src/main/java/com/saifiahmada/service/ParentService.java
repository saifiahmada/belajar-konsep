package com.saifiahmada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saifiahmada.entity.Parent;
import com.saifiahmada.repository.ParentRepository;

@Service
public class ParentService {
	
	
	@Autowired
	private ParentRepository parentRepository;
	
	public void save (Parent parent) {
		parentRepository.save(parent); 
	}

	public List<Parent> findAll() {
		// TODO Auto-generated method stub
		return parentRepository.findAll();
	}

}
