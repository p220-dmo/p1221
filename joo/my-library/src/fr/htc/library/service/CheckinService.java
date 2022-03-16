package fr.htc.library.service;

import fr.htc.library.dao.BookDao;
import fr.htc.library.dao.MemberDao;
import fr.htc.library.data.Book;
import fr.htc.library.data.Member;
import fr.htc.library.utils.ScannerUtils;

public class CheckinService {

	MemberDao memberDao = new MemberDao();
	BookDao bookDao = new BookDao();

	public void checkin() {

		System.out.print("Matricule : ");
		String matricule = ScannerUtils.getInstance().next();
		System.out.print("Cote : ");
		String cote = ScannerUtils.getInstance().next();

		this.checkin(matricule, cote);

	}

	public boolean checkin(String matricule, String cote) {

		// matricule not null : msg
		if (matricule == null || matricule.isBlank()) {
			System.out.println("matricul mustn't be null");
			return false;
		}

		// cote not null : msg
		if (cote == null || cote.isBlank()) {
			System.out.println("cote mustn't be null");
			return false;
		}

		// Matricule match Member : msg
		Member member = memberDao.selectMemberByMatricule(matricule);
		if (member == null) {
			System.out.println("member doesn't exists");
			return false;
		}

		// cote match Book : msg
		Book book = bookDao.selectBookByCote(cote);
		if (book == null) {
			System.out.println("book doesn't exists");
			return false;
		}

		// Member can checkin : msg

		if (member.hasBook(cote) == false) {
			System.out.println("book doesn't belong to member ");
			return false;
		}
		// Book available : msg
		if (book.isLoaner(matricule) == false) {
			System.out.println("book not available");
			return false;
		}
		// make relation : Checkout
		member.deleteBook(book);
		book.setLoaner(null);
		System.out.println("chekin successfully");
		return true;

	}

}
