package baja.oop1.lesson3;

import baja.oop1.lesson3.wg.WgRunner;

public class Main {
	public static void main(String[] args){
		Main main = new Main();
		main.runWg();
		
	}
	
	
	public void runWg(){
		WgRunner runner = new WgRunner();
		
		System.out.println("RUNNING WG CLEAN ********************");
		runner.clean();
		
		System.out.println("RUNNING STUDENT ADRESSES ********************");
		runner.printStudents();
		
		System.out.println("RUNNING STUDENT COMPARE ********************");
		runner.printCompare();
		
	}
}
