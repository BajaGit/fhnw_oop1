package baja.oop1.lesson2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PrimesTest {
	@Test
	public void testIsPrime() {
		boolean isPrime = Primes.isPrime(12);
		assertEquals(false, isPrime);
		isPrime = Primes.isPrime(13);
		assertEquals(true, isPrime);
		isPrime = Primes.isPrime(251);
		assertEquals(true, isPrime);
	}
	
	@Test
	public void testCalcUpTo() {
		StringBuffer result = new StringBuffer();
		Primes.calcUpTo(1000, 10,line -> result.append(line.trim() + '\n'));
		assertTrue(true);
	}
}
