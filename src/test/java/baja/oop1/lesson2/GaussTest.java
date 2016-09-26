package baja.oop1.lesson2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GaussTest {
	@Test
	public void testBasicWeekday() {
		int monday = GaussCalendar.weekday(2016, 9, 26);
		assertEquals(1, monday);
	}
	
	@Test
	public void testMarch29() {
		int monday = GaussCalendar.weekday(2016, 2, 29);
		assertEquals(1, monday);
	}
	
	@Test
	public void testMarch29March1Match() {
		int feb29 = GaussCalendar.weekday(2015, 2, 29);
		int march1 = GaussCalendar.weekday(2015, 3, 1);
		assertEquals(feb29, march1);
	}
	
	@Test
	public void testLeapyear() {
		boolean isLeap = GaussCalendar.isLeapYear(2016);
		assertEquals(true, isLeap);
		isLeap = GaussCalendar.isLeapYear(2015);
		assertEquals(false, isLeap);
	}
	@Test
	public void testLeapyearWithWeekday() {
		boolean isLeap = GaussCalendar.isLeapYearWithWeekday(2016);
		assertEquals(true, isLeap);
		isLeap = GaussCalendar.isLeapYearWithWeekday(2015);
		assertEquals(false, isLeap);
	}
}
