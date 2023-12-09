package com.nizar.bookclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.nizar.bookclub.models.Author;
import com.nizar.bookclub.models.Book;
import com.nizar.bookclub.models.User;
import com.nizar.bookclub.services.AuthorService;
import com.nizar.bookclub.services.BookService;
import com.nizar.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookService bookServ;

	@Autowired
	private AuthorService authorServ;

	@Autowired
	private UserService userServ;

//	----------- Display Routes ---------------
//	Display all books
	@GetMapping("/books")
	public String books(Model model, @ModelAttribute("book") Book book, HttpSession session) {

		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {
			User user = userServ.findById(userId);
			model.addAttribute("user", user);

			List<Book> all_books = bookServ.allBooks();
			model.addAttribute("books", all_books);

			// GET ALL Authors
//		List<Author> all_authors = authorServ.allAuthors();
//		model.addAttribute("all_authors", all_authors);
			return "Books/home.jsp";
		}

	}

//	Display create book page
	@GetMapping("/books/new")
	public String newBook(Model model, @ModelAttribute("book") Book book, HttpSession session) {

		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {

			List<Author> authors = authorServ.allAuthors();
			model.addAttribute("authors", authors);

		}

		return "Books/newBook.jsp";
	}

//	Display a book details
	@GetMapping("/books/{id}")
	public String oneBook(@PathVariable("id") Long id,
							Model model,
							HttpSession session) {

		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {

			Book oneBook = bookServ.findBook(id);
			model.addAttribute("oneBook", oneBook);
			model.addAttribute("logedUserId", userId);

		}

		return "Books/showBook.jsp";
	}
	
//	Display update a book page
	@GetMapping("/books/edit/{id}")
	public String updateBook(@PathVariable("id") Long id,
							 Model model,
							 @ModelAttribute("book") Book book,
						     HttpSession session) {

		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {
			
			Book thisBook = bookServ.findBook(id);
			model.addAttribute("oneBook", thisBook);
			
			List<Author> authors = authorServ.allAuthors();
			model.addAttribute("authors", authors);

			return "Books/updateBook.jsp";
		}

	}

//	----------- Action Routes ---------------
//	Create Book
	@PostMapping("/books/new")
	public String createAuthor(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {

			if (result.hasErrors()) {
				return "Books/newBook.jsp";
			} else {
				Long UserID = (Long) session.getAttribute("user_id");

				User loggedinUser = userServ.findById(UserID);
				book.setUser(loggedinUser);
				// save the book author in DB
				bookServ.createBook(book);
				return "redirect:/books";
			}
		}
	}
	
//	Update Book
	@PutMapping("/books/edit/{id}")
	public String updateThisBook(@Valid @ModelAttribute("book") Book book,
								 BindingResult result, HttpSession session) {

		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {
			
			if (result.hasErrors()) {
				return "Books/newBook.jsp";
			} else {
			
			User user = userServ.findById(userId);
			book.setUser(user);
			bookServ.updateBook(book);

			return "redirect:/books";
			}
		}

	}
	
//	Delete Book
	@DeleteMapping("/books/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		bookServ.deleteBook(id);
		
		return "redirect:/books";
	}

}
















