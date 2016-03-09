package com.saifiahmada.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Dosen {
	
	@Id
	private String id;
	
	private String nama;
	
	@ManyToOne
	@Cascade(value={CascadeType.ALL})
	@JoinColumn(name="jadwal_id")
	private Jadwal jadwal;
	
	public Dosen() {
		// TODO Auto-generated constructor stub
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
