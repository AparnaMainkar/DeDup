package com.myorg.utilities;
import java.util.Arrays;

import java.util.LinkedHashSet;

import java.util.Set;

import java.util.TreeSet;

public class DeDup {

	public int[] randomIntegers =

		{1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,

			20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,

			13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};

	//Removes duplicate using collection API . Maintains the insertion order. Best way to remove the duplicated

	public int[] removeDuplicates(int[] dupArr) {

		Set<Integer> set = new LinkedHashSet<Integer>();

		int[] deDupArr = new int[dupArr.length];

		int i = 0;

		for (int j : dupArr) {

			if (set.add(j)) {

				deDupArr[i++] = j;

			}

		}

		deDupArr = Arrays.copyOf(deDupArr, i);

		set.clear();

		System.out.println("Unique value Array: Order maintained is insertion:"+Arrays.toString(deDupArr));

		return deDupArr;

	}

	//Removes duplicates from the array. It does not make use of the Collection API.

	public int[] removeDuplicatesFromArray(int[] dupArr) {

		int deDupArr[] = new int[dupArr.length];

		int j=0;

		boolean flag = false;

		for (int i : dupArr) {

			for (int k : deDupArr) {

				if(k == i) {

					flag = true;

					break;

				}

				else

					flag = false;

			}

			if(!flag) {

				deDupArr[j++] = i;

			}

		}

		deDupArr = Arrays.copyOf(deDupArr, j);

		System.out.println("Unique value Array: Order maintained is insertion:"+Arrays.toString(deDupArr));

		return deDupArr;

	}

	//Removes the duplicates from the Array. Best way if order needs to be sorted/ ascending.

	public int[] removeDuplicatesInAscendingOrder(int[] dupArr) {

		Set<Integer> set = new TreeSet<Integer>();

		for(int i : dupArr) {

			set.add(i);

		}

		int[] deDupArr = new int[set.size()];

		int j = 0;

		for (Integer k : set) {

			deDupArr[j++] = k;

		}

		set.clear();

		System.out.println("Unique value Array: Order maintained is insertion:"+Arrays.toString(deDupArr));

		return deDupArr;

	}



	public static void main(String[] args) {

		DeDup obj = new DeDup();

		try {

			obj.removeDuplicates(obj.randomIntegers);

			obj.removeDuplicatesFromArray(obj.randomIntegers);

			obj.removeDuplicatesInAscendingOrder(obj.randomIntegers);

		}

		catch(Exception e) {

			System.out.println("Array initialization problems. Initialize the array.");

			throw e;

		}

	}

}