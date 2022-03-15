package fr.htc.library.service;

import fr.htc.library.dao.BookDao;
import fr.htc.library.data.Book;
import fr.htc.library.utils.ScannerUtils;

public class BookService {
	BookDao bookDao = new BookDao();

	public Book addBook() {
		System.out.println("Add Book  : Title;Author;year");
		String input = ScannerUtils.getInstance().next();
		String[] values = input.split(";");

		String title = values[0];
		String author = values[1];
		int year = Integer.parseInt(values[2]);
		return this.addBook(title, author, year);
	}

	private Book addBook(String title, String author, int year) {
		Book book = new Book(title, author, year);
		return this.addBook(book);
	}

	public Book addBook(Book book) {
		return bookDao.save(book);

	}

	public Book getBookByCote(String cote) {
		if (cote == null || cote.isBlank()) {
			return null;
		}
		return bookDao.selectBookByCote(cote);
	}

}
