package baja.oop1.lesson3.rect;

import java.util.List;

public class Rectangles {
	
	public static String compareRectangles(
			int px, int py, int qx, int qy,
			int sx, int sy, int tx, int ty) {
		
		//RECT 1
		Point r1e1 = new Point(px, py);
		Point r1e2 = new Point(qx, qy);
		Rect r1 = new Rect(r1e1, r1e2);
		//RECT 2
		Point r2e1 = new Point(sx, sy);
		Point r2e2 = new Point(tx, ty);
		Rect r2 = new Rect(r2e1, r2e2);
		
		if (r1.equals(r2)){
			return "same";
		}else {
			List<Point> intersect = r1.intersect(r2);
			if ( intersect.size() > 1){
				boolean isXLine = intersect.stream()
						.mapToInt(Point::getX) // get all x coords
						.allMatch( p -> p == intersect.get(0).getX()); // check if they are all equal
				boolean isYLine = intersect.stream()
						.mapToInt(Point::getY) // get all y coords
						.allMatch( p -> p == intersect.get(0).getY()); // check if they are all equal
				if ( isXLine || isYLine){
					return "aligned";
				} else {
					return r1.is(intersect) || r2.is(intersect) ? "contained" : "intersecting";
				}
			} else if ( intersect.size() == 1){
				// one point shared means they are touching at the corners
				return "touching";
			}
		}
		// if all tests failed, they are not connected
		return "disjoint";
	}

	

	
}
