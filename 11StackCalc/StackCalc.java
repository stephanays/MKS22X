import java.util.*;
public class StackCalc{
    
    public static double eval(String s){
	Stack nums = new Stack();
	for(String token:s.split(" ")){
		if(isOp(token)){
		    nums.push(Double.toString(apply(token, (String)nums.pop(), (String)nums.pop())));
		}else{
		    nums.push(token);
		}
	}
	return Double.parseDouble((String)nums.pop());
    }

    public static boolean isOp(String s){
	if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
	    return true;
	}else{
	    return false;
	}
    }

    public static double apply(String op, String a, String b){
	double x = Double.parseDouble(a);
	double y = Double.parseDouble(b);
	if(op.equals("+")){
	    return y+x;
	}
	if(op.equals("-")){
	    return y-x;
	}
	if(op.equals("*")){
	    return y*x;
	}
	if(op.equals("/")){
	    return y/x;
	}
	return 0.0;
    }

    public static void main(String[]args){
	// System.out.println(eval("10 2.0 +"));
	// System.out.println(eval("11 3 - 4 + 2.5 *"));
	// System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
	
	System.out.println(eval("10 2 +"));//12.0
	System.out.println(eval("10 2 -"));//8.0
	System.out.println(eval("10 2.0 +"));//12.0
	System.out.println(eval("11 3 - 4 + 2.5 *"));//30.0
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));//893.0
	System.out.println(eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }
}
