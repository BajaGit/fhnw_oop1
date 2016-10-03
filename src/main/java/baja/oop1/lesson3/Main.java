package baja.oop1.lesson3;

import baja.oop1.lesson3.network.NetworkRunner;
import baja.oop1.lesson3.ships.ShipGame;
import baja.oop1.lesson3.wg.WgRunner;

public class Main {
	public static void main(String[] args){
		Main main = new Main();
//		main.runWg();
//		main.runNetwork();
		main.startShipGame();
	}
	
	
	public void startShipGame(){
		ShipGame sg = new ShipGame();
		sg.start();
	}
	
	public void runNetwork(){
		System.out.println("RUNNING NETWORK TRACE 1 ********************");
		NetworkRunner.printTrace(NetworkRunner.a, 0);
		System.out.println("RUNNING NETWORK TRACE 2 ********************");
		NetworkRunner.printTrace(NetworkRunner.a, 1);
		
		System.out.println("RUNNING NETWORK PATH A ********************");
		NetworkRunner.path(NetworkRunner.a);
		System.out.println("RUNNING NETWORK PATH B ********************");
		NetworkRunner.path(NetworkRunner.b);
		System.out.println("RUNNING NETWORK PATH C ********************");
		NetworkRunner.path(NetworkRunner.c);
		
		
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
