public class Quick{
    
    public static int part(int[] data, int start, int end){
	if(start==end){
	    return start;
	}
	int pivot = (int) (Math.random() * (end - start)) + start;
	int value = data[pivot];
	int i = start;
	int lt = start;
	int gt = end;
	swap(data, pivot, i);
	while(i<=gt){
	    if(data[i] == value){
		i++;
	    }else if(data[i] < value){
		swap(data, i, lt);
		i++;
		lt++;
	    }else{
		swap(data, i, gt);
		gt--;
	    }
	}
	return lt;  
    }

    public static void quicksort(int[]data){
    	quicksortH(data,0,data.length-1);
    }

    public static void quicksortH(int[]data, int start, int end){
    	int pivot = (int) (Math.random() * (end - start)) + start;
	int value = data[pivot];
	int i = start;
	int lt = start;
	int gt = end;
	swap(data, pivot, i);
	while(i<=gt){
	    if(data[i] == value){
		i++;
	    }else if(data[i] < value){
		swap(data, i, lt);
		i++;
		lt++;
	    }else{
		swap(data, i, gt);
		gt--;
	    }
	    if(start+1 < lt){
		quicksortH(data,start,lt-1);
	    }
	    if(end > gt+1){
		quicksortH(data,gt+1,end);
	    }
	}   
    }
    
    public static void swap(int[] data, int x, int y){
	int temp=data[x];
	data[x]=data[y];
	data[y]=temp;
    }
    
    public static int quickselect(int[] data, int k){
        return quickH(data, k,0,data.length-1);
    }
    
    public static int quickH(int[]data, int k, int start, int end){
	int index=part(data,start,end);
	if(index==k){
	    return data[index];
	}
	if(index < k){
	    return quickH(data,k,index+1,end);
	}
	if(index > k){
	    return quickH(data,k,start,index);
	}
	return data[k];
    }
    
    
    public static String toString(int[] data){
	String str="{";
	for(int x=0; x<data.length; x++){
	    str+=data[x]+",";
	}
	String newstr=str.substring(0,str.length()-1);
	newstr+="}";
	
	return newstr;
    }

    public static void main(String[]args){
	int[]test={3,2,7,8,4,2,1,5,9,0,6,4,4,2,6};
	//System.out.println(part(test,0,test.length-1));
	//System.out.println(toString(test));
	// System.out.println(quickselect(test,0));
	// System.out.println(quickselect(test,1));
	// System.out.println(quickselect(test,2));
	// System.out.println(quickselect(test,3));
	// System.out.println(quickselect(test,4));
	// System.out.println(quickselect(test,5));
        quicksort(test);
	System.out.println(toString(test));
    }
}
