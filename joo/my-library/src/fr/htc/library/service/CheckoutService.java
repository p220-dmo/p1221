package fr.htc.library.service;

import fr.htc.library.dao.BookDao;
import fr.htc.library.dao.MemberDao;
import fr.htc.library.data.Book;
import fr.htc.library.data.Member;
import fr.htc.library.utils.ScannerUtils;

public class CheckoutService {
	MemberDao memberDao = new MemberDao();
	BookDao bookDao = new BookDao();

	public void checkout() {
		System.out.print("Matricule : ");
		String matricule = ScannerUtils.getInstance().next();
		System.out.print("Cote : ");
		String cote = ScannerUtils.getInstance().next();

		this.checkout(matricule, cote);

	}

	public boolean checkout(String matricule, String cote) {
		// matricule not null : msg
		if (matricule == null || matricule.trim().isEmpty()) {
			System.out.println("Matricule musn't be null");
			return false;
		}

		// cote not null : msg

		if (cote == null || cote.trim().isEmpty()) {
			System.out.println("cote musn't be null");
			return false;
		}

		// cote match Book : msg

		Book book = bookDao.selectBookByCote(cote);
		if (book == null) {
			System.out.println("book doesn't exists");
			return false;
		}

		// matricule match Member msg
		Member member = memberDao.selectMemberByMatricule(matricule);
		if (member == null) {
			System.out.println("Member doesn't exists");
			return false;
		}

		// Member can checkout yet : msg
		if (member.canCheckout() == false) {
			System.out.println("Max book atempts");
			return false;
		}

		// Book available : msg
		if (book.isAvailable() == false) {
			System.out.println("book douesn'available");
			return false;

		}

		// make relation : Checkout
		member.addBook(book);
		book.setLoaner(member);
		System.out.println("checkout succesfully .. ");

		return true;

	}

	public boolean checkin(String matricule, String cote) {
		// matricule not null : msg
		if (matricule == null || matricule.trim().isEmpty()) {
			System.out.println("Matricule musn't be null");
			return false;
		}

		// cote not null : msg

		if (cote == null || cote.trim().isEmpty()) {
			System.out.println("cote musn't be null");
			return false;
		}

		// cote match Book : msg

		Book book = bookDao.selectBookByCote(cote);
		if (book == null) {
			System.out.println("book doesn't exists");
			return false;
		}

		// matricule match Member msg
		Member member = memberDao.selectMemberByMatricule(matricule);
		if (member == null) {
			System.out.println("Member doesn't exists");
			return false;
		}

		// Member is Loaner
		if (book.isLoaner(matricule) == false) {
			System.out.println("Member is not Loaner...");
			return false;
		}
		// Book is checked out by Member
		if (member.hasBook(cote) == false) {
			System.out.println("Book is not yours...");
			return false;
		}
		member.deleteBook(book);
		book.setLoaner(null);
		System.out.println("Checkin successfully...");
		return true;

	}

	public void checkin() {
		System.out.print("Matricule : ");
		String matricule = ScannerUtils.getInstance().next();
		System.out.print("Cote : ");
		String cote = ScannerUtils.getInstance().next();

		this.checkout(matricule, cote);
	}

}
