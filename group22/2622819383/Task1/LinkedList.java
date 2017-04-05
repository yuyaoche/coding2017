//����ο��ԡ����ݽṹ���㷨������
public class LinkedList implements List {
	
    private Node header;
    
    private Node trailer;
    
    private int theSize;
    
    public LinkedList() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.succ = trailer;
        theSize = 0;
    }
    
    public void add(Object o) {
        add(size(), o);
    }

    public void add(int index , Object o) {
        if (index < 0 || theSize < index) throw new IndexOutOfBoundsException();

        Node p = header;
        while (0 < index--) p = p.succ();
        p.insertAsSucc(o);
        theSize++;        
    }

    public Object get(int index) {
        if (index < 0 || theSize <= index) throw new IndexOutOfBoundsException();

        Node p = header.succ();
        while (0 < index--) p = p.succ();
        return p.data();
    }

    public Object remove(int index) {
        if (0 < index || theSize <= index) throw new IndexOutOfBoundsException();

        Node p = header.succ();
        while (0 < index--) p = p.succ();
        Object removed = p.data();
        p.pred().succ = p.succ();
        p.succ().pred = p.pred();
        theSize--;
        return removed;
    }

    public int size() {
        return theSize;
    }

    public void addFirst(Object o) {
        header.insertAsSucc(o);
    }

    public void addLast(Object o) {
        trailer.insertAsPred(o);
    }

    public Object removeFirst() {
        return remove(0);
    }

    public Object removeLast() {
        return remove(theSize - 1);
    }

    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {
        private Node current = header.succ();

        public boolean hasNext() {
            return current != trailer;
        }

        public Object next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            Object item = current.data();
            current = current.succ();
            return item;
        }
    }

    private static class Node {
        //pred��succ�������ԣ�pred()��succ()����Node�ڵ�
        private Object data;
        private Node pred;
        private Node succ;

        public Node(Object d, Node p, Node s) {
            data = d;
            pred = p;
            succ = s;
        }

        public Object data() { 
            return data; 
        }

        public Node succ() { 
            return succ; 
        }

        public Node pred() { 
            return pred; 
        }

        //����ǰ���ڵ㣬���ز�����½ڵ�
        public Node insertAsPred(Object data) {
            Node p = new Node(data, pred, this);
            pred = pred().succ = p;
            return p;
        }

        //�����̽ڵ㣬���ز�����½ڵ�
        public Node insertAsSucc(Object data) {
            Node p = new Node(data, this, succ);
            succ = succ().pred = p;
            return p;
        }                           
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
    * �ٶ���ǰ�����list���������������е�����
    * �ӵ�ǰ������ȡ����Щlist��ָ����Ԫ��
    * ���統ǰ���� = 11->101->201->301->401->501->601->701
    * listB = 1->3->4->6
    * ���صĽ��Ӧ����[101,301,401,601]  
    * @param list
    */
    public static int[] getElements(LinkedList list){
        return null;
    }

    /**
    * ��֪�����е�Ԫ����ֵ�����������У����Ե��������洢�ṹ��
    * �ӵ�ǰ��������ɾ����list�г��ֵ�Ԫ�� 

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
