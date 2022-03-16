package fr.htc.library.dao;

import java.util.HashMap;
import java.util.Map;

import fr.htc.library.data.Book;
import fr.htc.library.data.Member;

public class DataBase {

	private static Map<String, Member> memberTable = new HashMap<String, Member>();
	private static Map<String, Book> bookTable = new HashMap<String, Book>();

	static Map<String, Member> getMemberTable() {
		return memberTable;
	}

	static Map<String, Book> getBookTable() {
		return bookTable;
	}

}
