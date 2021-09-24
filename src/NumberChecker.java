
public class NumberChecker {
	public static boolean hasEqualSum(int a, int b, int c) {
		return a + b == c;
	}

	private static boolean isTeen(int n) {
		return n >= 13 && n <= 19;
	}

	public static boolean hasTeen(int a, int b, int c) {
		return isTeen(a) || isTeen(b) || isTeen(c);
	}
}
