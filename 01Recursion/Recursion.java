import java.lang.*;
public class Recursion{
    
    public static String name(){
	return "Zheng,Stephanie";
    }
    
    public static double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	if(n==0){
	    return 0;
	}
	return helper(n,1);
    }

    public static double helper(double n, double guess){
	if((Math.abs(n - (guess * guess)))<0.0000000001){
	    return guess;
	}else{
	    return helper(n,(((n/guess)+guess)/2));
	}
    }

    public static void main(String[]args){
	System.out.println(sqrt(0));
    }
}
