package fr.htc.library.dao;

import java.util.Map;

import fr.htc.library.dao.db.DataBase;
import fr.htc.library.data.Book;

public class BookDao {

	// C
	public Book save(Book book) {
		Map<String, Book> map = DataBase.getBookTable();
		map.put(book.getCote(), book);
		Book savedBook = map.get(book.getCote());

		System.out.println("Book saved succesfully... : " + savedBook.getCote());
		return savedBook;
	}

	// R
	public Book selectBookByCote(String cote) {
		Book findBook = DataBase.getBookTable().get(cote);
		return findBook;

	}
}
