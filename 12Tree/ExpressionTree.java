public class ExpressionTree{
    private char op;
    private double val;
    private ExpressionTree leftSide;
    private ExpressionTree rightSide;

    public ExpressionTree(double value){
	val=value;
	op='~';
    }

    public ExpressionTree(char oper, ExpressionTree left, ExpressionTree right){
	op=oper;
	leftSide=left;
	rightSide=right;
    }
    
    private double getValue(){
	return val;
    }
    private char getOp(){
	return op;
    }
    private ExpressionTree getLeft(){
	return leftSide;
    }
    private ExpressionTree getRight(){
	return rightSide;
    }
    private boolean isOp(){
	return hasChildren();
    }
    private boolean isValue(){
	return !hasChildren();
    }
    private boolean hasChildren(){
	return leftSide != null && rightSide != null;
    }

    public String toString(){
	if(isValue()){
	    return "" + getValue();
	}else{
	    return "(" + leftSide.toString() + " " + getOp() + " " + rightSide.toString() + ")";
	}
    }
    public String toStringPostfix(){
	if(isValue()){
	    return "" + getValue();
	}else{
	    return leftSide.toStringPostfix() + " " + rightSide.toStringPostfix() + " "+getOp();
	}
    }
    public String toStringPrefix(){
	if(isValue()){
	    return "" + getValue();
	}else{
	    return getOp() + " " + leftSide.toStringPrefix() + " " + rightSide.toStringPrefix();
	}
    }

    public double evaluate(){
	if(isValue()){
	    return getValue();
	}else{
	    if(getOp() == '+'){
		return getLeft().evaluate() + getRight().evaluate();
	    }
	   else if(getOp() == '-'){
		return getLeft().evaluate() - getRight().evaluate();
	    }
	   else if(getOp() == '*'){
		return getLeft().evaluate() * getRight().evaluate();
	    }
	   else if(getOp() == '/'){
		return getLeft().evaluate() / getRight().evaluate();
	   }else{
	       return 0.0;
	   }
	}
    }

    public static void main(String[] args){
   
  }
}
