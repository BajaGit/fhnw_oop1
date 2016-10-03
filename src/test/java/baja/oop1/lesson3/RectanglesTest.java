package baja.oop1.lesson3;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import baja.oop1.lesson3.rect.Rectangles;

public class RectanglesTest {

	@Test
	public void testDisjoint() {
		assertEquals("disjoint", Rectangles.compareRectangles(0, 0, 5, 3, 7, 1, 11, 4));
		assertEquals("disjoint", Rectangles.compareRectangles(5, 3, 0, 0, 7, 1, 11, 4));
		assertEquals("disjoint", Rectangles.compareRectangles(0, 3, 5, 0, 7, 1, 11, 4));
		assertEquals("disjoint", Rectangles.compareRectangles(5, 0, 0, 3, 7, 1, 11, 4));

		assertEquals("disjoint", Rectangles.compareRectangles(11, 4, 7, 1, 3, 6, 4, 7));
		assertEquals("disjoint", Rectangles.compareRectangles(11, 1, 7, 4, 3, -3, 4, -2));

		assertEquals("disjoint", Rectangles.compareRectangles(0, 0, 5, 3, 5, 4, 6, 5));
		assertEquals("disjoint", Rectangles.compareRectangles(5, 3, 0, 0, 5, -1, 6, -2));
		assertEquals("disjoint", Rectangles.compareRectangles(0, 3, 5, 0, 0, -1, -1, -2));
		assertEquals("disjoint", Rectangles.compareRectangles(5, 0, 0, 3, -1, 4, -2, 5));
	}

	@Test
	public void testSame() {
		assertEquals("same", Rectangles.compareRectangles(0, 0, 5, 3, 0, 0, 5, 3));
		assertEquals("same", Rectangles.compareRectangles(0, 0, 5, 3, 0, 0, 5, 3));
		assertEquals("same", Rectangles.compareRectangles(0, 0, 5, 3, 0, 0, 5, 3));
		assertEquals("same", Rectangles.compareRectangles(0, 0, 5, 3, 0, 0, 5, 3));

		assertEquals("same", Rectangles.compareRectangles(5, 0, 0, 3, 5, 0, 0, 3));
		assertEquals("same", Rectangles.compareRectangles(5, 0, 0, 3, 5, 0, 0, 3));
		assertEquals("same", Rectangles.compareRectangles(5, 0, 0, 3, 5, 0, 0, 3));
		assertEquals("same", Rectangles.compareRectangles(5, 0, 0, 3, 5, 0, 0, 3));

		assertEquals("same", Rectangles.compareRectangles(5, 3, 0, 0, 5, 3, 0, 0));
		assertEquals("same", Rectangles.compareRectangles(5, 3, 0, 0, 5, 3, 0, 0));
		assertEquals("same", Rectangles.compareRectangles(5, 3, 0, 0, 5, 3, 0, 0));
		assertEquals("same", Rectangles.compareRectangles(5, 3, 0, 0, 5, 3, 0, 0));

		assertEquals("same", Rectangles.compareRectangles(0, 3, 5, 0, 0, 3, 5, 0));
		assertEquals("same", Rectangles.compareRectangles(0, 3, 5, 0, 0, 3, 5, 0));
		assertEquals("same", Rectangles.compareRectangles(0, 3, 5, 0, 0, 3, 5, 0));
		assertEquals("same", Rectangles.compareRectangles(0, 3, 5, 0, 0, 3, 5, 0));
	}

	@Test
	public void testContained() {
		assertEquals("contained", Rectangles.compareRectangles(0, 0, 5, 3, 1, 1, 2, 2));
		assertEquals("contained", Rectangles.compareRectangles(0, 0, 5, 3, 0, 0, 2, 2));
		assertEquals("contained", Rectangles.compareRectangles(5, 3, 0, 0, 1, 0, 2, 1));
		assertEquals("contained", Rectangles.compareRectangles(0, 3, 5, 0, 4, 1, 5, 2));
		assertEquals("contained", Rectangles.compareRectangles(5, 0, 0, 3, 1, 2, 2, 3));
	}

	@Test
	public void testTouching() {
		assertEquals("touching", Rectangles.compareRectangles(0, 0, 5, 3, 6, 4, 5, 3));
		assertEquals("touching", Rectangles.compareRectangles(5, 3, 0, 0, 6, 0, 5, -2));
		assertEquals("touching", Rectangles.compareRectangles(0, 3, 5, 0, 0, 0, -2, -2));
		assertEquals("touching", Rectangles.compareRectangles(5, 0, 0, 3, 0, 5, -3, 3));
	}

	@Test
	public void testAligned() {
		assertEquals("aligned", Rectangles.compareRectangles(0, 0, 5, 3, 7, 2, 5, 5));
		assertEquals("aligned", Rectangles.compareRectangles(5, 3, 0, 0, 3, 3, 0, 6));
		assertEquals("aligned", Rectangles.compareRectangles(0, 3, 5, 0, 0, -2, -3, 4));
		assertEquals("aligned", Rectangles.compareRectangles(5, 0, 0, 3, 3, -2, 2, 0));
	}
	
	@Test
	public void testIntersecting() {
		assertEquals("intersecting", Rectangles.compareRectangles(0, 0, 5, 5, 3, 3, 6, 6));
	}

	

}
