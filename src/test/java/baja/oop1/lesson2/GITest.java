package baja.oop1.lesson2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GITest {
	@Test
	public void testRegularMembership() {
		double fee1 = GI.membershipFee(20000, false, false, false);
		assertEquals("Fee for regular member with salary 20000 is wrong", 86.00, fee1, 0);
		double fee2 = GI.membershipFee(10000, false, false, false);
		assertEquals("Fee for regular member with salary 10000 is wrong", 16.00, fee2, 0);
		// partner membership
		double fee3 = GI.membershipFee(20000, true, false, false);
		assertEquals("Fee for regular partner member with salary 20000 is wrong", 15.00, fee3, 0);
		double fee4 = GI.membershipFee(10000, true, false, false);
		assertEquals("Fee for regular partner member with salary 10000 is wrong", 15.00, fee4, 0);
	}

	@Test
	public void testRetiredMembership() {
		double fee1 = GI.membershipFee(20000, false, false, true);
		assertEquals("fee for retired member with salary 20000 is wrong", 43.00, fee1, 0);
		double fee2 = GI.membershipFee(10000, false, false, true);
		assertEquals("fee for retired member with salary 10000 is wrong", 16.00, fee2, 0);
		double fee3 = GI.membershipFee(20000, true, false, true);
		assertEquals("fee for retired partner member with salary 20000 is wrong", 15.00, fee3, 0);
		double fee4 = GI.membershipFee(20000, false, true, true);
		assertEquals("fee for retired associate member with salary 20000 is wrong", 17.50, fee4, 0);
		double fee5 = GI.membershipFee(20000, true, true, true);
		assertEquals("fee for retired associate partner member with salary 20000 is wrong", 15.00, fee5, 0);
		double fee6 = GI.membershipFee(10000, true, false, true);
		assertEquals("fee for retired partner member with salary 10000 is wrong", 15.00, fee6, 0);
		double fee7 = GI.membershipFee(10000, false, true, true);
		assertEquals("fee for retired associate member with salary 10000 is wrong", 16.00, fee7, 0);
		double fee8 = GI.membershipFee(10000, true, true, true);
		assertEquals("fee for retired associate partner member with salary 10000 is wrong", 15.00, fee8, 0);
	}

	@Test
	public void testAssociatedNonRetiredMembership() {
		double fee1 = GI.membershipFee(20000, false, true, false);
		assertEquals("fee for associate member with salary 20000 is wrong", 50.00, fee1, 0);
		double fee2 = GI.membershipFee(10000, false, true, false);
		assertEquals("fee for associate member with salary 10000 is wrong", 16.00, fee2, 0);
		double fee3 = GI.membershipFee(20000, true, true, false);
		assertEquals("fee for associate partner member with salary 20000 is wrong", 15.00, fee3, 0);
		double fee4 = GI.membershipFee(10000, true, true, false);
		assertEquals("fee for associate partner member with salary 10000 is wrong", 15.00, fee4, 0);
	}

}
