package com.nizar.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nizar.mvc.models.Book;
import com.nizar.mvc.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	// update a book
	// public Book updateBook(Long id, String title, String desc,
	// String lang, Integer numOfPages)
	// {
	// Optional<Book> optionalBook = bookRepository.findById(id);
	// if (optionalBook.isPresent()) {
	// optionalBook.get().setTitle(title);
	// optionalBook.get().setDescription(desc);
	// optionalBook.get().setLanguage(lang);
	// optionalBook.get().setNumberOfPages(numOfPages);
	// return bookRepository.save(optionalBook.get());
	// } else {
	// System.out.println("Book Not Found!");
	// return null;
	// }
	// }

	// update a book
	// updateBook will take in a Book object and save it to our database
	// our repository will automatically update an existing Book object if their IDs
	// match
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	// delete a book
	// to delete a book, we simply pass in the book ID and if our repository finds it, the book will be deleted
		public void deleteBook(Long id) {
			Optional<Book> optionalBook = bookRepository.findById(id);
			if(optionalBook.isPresent()) {
				bookRepository.deleteById(id);
			}
		}
}
