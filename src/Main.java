import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String completeSampleFilePath = "C:\\Users\\Cary\\eclipse-workspace\\PracticeJavaProject\\src\\Sample";
		try (FileWriter locFile = new FileWriter("sampletext.txt");) {
			for (int i = 0; i < 10; i++) {
				locFile.write(String.format("No. %d line written! using the file writer class", i + 1) + "\n");
			}
		} catch (IOException e) {
			System.out.println("An io exception occured");
		}

	}

	private static int getInt() {
		return Main.scanner.nextInt();
	}

	private static String getString() {
		return Main.scanner.nextLine();
	}

	private static double getDouble() {
		return Main.scanner.nextDouble();
	}

	public static void simpleTryCatchDemo() {
		while (true) {
			try {
				double val = getDouble();
				System.out.println("Yoww " + val);
			} catch (InputMismatchException | ArithmeticException e) {
				Main.scanner.nextLine();
				System.out.println("Input mismatch");
			}
		}
	}

	public static void randomDemo() {
		SpeedConverter.printConversion(1.54);
		MegaBytesConverter.printMegaBytesAndKiloBytes(2500);
		System.out.println(BarkingDog.shouldWakeUp(true, 8));
		System.out.println(LeapYear.isLeapYear(-1200));
		MinutesToYearsDaysCalculator.printYearsAndDays(1_051_200);
		InputCalculator.inputThenPrintSumAndAverage();
		System.out.println(NumberOfDaysInMonth.getDaysInMonth(2, 2001));
		System.out.println(NumberChecker.isPalindrome(707));
		System.out.println(NumberChallenges.sumFirstAndLastDigit(1242));
		System.out.println(NumberChallenges.getEvenDigitSum(252));
		System.out.println(NumberChallenges.hasSharedDigit(25, 32));
		System.out.println(NumberChallenges.getGreatestCommonDivisor(25, 15));
		NumberChallenges.printFactors(-6);
		System.out.println(NumberChallenges.isPerfectNumber(7));
		System.out.println(NumberChallenges.reverse(-27));
		NumberChallenges.numberToWords(1010);
		System.out.println();
		System.out.println(NumberChallenges.canPack(5, 3, 24));
		System.out.println(NumberChallenges.getLargestPrime(217));
		ArtChallenges.printSquareStar(8);
		System.out.println(PaintJob.getBucketCount(6.26, 2.2));
	}
}
