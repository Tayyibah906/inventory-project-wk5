package com.qa.connecting.utils;

import java.util.Scanner;

public class Input {

	public Input() {
		
	}

	private static Scanner scan = new Scanner(System.in);

	public String getInput() {
		return scan.nextLine();
	}

	public int getInt() {
		int value;
		while (true) {
			try {
				value = Integer.parseInt(scan.nextLine());
				return value;
			} catch (NumberFormatException exception) {
				exception.printStackTrace();
			}
		}
	}

	public double getDouble() {
		Double value;
		while (true) {
			try {
				value = Double.parseDouble(scan.nextLine());
				return value;
			} catch (NumberFormatException exception) {
				exception.printStackTrace();
			}
		}
	}
		
}
