package fr.htc.library.service;

import fr.htc.library.dao.MemberDao;
import fr.htc.library.data.Member;
import fr.htc.library.utils.ScannerUtils;

public class MemberService {
	MemberDao memberDao = new MemberDao();

	public Member addMember() {
		System.out.println("Add Memeber  : FirsName;LastName;Age");
		String input = ScannerUtils.getInstance().next();
		String[] values = input.split(";");

		String firstName = values[0];
		String lastName = values[1];
		int age = Integer.parseInt(values[2]);
		return this.addMember(firstName, lastName, age);
	}

	public Member addMember(String firstName, String lastName, int age) {
		Member member = new Member(firstName, lastName, age);
		return this.addMember(member);
	}

	public Member addMember(Member member) {
		return memberDao.save(member);
	}

	public Member getMemberByMatricule(String matricule) {
		if (matricule == null || matricule.isBlank()) {
			return null;
		}
		return memberDao.selectMemberByMatricule(matricule);
	}

}
