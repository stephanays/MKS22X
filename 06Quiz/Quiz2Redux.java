import java.util.*;
public class Quiz2Redux{  
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	String str="";
	helper(words, s, str, 0);
	Collections.sort(words);
	return words;
    }
    
    public static void helper(ArrayList<String> words, String s, String str, int current){
        if (current >= s.length()) {
	    words.add(str);
	}else{
	    helper(words, s, str, current+1);
	    helper(words, s, str + s.substring(current,current+1), current+1);
	}
    }
    
    public static void main(String[]args){
	System.out.println(combinations("abcdefg"));
    }
}

