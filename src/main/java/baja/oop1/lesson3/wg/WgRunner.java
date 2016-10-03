package baja.oop1.lesson3.wg;

import java.util.Arrays;

public class WgRunner {

	private Apartment smallAp;
	private Apartment bigAp;

	private Student alice;
	private Student bob;
	private Student carol;

	public WgRunner() {
		smallAp = new Apartment();
		smallAp.address = "Bahnhofstrasse, Windisch";
		smallAp.rooms = 3;
		smallAp.clean = true;

		bigAp = new Apartment();
		bigAp.address = "Bahnhofstrasse";
		bigAp.address = bigAp.address + ", Windisch";
		bigAp.rooms = 4;
		bigAp.clean = true;

		alice = new Student();
		alice.name = "Alice";
		alice.ap = bigAp; // Alice zieht in die grosse WG
		bob = new Student();
		bob.name = "Bob";
		bob.ap = bigAp; // Bob zieht auch in die grosse WG
		carol = new Student();
		carol.name = "Carol";
		carol.ap = smallAp; // Carol zieht in die kleine WG
	}

	public void clean() {
		System.out.println("CYCLE 1\n");
		alice.ap.clean = false; // Alice passiert ein Missgeschick
		System.out.println("Die kleine Wohnung ist sauber: " + smallAp.clean); // true
		System.out.println("Die grosse Wohnung ist sauber: " + bigAp.clean); //false
		System.out.println("Alices Wohnung ist sauber: " + alice.ap.clean); //false
		System.out.println("Bobs Wohnung ist sauber: " + bob.ap.clean); // false
		System.out.println("Carol Wohnung ist sauber: " + carol.ap.clean); //true
		
		System.out.println("CYCLE 2\n");
		bob.ap.clean = true; // Bob putzt
		System.out.println("Die kleine Wohnung ist sauber: " + smallAp.clean); //true
		System.out.println("Die grosse Wohnung ist sauber: " + bigAp.clean); //true
		System.out.println("Alices Wohnung ist sauber: " + alice.ap.clean);//true
		System.out.println("Bobs Wohnung ist sauber: " + bob.ap.clean);//true
		System.out.println("Carol Wohnung ist sauber: " + carol.ap.clean);//true
		
		System.out.println("CYCLE 3\n");
		bob.ap = smallAp; // Bob zieht in die kleine WG
		bob.ap.clean = false; // Bob passiert schon wieder ein Missgeschick
		System.out.println("Die kleine Wohnung ist sauber: " + smallAp.clean);//false
		System.out.println("Die grosse Wohnung ist sauber: " + bigAp.clean);//true
		System.out.println("Alices Wohnung ist sauber: " + alice.ap.clean);//true
		System.out.println("Bobs Wohnung ist sauber: " + bob.ap.clean);//false
		System.out.println("Carol Wohnung ist sauber: " + carol.ap.clean);// false
	}
	
	public void printStudents(){
		this.alice.printAddress(System.out);
		this.bob.printAddress(System.out);
		this.carol.printAddress(System.out);
	}
	
	public void printCompare(){
		System.out.println("Alice, Boband Carol wohnen in derselben WG: " + compareStudents(TYPE.WG, this.alice, this.bob, this.carol) );
		System.out.println("Alice, Boband Carol wohnen an derselben Adresse: " + compareStudents(TYPE.ADRESS, this.alice, this.bob, this.carol) );
	}
	
	private enum TYPE {
		ADRESS, WG;
	}
	
	private boolean compareStudents(TYPE type, Student... students){
		Object prev =  students.length > 0 ? getValue(students[0], type) : null;
		Object current = null;
		for ( Student s: Arrays.asList(students)){
			current = getValue(s, type);
			if ( !prev.equals(current)){
				return false;
			}
			prev = current;
		};
		return true;
	}
	
	private Object getValue(Student s, TYPE t){
		if ( t == TYPE.ADRESS){
			return s.ap.address;
		} else {
			return s.ap;
		}
	}
}
