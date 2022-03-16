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
		if (matricule == null || matricule.isBlank()) {

			System.out.println("matricule must is ne null");

			return false;
		}
		// matricule match Member msg
		Member member = memberDao.selectMemberByMatricule(matricule);
		if (member == null) {
			System.out.println("member doset exist");
			return false;
		}

		// cote not null : msg
		if (cote == null || cote.isBlank()) {

			System.out.println("matricule must is ne null");

			return false;
		}
		// cote match Book : msg
		Book book = bookDao.selectBookByCote(cote);
		if (book == null) {
			System.out.println("book dosen't exist");
			return false;
		}

		// Member can checkout yet : msg
		if (member.canCheckout() == false) {
			System.out.println("max book attient");
			return false;
		}

		// Book available : msg
		if (book.isAvailable() == false) {
			System.out.println("book is not available");
			return false;
		}

		// make relation : Checkout
		member.addBook(book);
		book.setLoaner(member);
		System.out.println("book checkout succesfully");
		return true;
	}

}