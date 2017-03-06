import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Maze(String filename)throws FileNotFoundException {
	animate=false;
	File text = new File(filename); 
        Scanner inf = new Scanner(text);
        int rowNumber = 0;
	int colNumber = 0;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
	    rowNumber++;
	    colNumber=line.length();
	}
	inf.close();
	maze= new char[rowNumber][colNumber];
	inf = new Scanner(text);
	int row = 0;
	while(inf.hasNextLine()){
	    String line = inf.nextLine();
	    for(int col=0; col<line.length(); col++){
		maze[row][col]=line.charAt(col);
		if(line.charAt(col)=='S'){
		    startX=row;
		    startY=col;
		}
		if(line.charAt(col)=='E'){
		    endX=row;
		    endY=col;
		}
	    }
	    row++;
	}	
    }

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
    
    public void setAnimate(boolean b){
	animate = b;
    }

    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }

    public boolean solve(){
	int startR=startX;
	int startC=startY;
	maze[startR][startC]=' ';
	return solve(startR,startC);
    }

    public boolean solve(int x, int y){
	if(animate){
	    System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	if(maze[x][y]=='E'){
	    return true;
	}
	if(maze[x][y]==' '){
	    maze[x][y]='@';
	    if(solve(x+1,y) ||
	       solve(x-1,y) ||
	       solve(x,y+1) ||
	       solve(x,y-1)){
		return true;
	    }
	    else{
		maze[x][y]='.';
	    }
	}
	return false;
    }

    public String toString(){
	String newstr="";
	for(int r=0; r<maze.length; r++){
	    for(int c=0; c<maze[0].length; c++){
		newstr+=String.valueOf(maze[r][c]);
	    }
	    newstr+="\n";
	}
	return newstr;
    }

    public static void main(String args[])throws FileNotFoundException{
	Maze test=new Maze("data3.dat");
	System.out.println(test.toString());
	test.setAnimate(true);
	test.solve();
	System.out.println(test.toString());
	
    }
}
