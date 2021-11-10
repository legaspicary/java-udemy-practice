package com.practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain {
	public static void main(String[] args) {
//		simpleRegexDemo();
//		characterAndBoundaryDemo();
//		quantifiersDemo();
//		findAndGroupMatchDemo();
		andOrNotDemo();
	}

	public static void andOrNotDemo() {
		String sample = "xyx";
//		String regex = "x(?=y)";
//		String regex = "x(?!y)";
		String regex = "x[Y|y]";
//		String regex = "x(?=y)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sample);

		int count = 0;
		while (matcher.find()) {
			System.out.println(count + "  :  " + matcher.start() + " <--> " + matcher.end());
		}
		matcher.reset();

		System.out.println(sample.replaceAll(regex, "-"));
	}

	public static void findAndGroupMatchDemo() {
		StringBuilder sBuilder = new StringBuilder("<h1> TITLE </h1>");
		sBuilder.append("<h2> TITLE </h2>");
		sBuilder.append("<h2> TITLE </h2>");
		sBuilder.append("<h2> TITLE </h2>");
//		String h2Pattern = "(<h2>)(.+?)(</h2>)";
		String h2Pattern = "(<h2>.+?</h2>)";
		Pattern pattern = Pattern.compile(h2Pattern);
		Matcher matcher = pattern.matcher(sBuilder);
//		System.out.println(matcher.find());
		while (matcher.find()) {
			System.out.println(matcher.group(1));
		}

//		matcher.reset();
	}

	public static void quantifiersDemo() {
		String sampleString = "A quick brooown FFFooooxxx jumped ooooover the lazy dog.";
		System.out.println(sampleString.replaceAll("o{3}", "-"));
		System.out.println(sampleString.replaceAll("o{4,10}", "-"));
		System.out.println(sampleString.replaceAll("o{4}", "-"));
		System.out.println(sampleString.replaceAll("o*", "-"));
		System.out.println(sampleString.replaceAll("o+", "-"));
		System.out.println(sampleString.replaceAll("F+o+x+", "-"));

		StringBuilder sBuilder = new StringBuilder("<h1> TITLE </h1>");
		sBuilder.append("<h2> TITLE </h2>");

		String h2Pattern = "<h2>";
		Pattern pattern = Pattern.compile(h2Pattern);
		Matcher matcher = pattern.matcher(sBuilder);
		System.out.println(matcher.matches());

		String h2PatternBetter = ".*<h2>.*";
		Pattern pattern2 = Pattern.compile(h2PatternBetter);
		Matcher matcher2 = pattern2.matcher(sBuilder);
		System.out.println(matcher2.matches());
	}

	public static void characterAndBoundaryDemo() {
		String sampleString = "A quick brown Fox jumped over the lazy dog.";
		System.out.println(sampleString.replaceAll("[Ff]ox", "FOX"));
		// Negation
		System.out.println(sampleString.replaceAll("[^Ff]", "X"));
		// Character range
		System.out.println(sampleString.replaceAll("[a-f]", "X"));
		// Turn off case sensitivity
		System.out.println(sampleString.replaceAll("(?i)[a-f]", "X"));

		sampleString = "12345678909128385AFCDEF";
		System.out.println(sampleString.replaceAll("[0-9]", "X"));
		System.out.println(sampleString.replaceAll("\\d", "X"));
		System.out.println(sampleString.replaceAll("\\D", "X"));

		String spaceString = "space space space space space        \t\t\t spaceee\n\nspaceee";
		System.out.println(spaceString.replaceAll("\\s", ""));
		System.out.println(spaceString.replaceAll("\\S", ""));
		System.out.println(spaceString.replaceAll("[\t]", ""));

		sampleString = "12345678909128385AFCDEF";
		System.out.println(sampleString.replaceAll("\\w", "x"));
		System.out.println(spaceString.replaceAll("\\w", "x"));

		sampleString = "A quick brown Fox jumped over the lazy dog.";
		System.out.println(sampleString.replaceAll("\\b", "x"));

	}

	public static void simpleRegexDemo() {
		System.out.println("---------simple replace all by string literal----------");
		String str = "I am a string literal";
		String replacedStr = str.replaceAll("I am a", "You are");
		System.out.println(replacedStr);

		System.out.println("--------- replace all characters----------");

		String alphanum = "abcedeF123Gh99z";
		String newAlphanum = alphanum.replaceAll(".", "Y");
		System.out.println(newAlphanum);

		System.out.println("----------replace left boundary---------");

		String alphanum2 = "abcedeabcedeabcedeF123Gh99z";
		String boundaryMatcher = alphanum2.replaceAll("^abc", "XXX");
		System.out.println(boundaryMatcher);

		System.out.println("----------string matches test---------");

		System.out.println(alphanum2.matches("^Hello"));
		System.out.println(alphanum2.matches("^abc"));
		System.out.println(alphanum2.matches(alphanum2));

		System.out.println("----------replace right boundary---------");

		String alphanum3 = "abcedeabcedeabcedeF123Gh99z";
		boundaryMatcher = alphanum3.replaceAll("99z$", "XXX");
		System.out.println(boundaryMatcher);

		System.out.println("---------replace character occurences that is inside [   ]----------");

		String alphanum4 = "ab222cede222abced22eabcedeF123Gh99z";
		boundaryMatcher = alphanum4.replaceAll("[acde]", "X");
		System.out.println(boundaryMatcher);

		System.out.println("---------replace character occurences with multiple [] []---------");

		String alphanum5 = "aFcfdFeFcFFFFFFffff";
		boundaryMatcher = alphanum5.replaceAll("[acde][Ff]", "X");
		System.out.println(boundaryMatcher);
	}
}
