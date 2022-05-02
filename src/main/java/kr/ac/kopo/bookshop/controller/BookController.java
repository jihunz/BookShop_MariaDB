package kr.ac.kopo.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	final String PATH = "book/";
	
	@Autowired
	BookService service;
	
	@GetMapping("/dummy")
	public String dummy() {
		service.dummy();
		
		return "redirect:list";
	}
	
	@GetMapping("/init")
	public String init() {
		service.init();
		
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Book> list = service.list();
		
		model.addAttribute("list", list);
		
		return PATH + "list";		
	}
	
	@GetMapping("/add")
	public String add() {
		return PATH + "add";
	}
	
	@PostMapping("/add")
	public String add(Book item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{bookId}")
	public String update(@PathVariable int bookId, Model model) {
		Book item = service.item(bookId);
		
		model.addAttribute("item", item);
		
		return PATH + "update";
	}
	
	@PostMapping("/update/{bookId}")
	public String update(@PathVariable int bookId, Book item) {
		item.setBookId(bookId);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{bookId}")
	public String delete(@PathVariable int bookId) {
		service.delete(bookId);
		
		return "redirect:../list";
	}
}
