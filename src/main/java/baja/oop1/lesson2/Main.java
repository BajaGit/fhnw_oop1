package baja.oop1.lesson2;

import java.util.Scanner;

import baja.oop1.lesson2.nim.NimGame;

public class Main {

	public static void main(String[] args) {
		NimGame game = new NimGame(20);
		game.start();
	}
	
	@SuppressWarnings("unused")
	private void readInput(){
		
		Scanner s = new Scanner(System.in);
		System.out.print("enter a number: ");
		int n = s.nextInt();
		while (n != 0) {
			System.out.println("Number read: " + n);
			System.out.print("enter a number: ");
			n = s.nextInt();
		}
		s.close();
	}

}
