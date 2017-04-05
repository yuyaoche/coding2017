package com.lys.coding.week2.basic;

import java.util.Iterator;

public class LinkedList implements List{
	
	private Node head;
	
	public void add(Object o){
		if(head==null){
			head = new Node();
			head.data = o;
		}else{
			Node nodes = head;
			while(nodes.next!=null){
				nodes = nodes.next;
			}
			nodes.next = new Node();
			nodes.next.data = o;
		}
	}
	public void add(int index , Object o){
		int len =  size();
		if(len<index){
			throw new IndexOutOfBoundsException("Index: "+index+",Size:"+len);
		}
		if(index==0){
			Node node = new Node();
			node.data = o;
			node.next = head;
		}else{
			Node nodes = head;
			int i = 0; 
			while(i!=index){
				nodes.next = new Node();
				nodes.next.data = o;
				i++;
				nodes = nodes.next;
			}
			
		}
	}
	public Object get(int index){
		int len =  size();
		if(len<index){
			throw new IndexOutOfBoundsException("Index: "+index+",Size:"+len);
		}
		Node temp = head;
		for(int i=0;i<index;i++){
			temp=temp.next;
		}
		return temp.data;
	}
	public Object remove(int index){
		return null;
	}
	
	public int size(){
		int length = 0;
		Node temp = head;
		while(head.next!=null){
			length++;
			temp = temp.next ;
		}
		return length;
	}
	
	public void addFirst(Object o){
		
	}
	public void addLast(Object o){
		
	}
	public Object removeFirst(){
		return null;
	}
	public Object removeLast(){
		return null;
	}
	public Iterator iterator(){
		return null;
	}
	
	
	private static  class Node{
		Object data;
		Node next;
		
	}
	
	/**
	 * �Ѹ���������
	 * ��������Ϊ 3->7->10 , ���ú��Ϊ  10->7->3
	 */
	public  void reverse(){		
		
	}
	
	/**
	 * ɾ��һ���������ǰ�벿��
	 * ���磺list = 2->5->7->8 , ɾ���Ժ��ֵΪ 7->8
	 * ���list = 2->5->7->8->10 ,ɾ���Ժ��ֵΪ7,8,10
	 */
	public  void removeFirstHalf(){
		
	}
	
	/**
	 * �ӵ�i��Ԫ�ؿ�ʼ�� ɾ��length ��Ԫ�� �� ע��i��0��ʼ
	 * @param i
	 * @param length
	 */
	public  void remove(int i, int length){
		
	}
	/**
	 * �ٶ���ǰ�����listB���������������е�����
	 * �ӵ�ǰ������ȡ����ЩlistB��ָ����Ԫ��
	 * ���統ǰ���� = 11->101->201->301->401->501->601->701
	 * listB = 1->3->4->6
	 * ���صĽ��Ӧ����[101,301,401,601]  
	 * @param list
	 */
	public  int[] getElements(LinkedList list){
		return null;
	}
	
	/**
	 * ��֪�����е�Ԫ����ֵ�����������У����Ե��������洢�ṹ��
	 * �ӵ�ǰ��������ɾ����listB�г��ֵ�Ԫ�� 
	 * @param list
	 */
	
	public  void subtract(LinkedList list){
		
	}
	
	/**
	 * ��֪��ǰ�����е�Ԫ����ֵ�����������У����Ե��������洢�ṹ��
	 * ɾ����������ֵ��ͬ�Ķ���Ԫ�أ�ʹ�ò���������Ա�������Ԫ�ص�ֵ������ͬ��
	 */
	public  void removeDuplicateValues(){
		
	}
	
	/**
	 * ��֪�����е�Ԫ����ֵ�����������У����Ե��������洢�ṹ��
	 * ��дһ��Ч���㷨��ɾ����������ֵ����min��С��max��Ԫ�أ������д���������Ԫ�أ�
	 * @param min
	 * @param max
	 */
	public  void removeRange(int min, int max){
		
	}
	
	/**
	 * ���赱ǰ����Ͳ���listָ�����������Ԫ����ֵ�����������У�ͬһ���е�Ԫ��ֵ������ͬ��
	 * ��Ҫ������������C����Ԫ��Ϊ��ǰ�����list��Ԫ�صĽ������ұ�C�е�Ԫ������ֵ������������
	 * @param list
	 */
	public  LinkedList intersection( LinkedList list){
		return null;
	}
}
