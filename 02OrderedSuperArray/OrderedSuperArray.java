import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.*;
public class OrderedSuperArray extends SuperArray{
    /*constructor initializes an empty List*/
    public OrderedSuperArray(){
	super();
	//Complete this.
    }
    public OrderedSuperArray(int capacity){
	super(capacity);
    }
    public OrderedSuperArray(String[] ary){
	super(ary.length);
	for (int i=0;i<ary.length;i++){
	    add(ary[i]);
	}
    }

    public String set(int index, String element){
	throw new UnsupportedOperationException();
    }

    private int findIndex(String str){
	for (int i=0;i<size();i++){
	    if (get(i).compareTo(str)>=0){
	        return i;
	    }
	}
	return size();
    }

    private int findIndexBinary(String str){
	int x=size();
	for (int i=size()/2-1;x>1;i=x){
	    if (get(i).compareTo(str)>0){
		x=i/2;
	    }
	    if (get(i).compareTo(str)<0){
		x=i+i/2;
	    }
	    if (get(i).compareTo(str)==0){
		return i;
	    }
	}
	return x;
    }
    /*call the proper add.*/
    public void add(int index, String value){
	add(value);
    }
    
    /*Write this method and any
      appropriate helper methods.*/
    public boolean add(String value){
	super.add(findIndex(value), value);
	return true;
    }

}
