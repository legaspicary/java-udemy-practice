public class SpeedConverter {
	public static double KMH_PER_MPH = 1.609;

	public static long toMilesPerHour(double kilometersPerHour) {
		long res = -1;
		if (kilometersPerHour >= 0)
			res = Math.round(kilometersPerHour / SpeedConverter.KMH_PER_MPH);
		return res;
	}

	public static void printConversion(double kilometersPerHour) {
		if (kilometersPerHour < 0) {
			System.out.println("Invalid Value");
		} else {
			String conversionMsg = " km/h = %d mi/h";
			long result = SpeedConverter.toMilesPerHour(kilometersPerHour);
			System.out.println(kilometersPerHour + String.format(conversionMsg, result));
		}
	}
}