import java.util.Iterator;
public class SuperArrayIterator implements Iterator<String>{
    private SuperArray data;
    private int current;
    public SuperArrayIterator(SuperArray pulled){
	data=pulled;
	current=0;
    }
    public String next(){
	if(hasNext()){
	    current++;
	}else{
	    System.exit(0);
	}
	return data.get(current-1);
    }

    public boolean hasNext(){
	return current < data.size();
    }
    public void remove(){
	throw new UnsupportedOperationException();
    }
}
