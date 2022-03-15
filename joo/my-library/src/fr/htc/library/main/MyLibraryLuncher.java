package fr.htc.library.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import fr.htc.library.data.Book;

import fr.htc.library.data.Member;

public class MyLibraryLuncher {
	
	public static  Map <String, Member>  memberMap  = new HashMap<String, Member>();// initialisation de Map POUR ADHERENTS
	public static Map<String, Book> bookMap = new HashMap<String, Book>();// initialisation de mAP POUR BOOK
	public static void main(String[] args) {
		
		//Test Member creation 
		Member m1 = new Member("Djamel", "", 30);
		//System.out.println(m1);
		Member m2 = new Member(null, "MOUCHENE", 30);
		//System.out.println(m2);
		Member m3 = new Member("", "", 30);
		//System.out.println(m3);
		Member m4 = new Member("Fatima", "ADDA", 30);
		//System.out.println(m4);
		
		
		//Test Book creation 
		Book b1 = new Book("Nedjma", "Kateb yacine", 1985);
		//System.out.println(b1);
		Book b2 = new Book("Alchimiste", "Paolo COHELO", 1995);
		//System.out.println(b2);
		Book b3 = new Book("Les chemins qui montent", "Mouloud FERAOUNE", 1957);
		//System.out.println(b3);
		
		// tester la création  de la map
		
		 memberMap.put(m1.getMatricule(), m1);  
         memberMap.put(m2.getMatricule(), m2);
         memberMap.put(m3.getMatricule(), m3);
         memberMap.put(m4.getMatricule(), m4);
         
         //afficher la taille de la map;
         
         System.out.println(memberMap.size()); 
         
         
         
         //afficher tout les element de la map en finction de l'id 
         System.out.println(memberMap.get("XD100") );
         System.out.println(memberMap.get("MX101") );
         System.out.println(memberMap.get("XX102") );
         System.out.println(memberMap.get("AF103") );
         
         bookMap.put(b1.getCote(), b1);  
         bookMap.put(b2.getCote(), b2);
         bookMap.put(b3.getCote(), b3);
         
         System.out.println();
         
         System.out.println(bookMap.size()); 	
         System.out.println(bookMap.get("KY100") );
//         System.out.println(bookMap.get("MX101") );
//         System.out.println(bookMap.get("XX102") );
//         System.out.println(bookMap.get("AF103") );
         
//   boucle qui permet d'afficher tous les éléments de la map des member;
// for (String key : memberMap.keySet()) {
//             System.out.println(memberMap.get(key));
//   }
	
         
////         Set listKeys = memberMap.keySet();
////         Iterator it = listKeys.iterator();
////         while (it.hasNext()) {
////        	 Object key = it.next();
////        	 System.out.println(key+ " "+ memberMap.get(key));
//         }
	}
		
}
