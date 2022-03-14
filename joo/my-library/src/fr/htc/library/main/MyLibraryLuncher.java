package fr.htc.library.main;

import fr.htc.library.data.Book;
import fr.htc.library.data.Member;

public class MyLibraryLuncher {

	public static void main(String[] args) {
		
		//Test Member creation 
		Member m1 = new Member("Djamel", "", 30);
		System.out.println(m1);
		Member m2 = new Member(null, "MOUCHENE", 30);
		System.out.println(m2);
		Member m3 = new Member("", "", 30);
		System.out.println(m3);
		Member m4 = new Member("Fatima", "ADDA", 30);
		System.out.println(m4);
		
		
		//Test Book creation 
		Book b1 = new Book("Nedjma", "Kateb yacine", 1985);
		System.out.println(b1);
		Book b2 = new Book("Alchimiste", "Paolo COHELO", 1995);
		System.out.println(b2);
		Book b3 = new Book("Les chemins qui montent", "Mouloud FERAOUNE", 1957);
		System.out.println(b3);
	}
	
}
