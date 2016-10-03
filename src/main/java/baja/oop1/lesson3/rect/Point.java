package baja.oop1.lesson3.rect;

import baja.oop1.lesson3.ships.Position;

public class Point extends Position {
	public Point(int x, int y) {
		super(x, y);
	}
	
	public boolean between(Point leftUpper, Point rightLower){
		boolean luX = this.getX() > leftUpper.getX();
		boolean luY = this.getY() < leftUpper.getY();
		
		boolean rlX = this.getX() < rightLower.getX();
		boolean rlY = this.getY() > rightLower.getY();
		
		
		return luX && luY && rlX && rlY;
	}
}
