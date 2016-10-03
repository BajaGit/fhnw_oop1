package baja.oop1.lesson3.rect;

import java.util.ArrayList;
import java.util.List;

public class Rect {
	private final int maxX;
	private final int minX;
	private final int maxY;
	private final int minY;
	
	
	public Rect(Point p1, Point p2){
		this.maxX = p1.getX() > p2.getX() ? p1.getX() : p2.getX();
		this.minX = this.maxX == p2.getX() ? p1.getX() : p2.getX();
		this.maxY = p1.getY() > p2.getY() ? p1.getY() : p2.getY();
		this.minY = this.maxY == p2.getY() ? p1.getY() : p2.getY();
	}

	/**
	 * Intersects the Rectangle with another one, returning all shared Points
	 * @param r2 The Rect to intersect with
	 * @return List<Point> points shared between Rects, can be empty, can not be null
	 */
	public List<Point> intersect(Rect r2) {
		List<Point> ret = new ArrayList<Point>();
		Point _new = null;
		for ( int x = minX; x <= maxX; x++){
			for ( int y = minY; y <= maxY; y++){
				_new = new Point(x,y);
				if ( this.contains(_new) && r2.contains(_new)){
					ret.add(_new);
				}
			}
		}
		
		return ret;
	}
	
	/**
	 * Checks if a list of points equals all the points contained within this rect
	 * @param points
	 * @return boolean indicating equality for the points
	 */
	public boolean is(List<Point> points){
		int pointMaxX = 0;
		int pointMinX = 1000;
		int pointMaxY = 0;
		int pointMinY = 1000;
		
		for ( Point p : points){
			if ( p.getX() > pointMaxX){
				pointMaxX = p.getX();
			} else if ( p.getX() < pointMinX){
				pointMinX = p.getX();
			}
			if ( p.getY() > pointMaxY){
				pointMaxY = p.getY();
			} else if ( p.getY() < pointMinY){
				pointMinY = p.getY();
			}
		}
		return pointMaxX == this.maxX && pointMinX == this.minX && pointMaxY == this.maxY && pointMinY == this.minY;
	}
	
	public boolean containsAll(List<Point> points){
		return points.stream().allMatch(this::contains);
	}
	
	
	private boolean contains(Point p) {
		// check if point is within bounds
		boolean ret =  p.getX() >= this.minX &&
				p.getX() <= this.maxX &&
				p.getY() >= this.minY &&
				p.getY() <= this.maxY;
		return ret;
	}

	/**
	 * A Rect is equal to another if all corners are the same
	 */
	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof Rect){
			Rect other = ((Rect) obj);
			return other.maxX == this.maxX && other.minX == this.minX &&
					other.maxY == this.maxY && other.maxY == this.maxY;
		} else {
			return false;
		}
	}
	
}
