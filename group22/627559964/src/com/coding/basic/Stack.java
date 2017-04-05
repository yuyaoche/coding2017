package com.coding.basic;

/**
 * �Զ���stack
 * 
 * @author xiongrui233
 *
 */
public class Stack {
	
	//Ԫ�ؼ���
	private ArrayList elementData = new ArrayList();

	/**
	 * ��ջ��ѹ��Ԫ��
	 * @param o
	 */
	public void push(Object o) {
		elementData.add(0,o);
	}

	/**
	 * ���ջ��Ԫ��,���Ƴ�ջ���Ԫ��
	 * @return obj
	 */
	public Object pop() {
		Object obj = elementData.get(0);
		elementData.remove(0);
		return obj;
	}

	/**
	 * ���ջ��Ԫ��,���Ƴ�ջ���Ԫ��
	 * @return obj
	 */
	public Object peek() {
		return elementData.get(0);
	}

	/**
	 * �жϸ�ջ�Ƿ�Ϊ��
	 * @return true/false
	 */
	public boolean isEmpty() {
		if (elementData.size() != 0) {
			return false;
		}
		return true;
	}

	/**
	 * ���ջ�Ĵ�С
	 * @return size
	 */
	public int size() {
		return elementData.size();
	}
}