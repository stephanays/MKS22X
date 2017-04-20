import java.util.*;
public class MyLinkedList implements Iterable<Integer>{
    private LNode head;
    private LNode tail;
    private int size;

    private class LNode{
	private int value;
	private LNode next;
	private LNode prev;

	public LNode(int quantity){
	    value=quantity;
	}
	
	public LNode(int quantity, LNode nextOne){
	    value=quantity;
	    next=nextOne;
	}
	
        public String toString(){
	    return value+" ";
	}
    }

    public MyLinkedList(){
    }

    public Iterator<Integer> iterator(){
	return new MLLI(this);
    }
    
    public int size(){
	return size;
    }
    
    private LNode getNthNode(int index){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}else{
	    LNode here=head;
	    for(int x=0; x<index; x++){
		here = here.next;
	    }
	    return here;
	}
    }
    
    private void addAfter(LNode location, LNode toBeAdded){
	location.next.prev = toBeAdded;
	toBeAdded.next = location.next;
	location.next = toBeAdded;
	toBeAdded.prev = location;
	size++;
    }
    
    private void remove(LNode target){
	if(target == head){
	    head = target.next;
	}else if(target == tail){
	    tail = target.prev;
	}else{
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	}
    }

    public int remove(int index){
	LNode here = getNthNode(index);
	int old = here.value;
	remove(here);
	size--;
	return old;
    }
    
    public String toString(){
	LNode here=head;
	String newstr="[";
	for(int x=0; x<size; x++){
	    if(x==0){
		newstr+=here.value+"("+here.next.value+"),";
	    }else{
		if(x==(size-1)){
		    newstr+="("+here.prev.value+")"+here.value+"]";
		}else{
		    newstr+="("+here.prev.value+")"+here.value+"("+here.next.value+"),";
		}
	    }
	    here=here.next;
	}
	return newstr;       
    }

    public int get(int index){
        return getNthNode(index).value;
    }
    
    public int set(int index, int value){
	LNode here = getNthNode(index);
	int old = here.value;
	here.value = value;
	return old;
    }
    
    public int indexOf(int value){
	int index=0;
	LNode here=head;
	for(int x=0; x<size; x++){
	    if(here.value==value){
		return index;
	    }
	    index++;
	}
	return -1;
    }

    public boolean add(int value){
	LNode addition = new LNode(value);
	if(size == 0){
	    head = addition;
	}else if(size == 1){
	    head.next = addition;
	    addition.prev = head;
	    tail = addition;
	}else{
	    tail.next = addition;
	    addition.prev = tail;
	    tail = addition;
	}
	size++;
	return true;
    }
    
    public void add(int index, int value){
	LNode addition = new LNode(value);
	LNode location = getNthNode(index-1);
	addAfter(location,addition);	
	
	
    }
    public static void main(String[]args){
	MyLinkedList test=new MyLinkedList();
	for(int x=0; x<10; x++){
	    test.add(x);
	}
	System.out.println(test);
	// test.remove(7);
	// System.out.println(test);
	// test.add(7,100);
	// System.out.println(test);
	// test.add(1234556789);
	// System.out.println(test);
	// test.set(3,987654321);
	// System.out.println(test);

	Iterator a = test.iterator();
	while(a.hasNext()){
	    System.out.println(a.next());
	}
    }

    public class MLLI implements Iterator<Integer>{
	private MyLinkedList list;
	private int x;

	public MLLI(MyLinkedList l){
	    list = l;
	    x = 0;
	}

	public boolean hasNext(){
	    return list.size > x;
	}

	public Integer next(){
	    if(hasNext()){
		x++;
		return list.get(x-1);
	    }else{
		throw new NoSuchElementException();
	    }
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
}
    
