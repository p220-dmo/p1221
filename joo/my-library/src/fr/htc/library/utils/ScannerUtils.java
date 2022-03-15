package fr.htc.library.utils;

import java.util.Scanner;

public class ScannerUtils {

	private static Scanner uniqueInstance;

	private ScannerUtils() {
	}

	public static Scanner getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Scanner(System.in);
		}
		return uniqueInstance;
	}

}
