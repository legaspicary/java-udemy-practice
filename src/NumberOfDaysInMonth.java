
public class NumberOfDaysInMonth {
	private static final int MONTH_WITH_31_DAYS = 31;
	private static final int MONTH_WITH_30_DAYS = 30;
	private static final int INVALID_RETURN = -1;

	public static boolean isLeapYear(int year) {
		return (year >= 1 && year <= 9999) && (year % 4 == 0 ? (year % 100 == 0 ? year % 400 == 0 : true) : false);
	}

	public static int getDaysInMonth(int month, int year) {
		int days = INVALID_RETURN;
		if (year < 1 || year > 9999)
			return days;
		switch (month) {
		case 1:
			days = MONTH_WITH_31_DAYS;
			break;
		case 2:
			days = isLeapYear(year) ? 29 : 28;
			break;
		case 3:
			days = MONTH_WITH_31_DAYS;
			break;
		case 4:
			days = MONTH_WITH_30_DAYS;
			break;
		case 5:
			days = MONTH_WITH_31_DAYS;
			break;
		case 6:
			days = MONTH_WITH_30_DAYS;
			break;
		case 7:
			days = MONTH_WITH_31_DAYS;
			break;
		case 8:
			days = MONTH_WITH_31_DAYS;
			break;
		case 9:
			days = MONTH_WITH_30_DAYS;
			break;
		case 10:
			days = MONTH_WITH_31_DAYS;
			break;
		case 11:
			days = MONTH_WITH_30_DAYS;
			break;
		case 12:
			days = MONTH_WITH_31_DAYS;
			break;
		default:
			days = INVALID_RETURN;
		}
		return days;
	}
}
