public class KnightBoard{
    private int[][] board;
    private int m;
    private int n;
    
    public KnightBoard(int startingRows, int startingCols){
	m=startingRows;
	n=startingCols;
	board=new int[m][n];
    }

    public String toString(){
	String str="";
	for(int r=0; r < board.length; r++){
	    for(int c=0; c < board[0].length; c++){
		if(board[r][c]<10){
		    str+="0"+board[r][c]+" ";
		}else{
		    str+=board[r][c]+" ";
		}
	    }
	    str+="\n";
	}
	return str;
    }
	
    
    public void solve(){
	solveH(0,0,1);
    }
    
    private boolean solveH(int r, int c, int count){
	if(count > (m * n)){
	    return true;
	}
	if(!(goodSpot(r,c))){
	    return false;
	}
	else{
	    board[r][c]=count;
	    if(solveH(r+1,c+2,count+1) ||
	       solveH(r+1,c-2,count+1) ||
	       solveH(r-1,c+2,count+1) ||
	       solveH(r-1,c-2,count+1) ||
	       solveH(r+2,c+1,count+1) ||
	       solveH(r+2,c-1,count+1) ||
	       solveH(r-2,c+1,count+1) ||
	       solveH(r-2,c-1,count+1)){
		return true;
	    }else{
		board[r][c]=0;
		return false;
	    }
	}
    }
	
    
    private boolean goodSpot(int r, int c){
	if(r<board.length && c<board[0].length && r>=0 && c>=0){
	    if(board[r][c]==0){
		return true;
	    }else{
		return false;
	    }
	}
	return false;
    }

    public static void main(String[]args){
	KnightBoard test= new KnightBoard(7,7);
        test.solve();
	System.out.println(test);
	KnightBoard test2= new KnightBoard(3,4);
        test2.solve();
	System.out.println(test2);
    }

}
