class SuperArray{
    private String[] data;
    private int size;
    public SuperArray(){
	size=10;
	data= new String[10];
    }
    public SuperArray(int startingCapacity){
	size=startingCapacity;
	data=new String[startingCapacity];
    }
    public void clear(){
	data= new String[10];
	size=10;
    }
    public int size(){
	return size;
    }
    public boolean add(String element){
	size++;
	String [] n=new String[size];
	for (int i=0; i<n.length-1;i++){
	    n[i]=data[i];
	}
	n[size-1]=element;
	data=n;
	return (data[size-1]).equals(element);
    }
    public String toString(){
	String line="[";
	for(int i=0;i<size-1;i++){
	    line+=data[i]+",";
	}
	line+=data[size-1]+"]";
	return line;
    }
    public String get(int index){
	if (index < 0 || index > size){
	    System.out.println("index is out of range");
	    return null;
	}
	else{
	    return data[index];
	}
    }
    public String set(int index, String element){
	if (index < 0 || index > size){
	    System.out.println("index is out of range");
	    return null;
	}
	else{
	    String a=data[index];
	    data[index]=element;
	    return a;
	}
    }

    // phase 2
    public void resize(){
	String []copy= new String[2*size];
	for (int i=0; i<size; i++){
	    copy[i]=data[i];
	}
	data=copy;
	size=size*2;
    }

    //Phase 3
    public boolean contains(String target){
	for (int i=0;i<size;i++){
	    if (data[i]==target){
		return true;
	    }
	}
	return false;
    }
    public int indexOf(String target){
	for (int i=0;i<size;i++){
	    if (data[i]==target){
		return i;
	    }
	}
	return -1;
    }
    public int lastIndexOf(String target){
	for (int i=size-1;i>-1;i--){
	    if (data[i]==target){
		return i;
	    }
	}
	return -1;
    }

    public void add(int index, String element){
	if (index < 0 || index > size){
	    System.out.println("index is out of range");
	}
	else{
	    String[] arr=new String[size+1];
	    for (int i=0;i<index;i++){
		arr[i]=data[i];
	    }
	    arr[index]=element;
	    for (int i=index;i<size;i++){
		arr[i+1]=data[i];
	    }
	    data=arr;
	    size++;
	}
    }

    public String remove(int index){
	if (index < 0 || index > size){
	    System.out.println("index is out of range");
	    return null;
	}
	else{
	    String item=data[index];
	    String[] arr=new String[size-1];
	    for (int i=0;i<index;i++){
		arr[i]=data[i];
	    }
	    for (int i=index+1;i<size;i++){
		arr[i-1]=data[i];
	    }
	    data=arr;
	    size--; 
	    return item;
	}
    }

    public boolean remove(String element){
	for (int i=0;i<size;i++){
	    if ((data[i])==(element)){
		String[] x=new String[size-1];
		for (int t=0;t<i;t++){
		    x[t]=data[t];
		}
		for (int y=i+1;y<size;y++){
		    x[y-1]=data[y];
		}
		data=x;
		size--;
		return true;
	    }
	}
	return false;
    }
}
