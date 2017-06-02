import java.util.*;
public class MyHeap{
    boolean max;
    int size;
    String[] heap;
    
    public MyHeap(){
	heap = new String[10];
	size = 0;
    }
    public MyHeap(boolean b){
	max = b;
	heap = new String[10];
	size = 0;
    }

    public void add(String s){
	if(size == heap.length){
	    String[] copy = new String[heap.length*2];
	    for(int x = 0; x < heap.length; x++){
		copy[x]=heap[x];
	    }
	    heap = copy;
	}
	size++;
	heap[size] = s;
	pushUp();
    }

    public String remove(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	String temp = peek();
	heap[1] = heap[size--];
	pushDown();
	return temp;
	
    }

    public String peek(){
	return heap[1];
    }

    private void swap(int x, int y){
	String temp = heap[x];
	heap[x]=heap[y];
	heap[y]=temp;
    }

    private void pushUp(){
    }

    private void pushDown(){
    }

    
}
