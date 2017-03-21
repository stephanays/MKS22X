public class Quick{
    
    public static int part(int[] data, int start, int end){
	int pivot = (int) (Math.random() * (end - start));
	int value = data[pivot];
	int spot = 0;
	for(int x=0; x<data.length; x++){
	    if(data[x]<value){
		swap(data, x, spot);
		spot++;
	    }

	}
	swap(data, pivot,spot);
	System.out.println(value);
	return spot;
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
	int[]test={3,7,8,4,2,1,5,9,0,6};
	System.out.println(part(test,0,test.length-1));
	System.out.println(toString(test));
    }
}
