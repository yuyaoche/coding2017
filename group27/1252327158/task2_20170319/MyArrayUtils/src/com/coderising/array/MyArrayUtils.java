package com.coderising.array;

import java.util.ArrayList;
import java.util.List;

public class MyArrayUtils {
	/**
	 * ����һ����������a , �Ը������ֵ�����û�
		���磺 a = [7, 9 , 30, 3]  ,   �û���Ϊ [3, 30, 9,7]
		���     a = [7, 9, 30, 3, 4] , �û���Ϊ [4,3, 30 , 9,7]
	 * @param origin
	 * @return
	 */
	public static void reverseArray(int[] origin){
		if (origin == null) {
			return;
		}
		int temp = 0;
		for (int i = 0; i < origin.length/2; i++) {
			temp = origin[i];
			origin[i] = origin[origin.length - 1 - i];
			origin[origin.length - 1 - i] = temp;
		}
	}
	
	/**
	 * ���������µ�һ�����飺   int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}   
	 * Ҫ������������ֵΪ0����ȥ��������Ϊ0��ֵ����һ���µ����飬���ɵ�������Ϊ��   
	 * {1,3,4,5,6,6,5,4,7,6,7,5}  
	 * @param oldArray
	 * @return
	 */
	
	public static int[] removeZero(int[] oldArray){
		if (oldArray == null) {
			return null;
		}
		int notZeroLength = oldArray.length;
		for (int element : oldArray) {
			if (element == 0) {
				notZeroLength--;
			}
		}
		if (notZeroLength == 0) {
			return new int[0];
		}
		int[] newArray = new int[notZeroLength];
		for (int i = 0,index = 0; i < oldArray.length; i++) {
			if (oldArray[i] != 0) {
				newArray[index++] = oldArray[i];
			}
		}
		return newArray;
	}
	
	/**
	 * ���������Ѿ�����õ��������飬 a1��a2 ,  ����һ���µ�����a3, ʹ��a3 ����a1��a2 ������Ԫ�أ� ������Ȼ�������
	 * ���� a1 = [3, 5, 7,8]   a2 = [4, 5, 6,7]    �� a3 Ϊ[3,4,5,6,7,8]    , ע�⣺ �Ѿ��������ظ�
	 * @param array1
	 * @param array2
	 * @return
	 */
	
	public static int[] merge(int[] array1, int[] array2){
		if (array1 == null && array2 == null) {
			return  null;
		}
		int[] newArray;
		if (array1 == null) {
			newArray = new int[array2.length];
			System.arraycopy(array2, 0, newArray, 0, array2.length);
			return newArray;
		}
		if (array2 == null) {
			newArray = new int[array1.length];
			System.arraycopy(array1, 0, newArray, 0, array1.length);
			return newArray;
		}
		newArray = new int[array1.length + array2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		for (; i < array1.length && j < array2.length;) {
			if (array1[i] < array2[j]) {
				newArray[k++] = array1[i++];				
			} else if (array1[i] == array2[j]) {
				newArray[k++] = array1[i++];
				j++;
			} else {
				newArray[k++] = array2[j++];
			}
		}
		if (i == array1.length) {
			System.arraycopy(array2, j, newArray, k, array2.length - j);
			k += array2.length - j;
		}
		if (j == array2.length) {
			System.arraycopy(array1, i, newArray, k, array1.length - i);
			k += array1.length - i;
		}
		int[] results = new int[k];
		System.arraycopy(newArray, 0, results, 0, k);
		return  results;
	}
	/**
	 * ��һ���Ѿ��������ݵ����� oldArray������������չ�� ��չ��������ݴ�СΪoldArray.length + size
	 * ע�⣬�������Ԫ��������������Ҫ����
	 * ���� oldArray = [2,3,6] , size = 3,�򷵻ص�������Ϊ
	 * [2,3,6,0,0,0]
	 * @param oldArray
	 * @param size
	 * @return
	 */
	public static int[] grow(int [] oldArray,  int size){
		if (size <= 0 || oldArray == null) {
			return oldArray;
		}
		int[] newArray = new int[oldArray.length + size];
		System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
		return newArray;
	}
	
	/**
	 * 쳲���������Ϊ��1��1��2��3��5��8��13��21......  ������һ�����ֵ�� ����С�ڸ�ֵ������
	 * ���磬 max = 15 , �򷵻ص�����Ӧ��Ϊ [1��1��2��3��5��8��13]
	 * max = 1, �򷵻ؿ����� []
	 * @param max
	 * @return
	 */
	public static int[] fibonacci(int max){
		if (max <= 1) {
			return new int[0];
		}
		
		List<Integer> list = new ArrayList<Integer>();
		int temp = 0;
		for (int i = 0; ; i++) {			
			if ((temp = getfibonacci(i + 1)) < max) {
				list.add(temp);
			} else {
				break;
			}
		}
		
		return List2Array(list);
	}
	
	private static int getfibonacci(int i){
		if (i <= 2) {
			return 1;
		}
		return getfibonacci(i-2) + getfibonacci(i-1);
	}
	
	/**
	 * ����С�ڸ������ֵmax��������������
	 * ����max = 23, ���ص�����Ϊ[2,3,5,7,11,13,17,19]
	 * @param max
	 * @return
	 */
	public static int[] getPrimes(int max){
		if (max <= 2) {
			return new int[0];
		}
		List<Integer> primeList = new ArrayList<Integer>();
		primeList.add(2);
		for (int i = 3; i < max; i += 2) {
			int j;
			for (j = 2; j <= Math.ceil(Math.sqrt(i)); j++) {
				if (i % j == 0) {				
					break;
				}
			}
			if (j == Math.ceil(Math.sqrt(i)) + 1) {
				primeList.add(i);
			}
		}
		
		return List2Array(primeList);
	}
	
	private static int[] List2Array(List<Integer> list) {
		int[] results = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			results[i] = list.get(i);
		}
		return results;
	}
	
	/**
	 * ��ν���������� ��ָ�����ǡ�õ�����������֮�ͣ�����6=1+2+3
	 * ����һ�����ֵmax�� ����һ�����飬 ��������С��max ����������
	 * @param max
	 * @return
	 */
	public static int[] getPerfectNumbers(int max){
		if (max < 2) {
			return new int[0];
		}
		List<Integer> PerfectList = new ArrayList<Integer>();
		for (int i = 1; i < max; i++) {
			int factorSum = 0;
			int j;
			for ( j= 1; j < i; j++) {
				if (i % j == 0) {
					factorSum += j;
				}
				if (factorSum > i) {
					break;
				}
			}
			if (j == i && factorSum == i) {
				PerfectList.add(i);
			}
		}
		
		return List2Array(PerfectList);
	}
	
	/**
	 * ��seperator ������ array����������
	 * ����array= [3,8,9], seperator = "-"
	 * �򷵻�ֵΪ"3-8-9"
	 * @param array
	 * @param seperator
	 * @return
	 */
	public static String join(int[] array, String seperator){
		if (array == null || array.length < 1) {
			return "";
		}

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(array[0]);
		for (int i = 1; i < array.length; i++) {
			stringBuilder.append(seperator).append(array[i]);
		}
		return stringBuilder.toString();
	}
}
