public class reference {
	public static void main (String argv[]) {
		int primary = 10;
		int primary_copy = primary;
		primary_copy ++;

		System.out.println ("primary copy is changed to " + primary_copy);
		System.out.println ("but primary is not changed, " + primary);
		int reference [] = {1, 2, 3};
		int copy_ [] = reference;
		copy_ [0] = 5;
		System.out.println (reference [0]);
	}
}
