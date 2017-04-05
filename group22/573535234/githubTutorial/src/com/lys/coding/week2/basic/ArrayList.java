package com.lys.coding.week2.basic;

import java.util.Arrays;

public class ArrayList implements List{
	
	private int size = 0;
	
	private Object[] elementData = new Object[100];
	
	@Override
	public void add(Object o) {
		//�ȼ�����������Ƿ����,������Ҫ����
		if(size>=elementData.length){
			int newLength = elementData.length*3/2+1;
			Arrays.copyOf(elementData, newLength);
		}
		//������������������
		elementData[size+1]=o;
		//��������size��һ
		size++;
	}

	@Override
	public void add(int index, Object o) {
		//�ȼ�����������Ƿ����,������Ҫ����
		if(size>=elementData.length){
			int newLength = elementData.length*3/2+1;
			Arrays.copyOf(elementData, newLength);
		}
		if(index!=size-1){
			//�ѵ�ǰ����index�������������Ų
			System.arraycopy(elementData, index, elementData, index+1, size-index);
		}
		//��indexλ�÷�
		elementData[index]=o;
		//��������size��һ
		size++;
	}

	@Override
	public Object get(int index) {
		//���index�Ƿ�Ƿ�
		if(index>=size){
			throw new IndexOutOfBoundsException("Index: "+index+",Size:"+size);
		}else if(index<0){
			throw new IllegalArgumentException("Index: "+index+",<0!");
		}
		return elementData[index];
	}

	@Override
	public Object remove(int index) {
		Object o = elementData[index];
		//���index�Ƿ�Ƿ�
		if(index>=size){
			throw new IndexOutOfBoundsException("Index: "+index+",Size:"+size);
		}else if(index<0){
			throw new IllegalArgumentException("Index: "+index+",<0!");
		}
		if(size!=index+1){
			//�ѵ�ǰindex�����������ǰŲ
			System.arraycopy(elementData, index+1, elementData, index, size-index-1);
		}
		elementData[size]=null;
		//��������size��һ
		size--;
		return o;
	}

	@Override
	public int size() {
		return size;
	}
	
}
