package com.ecart.bbva.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class Test {

	public static void main(String[] args) {
		int n = 10;
		int[] arr = new int[n];
		Random r = new Random();
		IntStream.range(0, 10).forEach(i -> {
			arr[i] = r.nextInt(100);
		});
		System.out.println("Befor : "
				+ Arrays.toString(arr));

		shuffel(arr, r);

		System.out.println("After : "
				+ Arrays.toString(arr));

	}

	public static int[] shuffel(int[] arr, Random random) {
		int n = arr.length;
		Set<Integer> set = new HashSet<>();
		
		
		return arr;
	}
	
}
