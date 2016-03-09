package com.saifiahmada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saifiahmada.entity.Book;
import com.saifiahmada.service.BookService;

@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	
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
	

}
