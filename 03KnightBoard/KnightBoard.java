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
		str+=board[r][c]+" ";
	    }
	    str+="\n";
	}
	return str;
    }
	
    
    public void solve(){
	solveH(0,0,1);
    }
    
    private boolean solveH(int r, int c, int count){
	if(count==1){
	    board[r][c]=1;
	    count++;
	}
	if(count > (m * n)){
	    return true;
	}else{
	    if(goodSpot(r+2,c-1)){
		board[r][c]=count;
		count++;
		return solveH(r+2,c-1,count);
	    }
	    if(goodSpot(r+2,c+1)){
		board[r][c]=count;
		count++;
		return solveH(r+2,c+1,count);
	    }
	    if(goodSpot(r+2,c-1)){
		board[r][c]=count;
		count++;
		return solveH(r+2,c-1,count);
	    }
	    if(goodSpot(r-2,c+1)){
		board[r][c]=count;
		count++;
		return solveH(r-2,c+1,count);
	    }
	    if(goodSpot(r-1,c+2)){
		board[r][c]=count;
		count++;
		return solveH(r-1,c+2,count);
	    }
	    if(goodSpot(r-1,c-2)){
		board[r][c]=count;
		count++;
		return solveH(r-1,c-2,count);
	    }
	    if(goodSpot(r+1,c+2)){
		board[r][c]=count;
		count++;
		return solveH(r+1,c+2,count);
	    }
	    if(goodSpot(r+1,c-2)){
		board[r][c]=count;
		count++;
		return solveH(r+1,c-2,count);
	    }
	    
	// else:
	//     if isOnGoodSpot(){
	// 	    place number;
	// 	    try possible move ->;
	// 	}
	// return false;
	//make array of possible moves (r+/-1 c+/-2) (r+/-2 c+/-1)
	    return false;
	}
    }
    
    private boolean goodSpot(int r, int c){
    	if(board[r][c]==0){
	    return true;
    	}else{
	    return false;
	}
    }

    public static void main(String[]args){
	KnightBoard test= new KnightBoard(6,6);
	System.out.println(test);
    }

}
