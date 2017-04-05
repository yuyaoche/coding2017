//����ο��ԡ����ݽṹ���㷨������
public class BinaryTreeNode {
	
    private Object data;    
    private BinaryTreeNode left;
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
    
    private BinaryTreeNode parrent;
    private BinaryTreeNode hot;  //��ʾsearch(Object o)�������ص����нڵ�ĸ���
    
    public BinaryTreeNode(Object o, BinaryTreeNode p) {
        data = o;
        parrent = p;
    }
    //����vΪ���Ķ������в��ҹؼ���o���������еĽڵ㣨��ʵ���ڵû���������ڵģ�
    public static BinaryTreeNode search(BinaryTreeNode v, Object o, BinaryTreeNode hot) {
        int vData = (int)v.getData();
        int searched = (int)o;
        if (v == null || vData == searched) return v; 
        
        hot = v;
        return search(searched < vData ? v.getLeft() : v.getRight(), o, hot);
    }    

    public BinaryTreeNode insert(Object o){
        BinaryTreeNode node = search(this, o, this.parrent);
        if (node != null) return node;
        
        node = new BinaryTreeNode(o, hot);
        if ((int)o < (int)hot.getData()) hot.setLeft(node);
        else hot.setRight(node);
        return node;
    }

}
