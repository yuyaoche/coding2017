package com.coding.basic;

/**
 * �Զ��������
 * 
 * @author xiongrui233
 *
 */
public class BinaryTreeNode {

	//�ڵ�ֵ
	private Object data;
	//������
	private BinaryTreeNode left;
	//������
	private BinaryTreeNode right;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	/**
	 * ����Ԫ��
	 * @param o
	 * @return BinaryTreeNode
	 */
	public BinaryTreeNode insert(Object o) {
		BinaryTreeNode node = null;
		if (this.data == null) {
			this.data = o;
			node =  this;
		} else {
			if (this.left.data == null) {
				this.left.data = o;
				node = this.left;
			}
			if (this.right.data == null) {
				this.right.data = o;
				node = this.right;
			}
		}
		return node;
	}

}