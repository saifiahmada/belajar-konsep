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
import com.saifiahmada.entity.Child;
import com.saifiahmada.entity.Dosen;
import com.saifiahmada.entity.Jadwal;
import com.saifiahmada.entity.Parent;
import com.saifiahmada.service.BookService;
import com.saifiahmada.service.DosenService;
import com.saifiahmada.service.JadwalService;
import com.saifiahmada.service.ParentService;

@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private DosenService dosenService;
	
	@Autowired
	private JadwalService jadwalService;
	
	@Autowired
	private ParentService parentService;
	
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
		
		Parent parent = new Parent();
		parent.setId(1L);
		Child c1 = new Child();
		c1.setParent(parent);
		c1.setId(1L);
		parent.addToChildren(c1);
		parentService.save(parent);
		
		return "OK";
	}
	
	@RequestMapping("/lihat")
	@ResponseBody
	public String lihat() {
		System.out.println(" jumlah " + parentService.findAll().size()); 
		
		return parentService.findAll().toString();
	}
	
	

}
