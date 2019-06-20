package cu.cmg.bookstore.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cu.cmg.bookstore.model.Book;
import cu.cmg.bookstore.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = { "/", "/listBooks" })
	public String listBooks(Map<String, Object> map) {

		map.put("book", new Book());
		map.put("bookList", bookService.listBooks());

		return "/book/listBooks";
	}
	
	@RequestMapping("/get/{bookId}")
	public String getBook(@PathVariable Long bookId, Map<String, Object> map){
		
		Book book = bookService.getBook(bookId);
		
		map.put("book", book);
		
		return "/book/bookForm";
		
	}
	/*
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveBook1(@ModelAttribute("book")Book book, BindingResult result){
		bookService.saveBook(book);
		return "redirect:/book/listBooks";
		
	}
	*/
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
     public String saveBook(@ModelAttribute("book") Book book, BindingResult result){
		 bookService.saveBook(book);
		 /*
          * redirects to the path w.r.t the current path
          */
         return "redirect:listBooks";
     }
	
	 @RequestMapping("/delete/{bookId}")
     public String deleteBook(@PathVariable Long bookId) {
		 bookService.deleteBook(bookId);
		 
		 return "redirect:/book/listBooks";
     }

}
