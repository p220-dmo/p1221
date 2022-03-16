package fr.htc.library.test;

import java.util.List;

import fr.htc.library.dao.DataBase;
import fr.htc.library.data.Book;
import fr.htc.library.main.DataBaseInit;
import fr.htc.library.service.BookService;
import fr.htc.library.service.CheckoutService;
import fr.htc.library.service.MemberService;

public class TestMyLibrary {
	private static MemberService memberService = new MemberService();
	private static BookService bookService = new BookService();
	private static CheckoutService checkoutService = new CheckoutService();

	public static void main(String[] args) {

		DataBaseInit.init();

		// test checkout()
		checkoutService.checkout(null, null);
		checkoutService.checkout("MD100", null);
		checkoutService.checkout(null, "KA85-10");
		checkoutService.checkout("", "KA85-10");
		checkoutService.checkout("MD100", "");
		// Cas nominaaux
		checkoutService.checkout("MD100", "KA85-10");// 1er emprunt : OK
		checkoutService.checkout("MD100", "KA85-10");
		checkoutService.checkout("MD100", "PA95-11");// 2eme emprunt : OK
		checkoutService.checkout("SS101", "PA95-11");
		checkoutService.checkout("MD100", "MO57-12");// 3eme emprunt
		checkoutService.checkout("MD100", "YA8-13");// 4eme emprunt : KO
		checkoutService.checkin("SS101", "YA8-13");
		checkoutService.checkin("SS101", "KA85-10");
		checkoutService.checkout("SS101", "YA8-13");
		checkoutService.checkin("MD100", "KA85-10");
		checkoutService.checkout("MD100", "KA85-10");
		System.out.println("Available books :");
		for (Book book : bookService.findAvailableBooks()) {
			System.out.println(book);
		}
		
		System.out.println("=================================");
		// checkin
		checkoutService.checkin(null, null);
		checkoutService.checkin("MD100", null);
		checkoutService.checkin(null, "KA85-10");
		checkoutService.checkin("", "KA85-10");
		checkoutService.checkin("MD100", "");

		System.out.println("=================================");

		//checkoutService.checkout("MD100", "KA85-10");
	

		bookService.findUnavailableBooks();
	}

}
