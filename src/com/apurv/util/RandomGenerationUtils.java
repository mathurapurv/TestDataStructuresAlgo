package com.apurv.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Utility class to generate random data
 * 
 * @author apurv
 * 
 */
public class RandomGenerationUtils {

	private static final Random random = new Random();
	private static int[] asciiComplete = { 65, 66, 67, 68, 69, 70, 71, 72, 73,
			74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
			97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110,
			111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49,
			50, 51, 52, 53, 54, 55, 56, 57 };
	private static int[] asciiChar = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74,
			75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97,
			98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111,
			112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };

	/**
	 * return a random long with specified number of digit.
	 * 
	 * @param numberOfDigits
	 * @return
	 */
	public static long randomLong(int numberOfDigits) {
		return (long) (random.nextDouble() * Math.pow(10, numberOfDigits));
	}

	/**
	 * return a random long number between 2 limits
	 * lower limit inclusive , upper limit exclusive
	 * 
	 * @param lowerLimit
	 * @param upperLimit
	 * @return
	 */
	public static long randomLongBetweenLimits(long lowerLimit, long upperLimit) {
		return lowerLimit
				+ (long) (random.nextDouble() * (upperLimit - lowerLimit));
	}

	/**
	 * digits : 48 - 57 uppercase alphabats : 65-90 lowercase alphabats : 97-122
	 * 
	 * @param length
	 * @param digitsAllowed
	 * @return
	 */
	public static String randomString(int length, boolean digitsAllowed) {
		StringBuilder sb = new StringBuilder(length);
		int[] baseArray = null;
		if (digitsAllowed) {
			baseArray = asciiComplete;
		} else {
			baseArray = asciiChar;
		}
		int len = baseArray.length;

		for (int i = 0; i < length; i++) {
			sb.append((char) baseArray[random.nextInt(len)]);
		}
		return sb.toString();

	}

	/**
	 * @return - returns a random date sometime between year 1900 and a year
	 *         prior to present
	 */
	public static Date randomDate() {
		int presentYear = Calendar.getInstance().get(Calendar.YEAR) - 1;
		Calendar cal = Calendar.getInstance();
		cal
				.set(Calendar.YEAR, (int) randomLongBetweenLimits(1900,
						presentYear));
		cal.set(Calendar.MONTH, random.nextInt(13));
		cal.set(Calendar.DATE, 1 + random.nextInt(20));
		cal.set(Calendar.HOUR_OF_DAY, 1 + random.nextInt(20));
		cal.set(Calendar.MINUTE, 1 + random.nextInt(40));
		cal.set(Calendar.SECOND, 1 + random.nextInt(40));
		return cal.getTime();
	}

	/**
	 * returns an random instance from array of objects
	 * 
	 * @param dataArr
	 */
	public static Object randomObjectArrayElement(Object dataArr[]) {
		if (dataArr == null) {
			return null;
		} else {
			return dataArr[random.nextInt(dataArr.length)];
		}
	}
	
	
	/**
	 * returns random boolean value 
	 */
	public static boolean randomBooleanValue(){
		return random.nextBoolean();
	}
	
	
	
	

	public static void main(String args[]) {
		String[] dataArr = { "a", "s", "d" };
		System.out.println(randomObjectArrayElement(dataArr));
	}

}
