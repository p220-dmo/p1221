package fr.htc.library.dao;

import java.util.Map;

import fr.htc.library.dao.db.DataBase;
import fr.htc.library.data.Member;

public class MemberDao {

	// C
	public Member save(Member member) {
		Map<String, Member> map = DataBase.getMemberTable();
		map.put(member.getMatricule(), member);
		Member savedMember = selectMemberByMatricule(member.getMatricule());
		System.out.println("Member saved succesfully... : " + savedMember );
		return savedMember;
	}

	// R
	public Member selectMemberByMatricule(String matricule) {
		Member findMember = DataBase.getMemberTable().get(matricule);
		return findMember;

	}

}
