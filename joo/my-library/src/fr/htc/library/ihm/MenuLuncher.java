package fr.htc.library.ihm;

import fr.htc.library.data.Book;
import fr.htc.library.data.Member;
import fr.htc.library.main.DataBaseInit;
import fr.htc.library.service.BookService;
import fr.htc.library.service.CheckinService;
import fr.htc.library.service.CheckoutService;
import fr.htc.library.service.MemberService;
import fr.htc.library.utils.ScannerUtils;

public class MenuLuncher {
	private static final int ADD_MEMBER = 1;
	private static final int ADD_BOOK = 2;
	private static final int CHECK_OUT = 3;
	private static final int CHECK_IN = 4;
	private static final int FIND_MEMBER = 5;
	private static final int FIND_BOOK = 6;
	private static final int EXIT = 0;

	private static MemberService memberService = new MemberService();
	private static BookService bookService = new BookService();
	private static CheckoutService checkoutService = new CheckoutService();
	private static CheckinService checkinService = new CheckinService();

	public static void main(String[] args) {
		// Initialiser la base de données : Map
		DataBaseInit.init();
		int choice = -1;
		do {
			choice = displayMenuAndCatchUserChoice();
			switchToOption(choice);

		} while (choice != 0);

	}

	private static int displayMenuAndCatchUserChoice() {

		System.out.println("------ Welcome to MyLibrary ------");
		System.out.println("\t - 1=> Add Member.");
		System.out.println("\t - 2=> Add Book.");
		System.out.println("\t - 3=> Checkout.");
		System.out.println("\t - 4=> Checkin.");
		System.out.println("\t - 5=> Find Member.");
		System.out.println("\t - 6=> Find Book.");
		System.out.println("\t - 0=> Exit.");
		System.out.print("\t\t\t\t\t\t - Choice : ");
		int input = ScannerUtils.getInstance().nextInt();

		return input;
	}

	private static void switchToOption(int choice) {
		switch (choice) {
		case ADD_MEMBER:
			System.out.println("ADD_MEMBER");
			memberService.addMember();
			break;
		case ADD_BOOK:
			System.out.println("ADD_BOOK");
			bookService.addBook();
			break;
		case CHECK_OUT:
			System.out.println("CHECK_OUT");
			checkoutService.checkout();
			break;
		case CHECK_IN:
			System.out.println("CHECK_IN");
			checkinService.checkin();
			break;
		case FIND_MEMBER:
			System.out.println("FIND_MEMBER");
			System.out.print("Enter matricule : ");
			Member findMember = memberService.getMemberByMatricule(ScannerUtils.getInstance().next());
			System.out.println(findMember);
			break;
		case FIND_BOOK:
			System.out.println("FIND_BOOK");
			System.out.print("Enter Cote : ");
			Book findBook = bookService.getBookByCote(ScannerUtils.getInstance().next());
			System.out.println(findBook);
			break;
		case EXIT:
			System.out.println("EXIT");
			break;
		default:

			System.out.println("BAD INPUT");
			break;
		}

	}
}
