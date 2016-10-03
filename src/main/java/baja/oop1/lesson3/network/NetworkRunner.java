package baja.oop1.lesson3.network;

public class NetworkRunner {
	public static final Person a = new Person();
	public static final Person b = new Person();
	public static final Person c = new Person();
	public static final Person d = new Person();

	static {
		a.name = "Alice";
		a.knows = new Person[2]; // alice has two friends

		b.name = "Bob";
		b.knows = new Person[2]; // bob has two friends

		c.name = "Carol";
		c.knows = a.knows; // carol has the same friends as alice

		d.name = "Daniel";
		d.knows = new Person[3]; // daniel has three friends

		a.knows[0] = b;
		a.knows[1] = d;
		b.knows[0] = c;
		b.knows[1] = d;
		d.knows[0] = c;
		d.knows[1] = d;
		d.knows[2] = a;
	}

	public static void printTrace(Person p, int index) {
		for (int i = 0; i < 4; i++) {
			System.out.println(p.name);
			p = p.knows[index];
		}
		System.out.println();
	}
	/*
	 * Call printTrace(a, 0) prints: Alice Bob Bob Bob {{empty line}}
	 * 
	 * Call printTrace(a, 1) prints: Alice Daniel Daniel Daniel {{empty line}}
	 * 
	 */

	public static void path(Person p) {
		Person x = p.knows[0].knows[0];
		Person y = p.knows[1].knows[0];
		System.out.println(x.name);
		System.out.println(y.name);
		System.out.println(x == y);
		System.out.println();
	}
	/*Call path(a) prints:
	 *  Carol
	 *  Carol
	 *  true
	 *  {{empty newline}}
	 * 
	 * Call path(b) prints:
	 * Bob
	 * Carol
	 * false
	 * {{empty newline}}
	 * 
	 * Call path(c) prints:
	 * Carol
	 * Carol
	 * true
	 * {{empty newline}}
	 * 
	 * 
	 */
}
