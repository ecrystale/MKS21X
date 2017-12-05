import java.util.*;
public class Barcode{
    private String zip;
    public Barcode(String ozip){
	if (!isnumerical(ozip) && !(ozip.length()==5)){
	    throw new IllegalArgumentException();
	}
	else{
	    zip=ozip+checkvalue(ozip);
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

    public String toZip(String code){
	if (!(code.substring(0,1).equals("|")) || !(code.substring(code.length()-1,code.length()).equals("|"))){
	    throw new IllegalArgumentException();
	}
	for (int i=0;i<code.length();i++){
	    if (!(code.substring(i,i+1).equals("|")) || !(code.substring(i,i+1).equals(":"))){
		throw new IllegalArgumentException();
	    }
	}
	if (code.length()!=32){
	    throw new IllegalArgumentException();
	}
	String finals="";
	for (int i=1;i<code.length()-1;i++){ //takes out "|"
	    String x=code.substring(i,i+1);
	    if (x.equals(":::||")){
		finals+="1"; 
	    }
	    if (x.equals("::|:|")){
		finals+= "2";  
	    }
	    if (x.equals("::||:")){
		finals+= "3";  
	    }
	    if (x.equals(":|::|")){
		finals+= "4";  
	    }
	    if (x.equals(":|:|:")){
		finals+= "5";  
	    }
	    if (x.equals(":||::")){
		finals+= "6";  
	    }
	    if (x.equals("|:::|")){
		finals+= "7";  
	    }
	    if (x.equals("|::|:")){
		finals+= "8";  
	    }
	    if (x.equals("|:|::")){
		finals+= "9";  
	    }
	    if (x.equals("||:::")){
		finals+= "0";  
	    }
	}
	return finals;
     }


    public String toCode(String zip){
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
	for (int i=0;i<zip.length();i++){
	    int x=Integer.valueOf(zip.substring(i,i+1));
	    if (x==1){
		finals+= ":::||"; 
	    }
	    if (x==2){
		finals+= "::|:|";  
	    }
	    if (x==3){
		finals+= "::||:";  
	    }
	    if (x==4){
		finals+= ":|::|";  
	    }
	    if (x==5){
		finals+= ":|:|:";  
	    }
	    if (x==6){
		finals+= ":||::";  
	    }
	    if (x==7){
		finals+= "|:::|";  
	    }
	    if (x==8){
		finals+= "|::|:";  
	    }
	    if (x==9){
		finals+= "|:|::";  
	    }
	    if (x==0){
		finals+= "||:::";  
	    }
	}
	finals+="|";
	return finals;
    }

    public String getZip(){
	return zip;
    }
    
}
