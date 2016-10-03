package baja.oop1.lesson3.ships;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class ShipGame {
	
	private final int x;
	private final int y;
	
	private final int MAXSHIPS = 3;
	
	private List<Position> shots = new ArrayList<Position>();
	
	private List<Ship> ships = new ArrayList<Ship>();
	
	public ShipGame(){
		this(7, 7);
	}
	
	public ShipGame(int x, int y){
		this.x = x;
		this.y = y;
		this.placeShips();
	}
	
	public void start(){
		try(Scanner in = new Scanner(System.in)){
			String input; 
			while(!allShipsDead()){
				System.out.println("Plase provide ccordinates to shoot in one of formats: x:y , x y");
				System.out.print("> ");
				input = in.next();
				if ( input != null && !input.isEmpty() && input.equals("exit")){
					endGame("empty input or ended by user");
				} else {
					Optional<Position> p = parseInput(input);
					if ( !p.isPresent()){
						endGame("invalid input");
					} else {
						shots.add(p.get());
						ships.stream().forEach( s -> s.hitscan(p.get()));
					}
				}
			}
		}
		printReport();
	}
	
	private void endGame(String reason) {
		System.out.println("Ending Game!");
		System.out.println("Reason: " + reason);
		System.exit(0);
	}

	private void printReport() {
		System.out.println("SHIPS REPORT");
		System.out.println("ALL SHIPS DEAD");
		System.out.println("TOOK " + this.shots.size() + " SHOTS TO KILL ALL!") ;
	}
	
	
	private Optional<Position> parseInput(String input) {
		String [] splits;
		try{
			if ( input.indexOf(':') > -1){
				splits = input.trim().split(":");
			} else {
				splits = input.trim().split(" ");
			}
			if ( splits != null && splits.length == 2){
				return Optional.of(new Position(Integer.parseInt(splits[0]), Integer.parseInt(splits[1])));
			}
		} catch ( NumberFormatException nfe){
			nfe.printStackTrace();
		}
		return Optional.ofNullable(null);
	}


	private boolean allShipsDead() {
		return ships.stream().map( s -> s.isSunk()).allMatch( b -> b == true);
	}

	private void placeShips() {
		Random gen = new Random();
		int row = 0;
		int startcol = 0;
		for ( int i = 0; i < MAXSHIPS; i++){
			row = gen.nextInt(this.y);
			startcol = gen.nextInt(this.x);
			Ship _new = new Ship(i, new Position(startcol, row), new Position(++startcol, row), new Position(++startcol, row));
			ships.add(_new);
		}
		
		// TODO: uncomment this for easier testing
//		for ( Ship s: ships){
//			System.out.println("NEW SHIP");
//			s.printLocations();
//			System.out.println();
//		}
	}
	
	
}
