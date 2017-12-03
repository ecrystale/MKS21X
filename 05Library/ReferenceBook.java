class ReferenceBook extends LibraryBook{
    private String collection;
    public ReferenceBook(String authorx, String titlex, String ISBNx, String callNumberx, String collectionx){
	super(authorx,titlex,ISBNx,callNumberx);
	//	LibraryBook(authorx,titlex,ISBNx,callNumberx);
	collection=collectionx;
    }
    public String toString(){
	return super.toString()+", "+collection;
    }
    public String getAuthor(){
	return super.getAuthor();
    }
    public String getTitle(){
	return super.getTitle();
    }
    public String getISBN(){
	return super.getISBN();
    }
    public String getcallNumber(){
	return super.getcallNumber();
    }
    public String getCollection(){
	return collection;
    }
    public void setAuthor(String newa){
	super.setAuthor(newa);
    }
    public void setTitle(String newt){
	super.setTitle(newt);
    }
    public void setISBN(String newi){
	super.setISBN(newi);
    }
    public void setcallNumber(String newc){
	super.setcallNumber(newc);
    }
    public void setcollection(String newco){
	collection=newco;
    }
    public void checkout(String patron, String due){
	System.out.println(patron+"cannot check out a reference book");
    }
    public void returned(){
	System.out.println("reference book could not have been checked out -- return impossible");
    }
    public String circulationStatus(){
	return "non-circulating reference book";
    }
}
/*
fields
String collection
constructors and methods
a constructor using 5 parameters for an author, title, ISBN number, call number, and collection
getters and setters
void checkout is not allowed for reference books, so the method should print that the patron "cannot check out a reference book".  (This should have been designed as an exception.)
void returned is not allowed, and should print "reference book could not have been checked out -- return impossible". (This should have been designed as an exception.)
String circulationStatus should return "non-circulating reference book".
String toString from LibraryBook should be augmented with the collection information*/
