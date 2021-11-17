package com.practice.fundamentals;

public class ArtChallenges {
	public static void printSquareStar(int number) {
		if (number < 5) {
			System.out.println("Invalid Value");
			return;
		}
		for (int i = 1; i <= number; i++) {
			for (int j = 1; j <= number; j++) {
				// Top border
				if (i == 1) {
					System.out.print('*');
				}
				// Side border
				else if (j == 1 || j == number) {
					System.out.print('*');
				}

				// Bottom border
				else if (i == number) {
					System.out.print('*');
				}

				// First diagonal
				else if (j == i) {
					System.out.print('*');
				}

				// Second diagonal
				else if (number - i + 1 == j) {
					System.out.print('*');
				}

				else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}
}
