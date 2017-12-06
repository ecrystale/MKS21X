import java.util.*;
public class Barcode{
    private String zip;
    private String zip6;
    private static String[] nums={"1","2","3","4","5","6","7","8","9","0"};
    private static String[] scheme={":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::","||:::"};
    public Barcode(String ozip){
	if (!isnumerical(ozip) && !(ozip.length()==5)){
	    throw new IllegalArgumentException();
	}
	else{
	    zip=ozip;
	    zip6=ozip+checkvalue(ozip);
	}
    }
    private String checkvalue(String zipcode){
	int sum=0;
	for (int i=0;i<zipcode.length();i++){
	    sum+=Integer.valueOf(zipcode.substring(i,i+1));
	}
	return String.valueOf(sum%10);
    }
    private boolean isnumerical(String orig){
	for (int i=0;i<orig.length();i++){
	    int z=Integer.valueOf(orig.substring(i,i+1));
	    if (!(z>=0) && !(z<=9)){
		return false;
	    }
	}
	return true;
    }

    public static String toZip(String code){
	if (!(code.substring(0,1).equals("|")) || !(code.substring(code.length()-1,code.length()).equals("|"))){
	    throw new IllegalArgumentException();
	}
	for (int i=0;i<code.length();i++){
	    if (!((code.substring(i,i+1).equals("|")) || (code.substring(i,i+1).equals(":")))){
		throw new IllegalArgumentException();
	    }
	}
	if (code.length()!=32){
	    throw new IllegalArgumentException();
	}
	String finals="";
	for (int i=1;i<code.length()-6;i+=5){ //takes out "|"
	    String x=code.substring(i,i+5);
	    for (int y=0;y<10;y++){
		if (scheme[y].equals(x)){
		    finals+=nums[y];
		}
	    }
	}
	return finals;
    }


    public static String toCode(String zip){
	Barcode a=new Barcode(zip);
	return a.getCode();
    }

    public String toString(){
	return getCode()+" ("+zip+")";
    }

    public int compareTo(Barcode other){
	return getZip().compareTo(other.getZip());
    }

    public String getCode(){
	String finals="|";
	for (int i=0;i<zip6.length();i++){
	    String x=zip6.substring(i,i+1);
	    for (int y=0;y<10;y++){
		if (nums[y].equals(x)){
		    finals+=scheme[y];
		}
	    }
	}
	finals+="|";
	return finals;
    }
	    
    public String getZip(){
	return zip;
    }
    
}
