import java.util.Arrays;
public class Merge{

    public static void mergesort(int[]data){
	if(data.length<=1){
	    return;
	}
	int[]left = new int[data.length/2];
	int[]right = new int[data.length - data.length/2];

	int index = 0;

	for(index=0; index<left.length; index++){
	    left[index]=data[index];
	}

	int rightIndex=0;
	for(index=index; index<data.length; index++){
	    right[rightIndex]=data[index];
	    rightIndex++;
	}

	mergesort(left);
	mergesort(right);

	int i1=0;
	int i2=0;
	for(int x=0; x<data.length; x++){
	    if(i1==left.length){
		data[x]=right[i2];
		i2++;
	    }else if(i2==right.length){
		data[x]=left[i1];
		i1++;
	    }else if(left[i1] < right[i2]){
		data[x]=left[i1];
		i1++;
	    }else if(right[i2] < left[i1]){
		data[x]=right[i2];
		i2++;
	    }
	}
	
    }

    public static void merge(int[]a, int[]b, int[]destination){
	int i1=0;
	int i2=0;
	for(int x=0; x<destination.length; x++){
	    if(i1==a.length){
		destination[x]=b[i2];
		i2++;
	    }else if(i2==b.length){
		destination[x]=a[i1];
		i1++;
	    }else if(a[i1] < b[i2]){
		destination[x]=a[i1];
		i1++;
	    }else if(b[i2] < a[i1]){
		destination[x]=b[i2];
		i2++;
	    }
	}
	//System.out.println(toString(destination));
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
	int[]test={3,2,7,8,5,6,9,1,4,0};
	System.out.println(toString(test));
	// int[]a={2,3,5,7,8};
	// int[]b={0,1,4,6,9};
	// merge(a,b,test);
	mergesort(test);
	System.out.println(toString(test));
    }
	

    
}
