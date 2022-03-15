package fr.htc.library.main;

import fr.htc.library.data.Book;
import fr.htc.library.data.Member;
import fr.htc.library.service.BookService;
import fr.htc.library.service.MemberService;

public class DataBaseInit {
	private static MemberService memberService = new MemberService();
	private static BookService bookService = new BookService();

	public static void init() {

		// Test Member creation
		Member m1 = new Member("Djamel", "MOUCHENE", 30);
		memberService.addMember(m1);
		Member m2 = new Member("Salim", "SEBIH", 30);
		memberService.addMember(m2);
		Member m3 = new Member("Hakim", "HESSENA", 30);
		memberService.addMember(m3);
		Member m4 = new Member("Fatima", "ADDA", 30);
		memberService.addMember(m4);

		// Test Book creation
		Book b1 = new Book("Nedjma", "Kateb yacine", 1985);
		bookService.addBook(b1);
		Book b2 = new Book("Alchimiste", "Paolo COHELO", 1995);
		bookService.addBook(b2);
		Book b3 = new Book("Les chemins qui montent", "Mouloud FERAOUNE", 1957);
		bookService.addBook(b3);
		Book b4 = new Book("Ce que le jour doit à la nuit", "Yasmina KHADRA", 2008);
		bookService.addBook(b4);
	}

}
