package baja.oop1.lesson2;

public class GaussCalendar {
	
	public static int weekday(int year, int month, int day){
		if ( month < 3){
			year--;
		}
		month--; //transfer month into 0 based
		month-=2;// shift months
		if (month < 0){//if overflow
			month+=12;// correct overflow
		}
		int part1 = (year * 1461) / 4;
		int part2 = ((month * 153) + 2)/5;
		int part3 = (((year / 100) * 3) - 5)/4;
		
		int w = part1 + part2 + day - part3;
		
		return w % 7;
	}
	
	public static boolean isLeapYearWithWeekday(int year){
		// if february 29 and march 1 are not the same day its a leap year
		return GaussCalendar.weekday(year, 2, 29) != GaussCalendar.weekday(year, 3, 1);
	}
	
	public static boolean isLeapYear(int year){
		if ( year % 4 != 0){
			return false;
		} else if (year % 100 != 0){
			return true;
		} else if ( year % 400 != 0){
			return false;
		}
		return true;
	}
}
