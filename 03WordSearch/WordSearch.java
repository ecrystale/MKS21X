import java.util.*;
import java.util.Random;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class WordSearch{
    private char[][] data;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private Random randgen;

    public WordSearch(int rows,int cols){
	data=new char[rows][cols];
	for (int i=0;i<rows;i++){
	    for (int x=0;x<cols;x++){
		data[i][x]='_';
	    }
	}
    }

    private void clear(){
	for (int i=0;i<data.length;i++){
	    for (int x=0;x<data[i].length;x++){
		data[i][x]='_';
	    }
	}
    }

    public String toString(){
	String result="";
	for (int i=0;i<data.length;i++){
	    for (int x=0;x<data[i].length;x++){
		if (x<data[i].length-1){
		    result+=data[i][x]+" ";
		}
		if (x==data[i].length-1){
		    result+=data[i][x];
		}
	    }
	    if (i<data.length-1){
		result+="\n";
	    }
	}
	return result;
    }


    public boolean addWordHorizontal(String word,int row, int col){
	if (data.length<row){
	    return false;
	}
	if (data[row].length-col<word.length()){
	    return false;
	}
	else{
	    for (int i=col;i<word.length()+col;i++){
		if (data[row][i]!='_' && data[row][i]!=word.charAt(i-col)){
		    return false;
		}
		else{
		    data[row][i]=word.charAt(i-col);
		}
	    }
	}
	return true;
    }

    public boolean addWordVertical(String word,int row, int col){
  	if (data.length-row<word.length()){
	    return false;
	}
	if (data[row].length<col){
	    return false;
	}
	else{
	    for (int i=row;i<word.length()+row;i++){
		if (data[i][col]!='_' && data[i][col]!=word.charAt(i-row)){
		    return false;
		}
		else{
		    data[i][col]=word.charAt(i-row);
		}
	    }
	}
	return true;
    }

    public boolean addWordDiagonal(String word,int row, int col){
	if (data.length-col<word.length()){
	    return false;	
	}
	if (data[row].length-row<word.length()){
	    return false;
	}
	else{
	    for (int i=0;i<word.length();i++){
		if (data[i+row][i+col]!='_' && data[i+row][i+col]!=word.charAt(i)){
		    return false;
		}
		else{
		    data[i+row][i+col]=word.charAt(i);
		}
	    }
	}
	return true;
    }

    public ArrayList<String> words(String name){
	ArrayList<String> ary=new ArrayList<String>(0);
	String fileName = name;
	try{
	    File f = new File(fileName);//can combine
	    Scanner in = new Scanner(f);//into one line
	    while(in.hasNext()){
		String word=in.next();
		ary.add(word.toLowerCase());
	    }/*
	       ary=new ArrayList(count);
	       while(in.hasNext()){
	       String word = in.next();
	       ary+=word;
	       place++;
	       }*/
	}catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName);
	    //e.printStackTrace();
	    System.exit(1);
	}
	return ary;
    }


    public WordSearch( int rows, int cols,String fileName){
	data=new char[rows][cols];
	for (int i=0;i<rows;i++){
	    for (int x=0;x<cols;x++){
		data[i][x]='_';
	    }
	}
	wordsToAdd=words(fileName);
	randgen=new Random();
	int randSeed=randgen.nextInt(10000)+1;
	randgen=new Random(randSeed);
	System.out.println("Seed:"+randSeed);
    }

    public WordSearch( int rows, int cols, String fileName, int randSeed){
	data=new char[rows][cols];
	for (int i=0;i<rows;i++){
	    for (int x=0;x<cols;x++){
		data[i][x]='_';
	    }
	}
	wordsToAdd=words(fileName);
	randgen=new Random(randSeed);
	System.out.println("Seed:"+randSeed);
    }


    private boolean addWord( int r, int c, String word, int rowIncrement, int colIncrement){
	int ro=r;
	int co=c;
	if (rowIncrement==0 && colIncrement==0){
	    return false;
	}
	if (data[0].length-c<word.length()){
	    return false;	
	}
	if (data.length-r<word.length()){
	    return false;
	}
	if (rowIncrement>1 || colIncrement>1){
	    return false;
	}
	else{
	    for (int i=0;i<word.length();i++){
		if (data[r][c]!='_' && data[r][c]!=word.charAt(i)){
		    return false;
		}
	        else{
		    r+=rowIncrement;
		    c+=colIncrement;
		}
	    }
	}
	for (int x=0;x<word.length();x++){
	    data[ro][co]=word.charAt(x);
	    ro+=rowIncrement;
	    co+=colIncrement;
	}
	return true;
    }


    private boolean addAllWords(){
	int count=0;
	wordsAdded=new ArrayList<String>(0);
	for (int i=0; i<1000;i++)
	    if(wordsToAdd.size()==0){
		return true;
	    }
	    else{ 
		String x=wordsToAdd.get(randgen.nextInt(wordsToAdd.size()));
		if(addWord(randgen.nextInt(data.length),randgen.nextInt(data[0].length),x,randgen.nextInt(3),randgen.nextInt(3))){
		    wordsAdded.add(x);
		    wordsToAdd.remove(x);
		}
	    }
	return false;
    }

    private boolean addrandomWords(){
	for (int i=0;i<data.length;i++){
	    for (int x=0;x<data[0].length;x++){
		if(data[i][x]=='_'){
		    data[i][x]=((char) (randgen.nextInt(26)+97));
		}
	    }
	}
	return true;
    }

    public static void main (String[] args){
	if (args.length==0){
	    System.out.println("To run the program, input java WordSearch [rows cols filename [randomSeed [answers]]] into the terminal, with the correct inputs");
	}
	if (args.length==2){
	    int r=Integer.parseInt(args[0]);
	    int c=Integer.parseInt(args[1]);
	    WordSearch a= new WordSearch(r,c);
	    System.out.println(a.toString());
	}
	if (args.length==3){
	    int r=Integer.parseInt(args[0]);
	    int c=Integer.parseInt(args[1]);
	    String file=args[2];
	    WordSearch a= new WordSearch(r,c,file);
	    a.addAllWords();
	    System.out.println(a.wordsAdded);
	    String key=a.toString();
	    a.addrandomWords();
	    System.out.println(a.toString());
	}
	if (args.length==4){
	    int r=Integer.parseInt(args[0]);
	    int c=Integer.parseInt(args[1]);
	    String file=args[2];
	    int seed=Integer.parseInt(args[3]);
	    WordSearch a= new WordSearch(r,c,file,seed);
	    a.addAllWords();
	    System.out.println(a.wordsAdded);
	    String key=a.toString();
	    a.addrandomWords();
	    System.out.println(a.toString());
	}
	if (args.length==5){
	    int r=Integer.parseInt(args[0]);
	    int c=Integer.parseInt(args[1]);
	    String file=args[2];
	    int seed=Integer.parseInt(args[3]);
	    WordSearch a= new WordSearch(r,c,file,seed);
	    a.addAllWords();
	    System.out.println(a.wordsAdded);
	    String key=a.toString();
	    a.addrandomWords();
	    System.out.println(a.toString());
	    if ((args[4]).equals("key")){
		System.out.println("\n KEY: \n");
		System.out.println(key);
	    }
	}
    }
}    

