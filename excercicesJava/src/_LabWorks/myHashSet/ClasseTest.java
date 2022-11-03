package monHashSet;

import java.util.*;

public class ClasseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 
		 * 
		 */
		///exemple du cours
		SortedSet <Integer> b = new TreeSet<>();
		
		//exemple du cours

		Set <Integer> a = new TreeSet<>();
		Random r = new Random();
		for (int i =0; i<100; i++) {
			a.add(r.nextInt(1000));
		}
		
		System.out.println(); // chercher a ajouter head of set;
		
		
		
		
		Set<String> s = new MonHashSet2<>();

		/*
		 * System.out.println(s.add("toto")); System.out.println(s.add("titi"));
		 * System.out.println(s.add("toto")); System.out.println(s.contains("toto"));
		 * System.out.println("----------------------------------------");
		 * 
		 * 
		 * System.out.println(s.add("toto"));
		 */ 
		
		System.out.println("++++++++++++++++++++++++++++++");

		s.add("a");
		s.add("b");
		s.add("c");
		s.add("d");
		s.add("e");
		s.add("f");
		s.add("g");
		s.add("h");
		s.add("i");
		s.add("j");

		System.out.println("----------------------------------------");

		// System.out.println(s);
		s.forEach(x -> System.out.println(x));

	}

}
