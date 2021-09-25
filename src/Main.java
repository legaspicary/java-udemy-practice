
public class Main {

	public static void main(String[] args) {
		SpeedConverter.printConversion(1.54);
		MegaBytesConverter.printMegaBytesAndKiloBytes(2500);
		System.out.println(BarkingDog.shouldWakeUp(true, 8));
		System.out.println(LeapYear.isLeapYear(-1200));
		MinutesToYearsDaysCalculator.printYearsAndDays(1_051_200);
//		InputCalculator.inputThenPrintSumAndAverage();
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
		System.out.println(NumberChallenges.canPack(1, 0, 4));
	}

}
