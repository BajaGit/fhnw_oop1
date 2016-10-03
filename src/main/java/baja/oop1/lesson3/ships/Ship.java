package baja.oop1.lesson3.ships;

import java.util.Arrays;
import java.util.List;

public class Ship {

	private final int MAXHITS = 3;
	
	private int hits = 0;
	private final int id;
	
	private final List<Position> locations;
	
	public Ship(int id, Position... locations){
		this.id = id;
		this.locations = Arrays.asList(locations);
	}
	
	public void hitscan(Position p){
		for ( Position loc: locations){
			if ( loc.equals(p)){
				hits++;
				System.out.println("Ship " + id + " has been hit!") ;
				System.out.println("Total hits: " + hits);
				break;
			}
		}
	}
	
	public boolean isSunk(){
		return this.hits >= this.MAXHITS;
	}
	
	public void printLocations(){
		for ( Position p: locations){
			System.out.println("x:" + p.getX() + "|y:" + p.getY() );
		}
	}
}
