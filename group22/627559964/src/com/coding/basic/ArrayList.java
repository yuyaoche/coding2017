package com.coding.basic;

import java.util.Arrays;

/**
 * �Զ���ArrayList
 * 
 * @author xiongrui233
 *
 */
public class ArrayList implements List {

	// list����
	private int size = 0;

	// list��Ԫ�ؼ���
	private Object[] elementData = new Object[10];

	/**
	 * �ϲ�����
	 * 
	 * @param arrays1
	 * @param arrays2
	 * @return Object[]
	 */
	private Object[] concat(Object[] arrays1, Object[] arrays2) {
		Object[] newArrays = new Object[arrays1.length + arrays2.length];
		System.arraycopy(arrays1, 0, newArrays, 0, arrays1.length);
		System.arraycopy(arrays2, 0, newArrays, arrays1.length, arrays2.length);
		return newArrays;
	}

	/**
	 * �ָ�����
	 * 
	 * @param arrays
	 * @param from
	 * @param index
	 * @return Object[]
	 */
	private Object[] subArrays(Object[] arrays, int from, int index) {
		Object[] tempArrays = new Object[index - from];
		for (int i = from, j = 0; i < index; i++, j++) {
			tempArrays[j] = arrays[i];
		}
		return tempArrays;
	}

	/**
	 * ��̬����list����
	 * ����Ϊ:newSize = oldSize * 1.5
	 * 
	 * @param oldSize
	 */
	private void grow(int oldSize) {
		elementData = Arrays.copyOf(elementData, oldSize + oldSize / 2);
	}

	/**
	 * ����ڲ�����Ԫ��ʱ,list�����Ƿ��㹻
	 * 
	 * @param newSize
	 */
	private void checkSize(int newSize) {
		int oldSize = elementData.length;
		if (newSize > oldSize) {
			grow(oldSize);
		}
	}

	/**
	 * ����Ԫ��
	 * 
	 * @param Object
	 */
	public void add(Object o) {
		checkSize(size + 1);
		elementData[size++] = o;
	}

	/**
	 * ����Ԫ��
	 * 
	 * @param index
	 * @param Object
	 */
	public void add(int index, Object o) {
		checkSize(size + 1);
		Object[] arrays1 = subArrays(elementData, 0, index);
		Object[] arrays2 = subArrays(elementData, index, elementData.length);

		arrays1 = Arrays.copyOf(arrays1, arrays1.length + 1);
		arrays1[index] = o;
		size++;
		elementData = concat(arrays1, arrays2);
	}

	/**
	 * ��ñ��Ϊindex��Ԫ��
	 * 
	 * @param int
	 * @return Object
	 */
	public Object get(int index) {
		return elementData[index];
	}

	/**
	 * ɾ�����Ϊindex��Ԫ��
	 * 
	 * @param int
	 * @return Object
	 */
	public Object remove(int index) {
		Object[] arrays1 = subArrays(elementData, 0, index);
		Object[] arrays2 = subArrays(elementData, index + 1, elementData.length);
		Object obj = elementData[index];

		size--;
		elementData = concat(arrays1, arrays2);
		return obj;
	}

	/**
	 * ����list����
	 * 
	 * @return int
	 */
	public int size() {
		return size;
	}

	/**
	 * ��д������
	 *
	 * @return IteratorImpl
	 */
	public Iterator iterator() {

		class IteratorImpl implements Iterator {

			private int point = 0;

			@Override
			public boolean hasNext() {
				if (elementData[point] != null) {
					return true;
				}
				return false;
			}

			@Override
			public Object next() {
				return elementData[point++];
			}

		}
		return new IteratorImpl();
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(elementData, size));
	}
}