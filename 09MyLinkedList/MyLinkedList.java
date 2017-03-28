public class MyLinkedList{
    private LNode start;
    private LNode end;
    private int size;

    public MyLinkedList(){
	size=0;
    }

    public int size(){
	return size;
    }

    public void add(LNode node){
	size++;
	node.next = start;
	start = node;
    }

    public String toString(){
	String str="";
	LNode here = start;
	for(int x=0; x<this.size(); x++){
	    str+=here.value();
	    here=here.next();
	}
	return str;
    }

    public class LNode{
	private int value;
	private LNode next;

	public LNode(int quantity, LNode nextNode){
	    value=quantity;
	    nextNode=null;
	}
	
	public int value(){
	    return value;
	}
	
	public LNode next(){
	    return next;
	}
    }

    public static void main(String[]args){
	MyLinkedList test = new MyLinkedList();
	MyLinkedList.LNode e = test.new LNode(5,null);
	MyLinkedList.LNode d = test.new LNode(4,null);
	MyLinkedList.LNode c = test.new LNode(3,null);
	MyLinkedList.LNode b = test.new LNode(2,null);
	MyLinkedList.LNode a = test.new LNode(1,null);

	test.add(e);
	test.add(d);
	test.add(c);
	test.add(b);
	test.add(a);

	System.out.println(test.toString());

	
	
        
    }

}
    
