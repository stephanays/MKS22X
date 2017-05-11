import java.util.*;

public class MyHeap{

    private ArrayList<Integer> data;
    private boolean isMax;

    public MyHeap(){

	data = new ArrayList<Integer>();
	data.add(0,null);
	isMax = true;
    }

    public MyHeap(boolean bool){
	data = new ArrayList<Integer>();
	data.add(0,null);
	isMax = bool;
    }

    public void add(int str){
	data.add(str);
	pushUp();
    }

    public Integer remove(){
	Integer temp = data.get(1);
	data.set(1, data.get(data.size() - 1));
	data.remove(data.size() - 1);
	pushDown();
	return temp;
    }

    public int peek(){
	return data.get(1);
    }

    private void pushUp(){
	Integer temp = data.get(data.size() - 1);
	Integer index = data.size() - 1;

	if(isMax){
	    while((index/2 > 0) &&
		  (temp.compareTo(data.get(index/2)) > -1)){
		swap(data, index, index/2);
		index = index/2;
	    }
	}
	else{
	    while((index/2 > 0) &&
		  (temp.compareTo(data.get(index/2)) < 1)){
		swap(data, index, index/2);
		index = index/2;
	    }
	}
	
    }

    private void pushDown(){

	if(data.size() == 1){
	    return;
	}
	
	Integer temp = data.get(1);
	Integer index = 1;

	if(isMax){
	    while((index*2 < data.size()) &&
		  ((temp.compareTo(data.get(index*2)) < 1) ||
		   (temp.compareTo(data.get(index*2)+1) < 1)) 
		   ){
		if((temp.compareTo(data.get(index*2)) < 1)&&
		   ((index*2) + 1 >= data.size() ||
		    (data.get(index*2).compareTo(data.get((index*2)+1)) > -1)
		    )){
		    swap(data, index, index*2);
		    index = index*2;
		}
		else{
		    swap(data, index, (index*2)+1);
		    index = (index*2)+1;
		}
	    }
	}
	else{

	    while((index*2 < data.size()) &&
		  ((temp.compareTo(data.get(index*2)) > -1) ||
		   (temp.compareTo(data.get(index*2)+1) > -1)) 
		  ){
		
		if((temp.compareTo(data.get(index*2)) > -1)&&
		   ((index*2) + 1 >= data.size() ||
		    (data.get(index*2).compareTo(data.get((index*2)+1)) < 1)
		     )){
		    swap(data, index, index*2);
		    index = index*2;
		}
		else{
		    swap(data, index, (index*2)+1);
		    index = (index*2)+1;
		}
	    }
	    
	}
    }

    private void swap(ArrayList<Integer> ary, int ind, int ind2){
	Integer temp = ary.get(ind);
	ary.set(ind, ary.get(ind2));
	ary.set(ind2, temp);
    }

    public String toString(){
	String temp = "";

	for(Integer str : data){
	    temp += str + " ";
	}

	return temp;
    }

}
