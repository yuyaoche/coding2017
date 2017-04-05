package com.coding.basic;

/**
 * �Զ���LinkList
 * 
 * @author xiongrui233
 *
 */
public class LinkedList implements List {

	/**
	 * ��������ڵ�ṹ
	 * 
	 * @author xiongrui233
	 *
	 */
	private static class Node {
		Object data;
		Node next;
	}

	// ����ڵ�
	private Node head = new Node();

	private int size = 0;
	
	public LinkedList() {
		head.next = head;
	}

	/**
	 * ���Ԫ��
	 * 
	 * @param o
	 */
	public void add(Object o) {
		addLast(o);
	}

	/**
	 * ���Ԫ��
	 * 
	 * @param index
	 * @param o
	 */
	public void add(int index, Object o) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Node node = head;
		Node temp = new Node();
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		temp.data = o;
		if (index == size -1) {
			node.next = temp;
			temp.next = head;
		} else {
			temp.next = node.next;
			node.next = temp;
		}
		size ++;
	}

	/**
	 * ��ȡԪ��
	 * 
	 * @param index
	 */
	public Object get(int index) {
		Node node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		return node.data;
	}

	/**
	 * ɾ��Ԫ��
	 * 
	 * @param index
	 */
	public Object remove(int index) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Node node = head;
		Node temp = new Node();
		for (int i = 0; i <= index - 1; i++) {
			node = node.next;
		}
		if (index == size -1) {
			temp = node.next;
			node.next = head;
		} else {
			temp = node.next;
			node.next = node.next.next;
		}
		size --;
		return temp.data;
	}

	/**
	 * ����LinkedList�Ĵ�С
	 * 
	 * @return size
	 */
	public int size() {
		return size;
	}

	/**
	 * ��LinkedList��һ��λ�����Ԫ��
	 * 
	 * @param o
	 */
	public void addFirst(Object o) {
		add(0, o);
	}

	/**
	 * ��LinkedList������Ԫ��
	 * @param o
	 */
	public void addLast(Object o) {
		Node node = head;
		Node temp = new Node();
		for (int i = 0; i < size; i++) {
			node = node.next;
		}
		temp.data = o;
		node.next = temp;
		size ++;
	}

	/**
	 * �Ƴ������һλԪ��
	 * 
	 * @return obj
	 */
	public Object removeFirst() {
		return remove(0);
	}

	/**
	 * �Ƴ��������һλԪ��
	 * 
	 * @return obj
	 */
	public Object removeLast() {
		return remove(size - 1);
	}

	/**
	 * ʵ��Iterator�ӿ�
	 * 
	 * @return Iterator
	 */
	public Iterator iterator() {
		
		class IteratorImpl implements Iterator {

			private Node node = head.next;
			
			private Object temp = null;
			
			@Override
			public boolean hasNext() {
				if (node != null && node.data != null) {
					temp = node.data;
					node = node.next;
					return true;
				}
				return false;
			}

			@Override
			public Object next() {
				return temp;
			}
			
		}
		return new IteratorImpl();
	}

	/**
	 * �Ѹ��������� ��������Ϊ 3->7->10 , ���ú��Ϊ 10->7->3
	 */
	public LinkedList reverse() {
		LinkedList lis = new LinkedList();
		for (int i = this.size - 1; i >= 0; i--) {
			lis.add(this.get(i));
		}
		return lis;
	}

	/**
	 * ɾ��һ���������ǰ�벿�� ���磺list = 2->5->7->8 , ɾ���Ժ��ֵΪ 7->8 ���list = 2->5->7->8->10
	 * ,ɾ���Ժ��ֵΪ7,8,10
	 */
	public void removeFirstHalf() {
		int mid = size/2;
		for (int i = 0; i < mid; i++) {
			remove(0);
		}
	}

	/**
	 * �ӵ�i��Ԫ�ؿ�ʼ�� ɾ��length ��Ԫ�� �� ע��i��0��ʼ
	 * 
	 * @param i
	 * @param length
	 */
	public void remove(int i, int length) {
		if (i > length) {
			throw new IllegalArgumentException();
		}
		if (i < 0 || i > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		for (int j = i; j <= length; j++) {
			remove(i);
		}
	}

	/**
	 * �ٶ���ǰ�����list���������������е����� �ӵ�ǰ������ȡ����Щlist��ָ����Ԫ�� ���統ǰ���� =
	 * 11->101->201->301->401->501->601->701 listB = 1->3->4->6
	 * ���صĽ��Ӧ����[101,301,401,601]
	 * 
	 * @param list
	 */
	public int[] getElements(LinkedList list) {
		if (this.size < (Integer)list.get(list.size - 1)) {
			throw new IllegalArgumentException();
		}
		int[] elements = new int[list.size];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = (Integer) this.get((Integer)list.get(i));
		}
		return elements;
	}

	/**
	 * ��֪�����е�Ԫ����ֵ�����������У����Ե��������洢�ṹ�� �ӵ�ǰ��������ɾ����list�г��ֵ�Ԫ��
	 * 
	 * @param list
	 */

	public void subtract(LinkedList list) {
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			for (int i = 0; i < this.size; i++) {
				if (obj.equals(this.get(i))) {
					this.remove(i);
				}
			}
		}
	}

	/**
	 * ��֪��ǰ�����е�Ԫ����ֵ�����������У����Ե��������洢�ṹ�� ɾ����������ֵ��ͬ�Ķ���Ԫ�أ�ʹ�ò���������Ա�������Ԫ�ص�ֵ������ͬ��
	 */
	public void removeDuplicateValues() {
		for (int i = 0; i < this.size; i++) {
			if (i + 1 >= this.size) {
				return;
			}
			if (this.get(i).equals(this.get(i+1))) {
				remove(i+1);
				i--;
			}
		}
	}

	/**
	 * ��֪�����е�Ԫ����ֵ�����������У����Ե��������洢�ṹ�� ��дһ��Ч���㷨��ɾ����������ֵ����min��С��max��Ԫ�أ������д���������Ԫ�أ�
	 * 
	 * @param min
	 * @param max
	 */
	public void removeRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < this.size; i++) {
			if ((Integer)this.get(i) > max) {
				remove(i, this.size-1);
			}
		}
	}

	/**
	 * ���赱ǰ����Ͳ���listָ�����������Ԫ����ֵ�����������У�ͬһ���е�Ԫ��ֵ������ͬ��
	 * ��Ҫ������������C����Ԫ��Ϊ��ǰ�����list��Ԫ�صĽ������ұ�C�е�Ԫ������ֵ������������
	 * TODO
	 * @param list
	 */
	public LinkedList intersection(LinkedList list) {
		return null;
	}

	@Override
	public String toString() {
		StringBuffer list = new StringBuffer();
		list.append("List:[");
		Node node = head.next;
		for (int i = 0; i < size; i++) {
			list.append(node.data);
			node = node.next;
			if (i != size -1) {
				list.append(", ");
			}
		}
		list.append("]");
		return list.toString();
	}
}