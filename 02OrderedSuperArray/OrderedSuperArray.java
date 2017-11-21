public class OrderedSuperArray extends SuperArray{
    /*constructor initializes an empty List*/
    public static void main(String[] args){
    }
    String x;
    public OrderedSuperArray(){
	x= super.toString();
	//Complete this.
    }

    /*call the proper add.*/
    public void add(int index, String value){
	super.add(index, value);
    }

    /*Write this method and any
      appropriate helper methods.*/
    public boolean add(String value){
	for (int i=0;i<x.length();i++){
	    if (x.substring(i,i+1).compareTo(value)==0){
		add(i,value);
	    }
	    if (x.substring(i,i+1).compareTo(value)<0){
		add(i,value);
	    }
	    //add to the correct spot.
	    //you may still use super.add(index,value)
	}
	return true;

    }

}
