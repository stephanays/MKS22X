import java.util.*;
import java.io.*;
public class Lake{
    private int[][]land;
    private int lake;
    private int[][]instructions;

    public Lake(String filename)throws FileNotFoundException{
	File text= new File(filename);
	Scanner data=new Scanner(text);
	
	String first=data.nextLine();
	String[] firstList = first.split(" ");
	land=new int[Integer.parseInt(firstList[0])][Integer.parseInt(firstList[1])];
	lake=Integer.parseInt(firstList[2]);
	instructions=new int[Integer.parseInt(firstList[3])][3];

	for(int r=0; r<land.length; r++){
	    String line=data.nextLine();
	    String[] lineList=line.split(" ");
	    for(int c=0; c<lineList.length; c++){
		land[r][c]=Integer.parseInt(lineList[c]);
	    }
	}

	for(int r=0;r<instructions.length; r++){
	    String line=data.nextLine();
	    String[] lineList=line.split(" ");
	    for(int c=0; c<3; c++){
		instructions[r][c]=Integer.parseInt(lineList[c]);
	    }
	}
    }

    public void stomp(int r, int c, int num){
	int high = findHigh(r, c);
	int level = high - num;
	if(land[r][c]>level){
	    land[r][c]=level;
	}
	if(land[r-1][c-1]>level){
	    land[r-1][c-1]=level;
	}
	if(land[r-1][c]>level){
	    land[r-1][c]=level;
	}
	if(land[r-1][c+1]>level){
	    land[r-1][c+1]=level;
	}
	if(land[r][c-1]>level){
	    land[r][c-1]=level;
	}
	if(land[r][c+1]>level){
	    land[r][c+1]=level;
	}
	if(land[r+1][c-1]>level){
	    land[r+1][c-1]=level;
	}
	if(land[r+1][c]>level){
	    land[r+1][c]=level;
	}
	if(land[r+1][c+1]>level){
	    land[r+1][c+1]=level;
	}
    }

    public int findHigh(int r, int c){
	int highest=land[r][c];
	if(land[r-1][c-1]>highest){
	    highest=land[r-1][c-1];
	}
	if(land[r-1][c]>highest){
	    highest=land[r-1][c];
	}
	if(land[r-1][c+1]>highest){
	    highest=land[r-1][c+1];
	}
	if(land[r][c-1]>highest){
	    highest=land[r][c-1];
	}
	if(land[r][c+1]>highest){
	    highest=land[r][c+1];
	}
	if(land[r+1][c-1]>highest){
	    highest=land[r+1][c-1];
	}
	if(land[r+1][c]>highest){
	    highest=land[r+1][c];
	}
	if(land[r+1][c+1]>highest){
	    highest=land[r+1][c+1];
	}
	return highest;
    }

    public void runCommands(){
	for(int r=0; r<instructions.length; r++){
	    this.stomp(instructions[r][0],instructions[r][1], instructions[r][2]);
	}
    }

    public String toString(){
	String newstr="";
	for(int r=0; r<land.length; r++){
	    for(int c=0; c<land[0].length; c++){
		newstr+=land[r][c]+" ";
	    }
	    newstr+="\n";
	}

	
	for(int r=0; r<instructions.length; r++){
	    for(int c=0; c<3; c++){
		newstr+=instructions[r][c]+" ";
	    }
	    newstr+="\n";
	}
	return newstr;
    }
    
    public static void main(String[]args)throws FileNotFoundException{
	Lake test=new Lake("data.txt");
	System.out.println(test.toString());
	System.out.println(test.findHigh(1,4));
	//test.stomp(1,4,4);
	//test.stomp(1,1,10);
	test.runCommands();
	System.out.println(test.toString());
    }
		
	
}
