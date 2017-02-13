public class QueenBoard{
    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    public boolean solve(){
	return solveH(0);
    }

    public boolean solveH(int col){
	return false;
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
	return -1;
    }

    public String toString(){
	String str="";
	for(int r=0; r<board.length; r++){
	    for(int c=0; c<board.length; c++){
		str+=board[r][c]+" ";
	    }
	    str+="\n";
	}
	return str;
    }

    public static void main(String[]args){
	QueenBoard a=new QueenBoard(8);
	System.out.println(a.addQueen(2,1));
	System.out.println(a.toString());
	System.out.println(a.addQueen(0,0));
	System.out.println(a.toString());
	System.out.println(a.removeQueen(0,0));
	System.out.println(a.toString());
	System.out.println(a.removeQueen(0,1));
	System.out.println(a.toString());
    }
}
    
