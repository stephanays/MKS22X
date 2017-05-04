import java.util.*;
public class MyDeque{

    private int front;
    private int back;
    private int size;
    private String[] ary;

    public MyDeque(){
	ary = new String[10];
	size = 10;
	front = 0;
	back = 0;
    }

    public void expand(){
	String[] temp = new String[ary.length * 2];
	int x = front;
	int y = 0;
	while(x!=back){
	    temp[y]=ary[x];
	    x=(x+1)%(ary.length);
	    y++;
	}
	temp[y]=ary[back];
	front=0;
	back=y;
	ary=temp;
    }
    
    public void addFirst(String str){
	if(str==null){
	    throw new NullPointerException();
	}
	if(size==ary.length){
	    expand();
	}
	front=(ary.length+front-1)%(ary.length);
	if(size==0){
	    front=0;
	    back=0;
	}
	ary[front]=str;
	size++;
    }
	    
    

    public void addLast(String str){
	if(str==null){
	    throw new NullPointerException();
	}
	if(size == ary.length){
	    expand();
	}
	back = (back+1)%(ary.length);
	if(size == 0){
	    front = back = 0;
	}
	ary[back] = str;
	size++;
    }

    public String removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	String ans = ary[front];
	front = (front+1)%(ary.length);
	size--;
	return ans;
    }

    public String removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	    
	}
	String ans = ary[back];
	back = (ary.length + back - 1)%(ary.length);
	size--;
	return ans;
    }

    public String getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}else{
	    return ary[front];
	}
    }
    public String getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}else{
	    return ary[back];
	}
    }

    public String toString(){
	String newstr="[";
	for(int x=0; x<ary.length; x++){
	    newstr += ary[x]+" ";
	}
	newstr+="]";
	return newstr;
    }

    public static void main(String[]args){
    }
    
    
}
