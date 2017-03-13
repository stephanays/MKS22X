import java.util.*;
import java.io.*;
public class USACO{
    private int[][]land;
    private int[][]grass;
    private int[][]grass2;
    private int lake;
    private int[][]instructions;

    public USACO(){
    }

    public int bronze(String filename){
	try {
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
	    runCommands();
	    lake();
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found.");
	    System.exit(0);
	}
	return math();
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

    public void lake(){
	for(int r=0; r<land.length; r++){
	    for(int c=0; c<land[0].length; c++){
		land[r][c]=land[r][c]-lake;
		if(land[r][c]<=0){
		    land[r][c]=Math.abs(land[r][c]);
		}else{
		    land[r][c]=0;
		}
	    }
	}
    }

    public void runCommands(){
	for(int r=0; r<instructions.length; r++){
	    this.stomp(instructions[r][0],instructions[r][1], instructions[r][2]);
	}
    }

    public int math(){
	int sum=0;
	for(int r=0; r<land.length; r++){
	    for(int c=0; c<land[0].length; c++){
		sum+=land[r][c];
	    }
	}
	return sum * 72 * 72;
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

    public int silver(String filename){
	try {
	    File text= new File(filename);
	    Scanner data=new Scanner(text);
	    Scanner header = new Scanner(data.nextLine());
	    int rows = header.nextInt();
	    int cols = header.nextInt();
	    int period = header.nextInt();
	    grass = new int[rows][cols];
	    grass2 = new int[rows][cols];
	    for(int r=0; r<rows; r++){
		String row = data.nextLine();
		for (int c=0; c<cols; c++){
		    if(row.charAt(c) == '*'){
			grass[r][c]= -1;
		    }else{
			grass[r][c] = 0;
		    }
		}
	    }

	    Scanner instructions = new Scanner(data.nextLine());
	    int startRow = instructions.nextInt();
	    int startCol = instructions.nextInt();
	    int endRow = instructions.nextInt();
	    int endCol = instructions.nextInt();
	    return 0;	    
	}
	catch (Exception e){
	    System.out.println("File not found");
	    System.exit(0);
	}
	return 0;
    }

    public static void main(String[]args){
	USACO test=new USACO();
	// System.out.println(test.bronze("data.txt"));
	// System.out.println(test.bronze("data2.txt"));
	// System.out.println(test.bronze("data3.txt"));
	// System.out.println(test.bronze("data4.txt"));
	// System.out.println(test.bronze("data5.txt"));
	// System.out.println(test.bronze("data6.txt"));
	// System.out.println(test.bronze("data7.txt"));
	// System.out.println(test.bronze("data8.txt"));
	// System.out.println(test.bronze("data9.txt"));
	// System.out.println(test.bronze("data10.txt"));
	System.out.println(test.silver("sdata.txt"));
    }

}
