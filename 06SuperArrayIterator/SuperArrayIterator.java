import java.util.Iterator;
public class SuperArrayIterator implements Iterator<String>{
    int current,end;
    public SuperArrayIterator(int start,int stop){
	current = start;
	end = stop;
    }
    public String next(){
	if(hasNext()){
	    current++;
	}else{
	    System.exit(0);
	}
	return next();
    }

    public boolean hasNext(){
	return current <= end;
    }
    public void remove(){
	throw new UnsupportedOperationException();
    }
}
