package baja.oop1.lesson2.nim;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NimGame {
	
	// RED is computer for the moment
	private enum PLAYER {
		BLUE, RED;
	}
	private PLAYER active = PLAYER.BLUE;
	private int sticks;
	private final int MAXSTICKSPERTURN = 3;
	private boolean abort = false;
	private final Scanner scanner = new Scanner(System.in);
	
	
	public NimGame(int sticks){
		this.sticks = sticks;
	}
	
	private boolean hasGameEnded(){
		return sticks < 1;
	}
	
	public void start(){
		System.out.println("Welcome to Stixx!");
		System.out.println("Pick between 1-3 stick each turn against the computer");
		System.out.println("But don't touch the last one! Make him touch it instead!");
		gameLoop();
		scanner.close();
	}
	
	private void gameLoop(){
		if ( this.active == PLAYER.RED){
			computerTurn();
		} else {
			playerTurn();
		}
		
		if (!hasGameEnded() && !abort){
			changePlayer();
			gameLoop();
		} else {
			end();
		}
	}
	
	private void computerTurn(){
		int toRemove = 0;
		if ( this.sticks > this.MAXSTICKSPERTURN){
			toRemove = this.MAXSTICKSPERTURN;
		} else {
			toRemove = this.sticks - 1;
		}
		
		this.sticks-=toRemove;
		System.out.println("Computer removed " + toRemove + " sticks!");
		System.out.println("There are" + this.sticks + " left.");
	}
	
	private void playerTurn(){
		int number = promptPlayer();
		if ( number < 0){
			abort = true;
		} else {
			this.sticks-=number;
		}
	}
	
	private void end(){
		if ( abort ){
			System.out.println("Aborting Game...");
			System.out.println("Good bye");
			System.exit(0);
		}
		if ( this.active == PLAYER.RED){
			System.out.println("Ooopps! You touched the last stick! You lost!");
		} else {
			System.out.println("You won!");
		}
	}
	
	private void changePlayer(){
		if ( this.active == PLAYER.BLUE){
			this.active = PLAYER.RED;
		} else {
			this.active = PLAYER.BLUE;
		};
	}
	
	// prompt user once for integer value
	// will return -1 as error value
	private int promptPlayer(){
		try{
			System.out.println("Please enter a number between 1 and " + this.MAXSTICKSPERTURN);
			System.out.print("> ");
			int n = 0;
			while (n == 0) {
				n = scanner.nextInt();
			}
			return n;
		} catch ( InputMismatchException e){
			return -1;
		}
	}
}
