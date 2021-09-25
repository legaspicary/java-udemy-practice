
public class NumberChallenges {
	public static int sumFirstAndLastDigit(int number) {
		int firstDigit = 0;
		int lastDigit = number % 10;
		while (number > 9) {
			number /= 10;
		}
		firstDigit = number;
		return number >= 0 ? (firstDigit + lastDigit) : -1;
	}

	public static int getEvenDigitSum(int number) {
		int sum = 0;
		if (number < 0)
			return -1;
		while (number > 0) {
			int currentDigit = number % 10;
			if (currentDigit % 2 == 0) {
				sum += currentDigit;
			}
			number /= 10;
		}
		return sum;
	}

	private static boolean isInRange(int n, int to, int from) {
		return n >= to && n <= from;
	}

	public static boolean hasSharedDigit(int a, int b) {
		boolean isSharingDigit = false;
		if (isInRange(a, 10, 99) && isInRange(b, 10, 99)) {
			for (int i = a; i > 0; i /= 10) {
				int currentDigitOfA = i % 10;
				for (int j = b; j > 0; j /= 10) {
					int currentDigitOfB = j % 10;
					if (currentDigitOfA == currentDigitOfB) {
						isSharingDigit = true;
						break;
					}
				}
			}
		}
		return isSharingDigit;
	}

	public static boolean isValid(int n) {
		return n >= 10 && n <= 1000;
	}

	public static boolean hasSameLastDigit(int a, int b, int c) {
		boolean isSameLastDigit = false;
		if (isValid(a) && isValid(b) && isValid(c)) {
			int lastDigitOfA = a % 10;
			int lastDigitOfB = b % 10;
			int lastDigitOfC = c % 10;
			isSameLastDigit = lastDigitOfA == lastDigitOfB || lastDigitOfA == lastDigitOfC
					|| lastDigitOfB == lastDigitOfC;
		}
		return isSameLastDigit;
	}

	public static int getGreatestCommonDivisor(int first, int second) {
		int result = -1;
		int max = first >= second ? first : second;
		if (first >= 10 && second >= 10) {
			for (int i = 1; i < max; i++) {
				if (first % i == 0 && second % i == 0) {
					result = i;
				}
			}
		}
		return result;
	}

	public static void printFactors(int number) {
		if (number < 0) {
			System.out.println("Invalid Value");
			return;
		}
		System.out.print("1 ");
		for (int i = 2; i <= number; i++) {
			if (number % i == 0)
				System.out.print(i + " ");
		}
	}

	public static boolean isPerfectNumber(int number) {
		int sum = 1;
		for (int i = 2; i < number; i++) {
			if (number % i == 0)
				sum += i;
		}
		return sum == number;
	}

	public static int reverse(int n) {
		int reverse = 0;
		boolean isNegative = n < 0;
		n = Math.abs(n);
		while (n > 0) {
			reverse = (reverse * 10) + (n % 10);
			n /= 10;
		}
		return (isNegative ? -1 : 1) * (reverse);
	}

	public static int getDigitCount(int n) {
		if (n < 0)
			return -1;
		int count = (n == 0 ? 1 : 0);
		while (n > 0) {
			count++;
			n /= 10;
		}
		return count;
	}

	// CHALLENGE: Do not use arrays
	public static void numberToWords(int number) {
		if (number < 0) {
			System.out.println("Invalid Value");
		}

		int reversedNumber = reverse(number);
		int digitCount = getDigitCount(number);
		int processedNumberCount = 0;
		while (reversedNumber > 0) {
			int currentDigit = reversedNumber % 10;
			switch (currentDigit) {
			case 0:
				System.out.print("Zero ");
				break;
			case 1:
				System.out.print("One ");
				break;
			case 2:
				System.out.print("Two ");
				break;
			case 3:
				System.out.print("Three ");
				break;
			case 4:
				System.out.print("Four ");
				break;
			case 5:
				System.out.print("Five ");
				break;
			case 6:
				System.out.print("Six ");
				break;
			case 7:
				System.out.print("Seven ");
				break;
			case 8:
				System.out.print("Eight ");
				break;
			case 9:
				System.out.print("Nine ");
				break;
			}
			reversedNumber /= 10;
			processedNumberCount++;
		}

		for (int i = processedNumberCount; i < digitCount; i++) {
			System.out.print("Zero ");
		}
	}

	public static boolean canPack(int bigCount, int smallCount, int goal) {
		boolean isValid = (bigCount >= 0 && smallCount >= 0 && goal >= 0);
		// TODO: handle when small count is zero but big count is not
		return isValid && (goal % 5 == 0 && bigCount >= (goal / 5)) || (5 * bigCount) + smallCount >= goal;
	}
}
