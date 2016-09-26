package baja.oop1.lesson2;

import java.util.function.Consumer;
import java.util.function.Function;

public class Primes {
	public static boolean isPrime(int number){
		if ( number == 1){
			return false;
		} else if ( number == 2){
			return true;
		};
		int max = (int) Math.sqrt(number);
		for ( int i = 2; i < max; i++){
			if (number % i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static void calcUpTo(int max, int itemsPerLine, Consumer<String> lineCallback){
		StringBuffer buff = new StringBuffer();
		int counter = 0;
		
		Function<Integer, String> leftpad = n -> n > 100 ? "" + n : n > 10 ? " " + n : "  " + n ;
		for (int i = 1; i < max; i++){
			if (Primes.isPrime(i)){
				buff.append(leftpad.apply(i) + " ");
				counter++;
			}
			if ( counter == 10){
				lineCallback.accept(buff.toString());
				counter = 0;
				buff.append('\n');
			}
		}
		System.out.println(buff.toString());
	}
	
	
}
