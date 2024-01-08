package com.springbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbook.model.Book;
import com.springbook.service.BookService;

@Controller
public class BookController {
	
    @Autowired
    private BookService bookService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("allbooklist", bookService.getAllBook());
		return "index";
	}

	@GetMapping("/addnew")
	public String addNewBook(Model model) {
		Book book = new Book();
		model.addAttribute("Book", book);
		return "newbook";
	}

	@PostMapping("/save")
	public String saveBook(@ModelAttribute("Book") Book book) {
		bookService.save(book);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String updateForm(@PathVariable(value = "id") int id, Model model) {
		Book book = bookService.getById(id);
		model.addAttribute("Book", book);
		return "update";
	}

	@GetMapping("/deleteBook/{id}")
	public String deleteThroughId(@PathVariable(value = "id") int id) {
		bookService.deleteViaId(id);
		return "redirect:/";
	}
}
