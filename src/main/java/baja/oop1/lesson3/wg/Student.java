package baja.oop1.lesson3.wg;

import java.io.PrintStream;

public class Student {
	String name;
	Apartment ap;
	
	public void printAddress(PrintStream ps){
		ps.println(this.name + "s Adresse lautet " + ap.address);
	}
}
