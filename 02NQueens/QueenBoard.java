public class QueenBoard{
    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
	solutionCount=-1;
    }

    public boolean solve(){
	return solveH(0,true);
    }

    public boolean solveH(int col, boolean stop){
	if(col>=board.length){
	    if(stop){
		return true;
	    }else{
		solutionCount++;
		return false;
	    }
	}
	for(int row=0;row<board.length;row++){
	    if(board[row][col]==0 && addQueen(row,col)){
		addQueen(row,col);
		if(solveH(col+1,stop)==true){
		    return true;
		}else{
		    removeQueen(row,col);
		}
	    }
	}
	return false;
	
    }

    public void countSolutions(){
    	solutionCount=0;
	solveH(0,false);
    }
    
    public boolean addQueen(int x, int y){
	if(board[x][y]==0){
	    for(int row=0; row<board.length; row++){
		board[row][y]-=1;
	    }
	    for(int col=0; col<board.length; col++){
		board[x][col]-=1;
	    }
	    //add diagonals
	    for(int num=1; num<board.length; num++){
		if((x+num<board.length) && (y+num<board.length)){
		    board[x+num][y+num]-=1;
		}
		if((x+num<board.length) && ((y-num<board.length) && (y-num>=0))){
		    board[x+num][y-num]-=1;
		}
		if(((x-num<board.length) && (x-num>=0)) && (y+num<board.length)){
		    board[x-num][y+num]-=1;
		}
		if(((x-num<board.length) && (x-num>=0)) && ((y-num<board.length) && (y-num>=0))){
		    board[x-num][y-num]-=1;
		}
	    }
	    board[x][y]=1;
	    return true;
	}
	return false;
    }

    public boolean removeQueen(int x, int y){
	if(board[x][y]==1){
	    for(int row=0; row<board.length; row++){
		board[row][y]+=1;
	    }
	    for(int col=0; col<board.length; col++){
		board[x][col]+=1;
	    }
	    //add diagonals
	    for(int num=1; num<board.length; num++){
		if((x+num<board.length) && (y+num<board.length)){
		    board[x+num][y+num]+=1;
		}
		if((x+num<board.length) && ((y-num<board.length) && (y-num>=0))){
		    board[x+num][y-num]+=1;
		}
		if(((x-num<board.length) && (x-num>=0)) && (y+num<board.length)){
		    board[x-num][y+num]+=1;
		}
		if(((x-num<board.length) && (x-num>=0)) && ((y-num<board.length) && (y-num>=0))){
		    board[x-num][y-num]+=1;
		}
	    }
	    board[x][y]=0;
	    return true;
	}
	return false;

    }
    
    public int getSolutionCount(){
	return solutionCount;
    }

    public String toString(){
	String str="";
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board.length; c++){
		if(board[r][c]<0){
		    str+="0 ";
		}else{
		    str+=board[r][c]+" ";
		}
	    }
	    str+="\n";
	}
	return str;
    }

    public static void main(String[]args){
	
    }
}
    
