public class Quick{
    
    public static int part(int[] data, int start, int end){
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
	System.out.println(value);
	return lt;  
    }

    public static void swap(int[] data, int x, int y){
	int temp=data[x];
	data[x]=data[y];
	data[y]=temp;
    }

    public static int quickSelect(int[] data, int k){
        return quickH(data, k);
    }

    public static int quickH(int[]data, int k){
	return 0;
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
	System.out.println(part(test,0,test.length-1));
	System.out.println(toString(test));
    }
}
