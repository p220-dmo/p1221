package fr.htc.library;

import java.util.HashMap;
import java.util.Map;

import fr.htc.library.data.Book;
import fr.htc.library.data.Member;

public class DataBaseInit {
	static Map<String, Member> memberMap = new HashMap<String, Member>();
	static Map<String, Book> bookMap = new HashMap<String, Book>();

	public static void init(String[] args) {
		
		//Test Member creation 
		Member m2 = new Member(null, "MOUCHENE", 30);
		Member m1 = new Member("Djamel", "", 30);
		Member m3 = new Member("", "", 30);
		Member m4 = new Member("Fatma", "MAOUCHE-**", 30);
		Member m5 = new Member("tot", "tata", 89);
	
		
		
		memberMap.put(m1.getMatricule(), m1);
		memberMap.put(m2.getMatricule(), m2);
		memberMap.put(m3.getMatricule(), m3);
		memberMap.put(m4.getMatricule(), m4);
		memberMap.put(m5.getMatricule(), m5);
		
		System.out.println("\n You have : " + memberMap.size() + " member(s) \n");
		
		// afficher tout ls élement de la map member
		for (String key : memberMap.keySet()) {
			System.out.println(memberMap.get(key));
		}
		
		//Test Book creation 
		Book b1 = new Book("Nedjma", "Kateb yacine", 1985);
		Book b2 = new Book("Alchimiste", "Paolo COHELO", 1995);
		Book b3 = new Book("Les chemins qui montent", "Mouloud FERAOUNE", 1957);
		
		
		//stocker les livres dans la Map
		bookMap.put(b1.getCote(), b1);
		bookMap.put(b2.getCote(), b2);
		bookMap.put(b3.getCote(), b3);
		
		System.out.println("\n You have : " + bookMap.size() + " book(s) \n");
		
		// afficher les éléments de la mapBook
		for (String key : bookMap.keySet()) {
			System.out.println(bookMap.get(key));
		}
		
		
}
}
