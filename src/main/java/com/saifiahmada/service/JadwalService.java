package com.saifiahmada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saifiahmada.entity.Dosen;
import com.saifiahmada.entity.Jadwal;
import com.saifiahmada.repository.JadwalRepository;

@Service
public class JadwalService {
	
	@Autowired
	private JadwalRepository jadwalRepository;
	
	public void save(Jadwal jadwal) {
		jadwalRepository.save(jadwal);
	}

	public List<Jadwal> findAll() {
		// TODO Auto-generated method stub
		return jadwalRepository.findAll(); 
	}

}
