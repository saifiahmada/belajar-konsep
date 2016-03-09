package com.saifiahmada;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saifiahmada.entity.Book;
import com.saifiahmada.entity.Dosen;
import com.saifiahmada.entity.Jadwal;
import com.saifiahmada.service.BookService;
import com.saifiahmada.service.DosenService;
import com.saifiahmada.service.JadwalService;

@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private DosenService dosenService;
	
	@Autowired
	private JadwalService jadwalService;
	
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "testing";
	}
	
	@RequestMapping("/tes")
	@ResponseBody
	public String home2() {
		return "testing testing";
	}
	
	@RequestMapping("/save/{data}")
	@ResponseBody
	public String save(@PathVariable("data") String data){
		
		Book b = new Book();
		b.setId("Id Ke-" + data);
		b.setJudul("Judul Ke-"+ data); 
		b.setPenerbit("Penerbit Ke-" + data); 
		bookService.save(b);
		
		return "Transaksi berhasil disimpan [ " + b.getId() + " ]";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<Book> list(){
		return bookService.findAll();
	}
	
	//@RequestMapping("/error")
	public String error() {
		return "error";
	}
	
	@RequestMapping("/dosen/{data}")
	@ResponseBody
	public String saveDosen(@PathVariable("data")String data){
		Dosen dosen = new Dosen();
		dosen.setId("ID"+data);
		dosen.setNama("NAMA"+data);
		dosenService.save(dosen); 
		return "sukses simpan data " + dosen.getId();
	}
	
	@RequestMapping("/dosens")
	@ResponseBody
	public List<Dosen> getDosens(){
		return dosenService.findAll();
	}
	
	@RequestMapping("/jadwal/{data}")
	@ResponseBody
	public String jadwal(@PathVariable("data")String data){
		Jadwal jadwal = new Jadwal();
		jadwal.setId("ID"+data);
		jadwal.setNama("NAMA"+data);
		jadwalService.save(jadwal); 
		return "sukses simpan data " + jadwal.getId();
	}
	
	@RequestMapping("/jadwals")
	@ResponseBody
	public List<Jadwal> getJadwals(){
		return jadwalService.findAll();
	}
	
	@RequestMapping("/simpan")
	@ResponseBody
	public String saveAll(){
		List<Dosen> dosens = new ArrayList<Dosen>();
		Dosen d1 = new Dosen();
		d1.setId("D1");
		d1.setNama("NAMA D1");
		dosens.add(d1);
		Dosen d2 = new Dosen();
		d2.setId("D2");
		d2.setNama("NAMA D2");
		dosens.add(d2);
		
		Jadwal jadwal = new Jadwal();
		jadwal.setId("ID1");
		jadwal.setNama("NAMA JADWAL 1");
		jadwal.setDosens(dosens); 
		
		jadwalService.save(jadwal); 
		
		return "OK";
	}
	
	

}
