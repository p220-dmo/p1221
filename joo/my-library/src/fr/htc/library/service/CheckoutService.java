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

	public void checkin() {
		System.out.print("Matricule : ");
		String matricule = ScannerUtils.getInstance().next();
		System.out.print("Cote : ");
		String cote = ScannerUtils.getInstance().next();

		this.checkin(matricule, cote);

	}

	public boolean checkout(String matricule, String cote) {

		// matricule not null : msg

		if (matricule == null || matricule.isBlank()) {
			System.out.println("Matricule musn't be null");
			return false;
		}

		// cote not null : msg

		if (cote == null || cote.isBlank()) {
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

		if (matricule == null || matricule.isBlank()) {
			System.out.println("Matricule musn't be null");
			return false;
		}

		// cote not null : msg

		if (cote == null || cote.isBlank()) {
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

		// voir si le livre dt la cote est passé en paramètre est dans le panier de
		// l'adhérent

		if (member.hasBook(cote)) {
			// System.out.println("le livre est déja dans un panier");
			return true;
		}

		// voir si l'adhérent a déjà ce livre

		if (book.isLoaner(matricule)) {
			// System.out.println("Cet adhérent a dèja ce livre");
			return true;
		}
		System.out.println("le livre peut-être restitué corretement");
		return true;
	}

}