
public class Main {

	public static void main(String[] args) {
		SpeedConverter.printConversion(1.54);
		MegaBytesConverter.printMegaBytesAndKiloBytes(2500);
		System.out.println(BarkingDog.shouldWakeUp(true, 8));
		System.out.println(LeapYear.isLeapYear(-1200));
		MinutesToYearsDaysCalculator.printYearsAndDays(1_051_200);
	}

}
