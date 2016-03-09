package com.saifiahmada.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saifiahmada.entity.Dosen;
import com.saifiahmada.repository.DosenRepository;

@Service
public class DosenService {
	
	@Autowired
	private DosenRepository dosenRepository;
	
	public void save(Dosen dosen) {
		dosenRepository.save(dosen);
	}
	
	public List<Dosen> findAll() {
		return dosenRepository.findAll();
	}

}
