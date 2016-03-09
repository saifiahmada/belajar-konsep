package com.saifiahmada.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Jadwal {
	
	@Id
	private String id;
	
	private String nama;
	
	@OneToMany(mappedBy="jadwal")
	private List<Dosen> dosens;
	
	public Jadwal() {
		// TODO Auto-generated constructor stub
	}

	

	public List<Dosen> getDosens() {
		return dosens;
	}



	public void setDosens(List<Dosen> dosens) {
		this.dosens = dosens;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
	
}
