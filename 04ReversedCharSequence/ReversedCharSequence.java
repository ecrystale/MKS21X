import java.util.*;
public class ReverseCharSequence implements CharSequence{
    private String word;
    public ReverseCharSequence(String orig){
	String copy="";
	for (int i=orig.length();i>0;i--){
	    copy+=orig.substring(i-1,i);
	}
	word=copy;
    }
    
    public char charAt(int index){
	return word.charAt(index);
    }

    public int length(){
	return word.length();
    }

    public CharSequence subSequence(int start, int end){
	return word.subSequence(start,end);
    }

    public String toString(){
	return word.toString();
    }
}
