class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;
    public CirculatingBook(String authorx, String titlex, String ISBNx, String callNumberx){
	super(authorx,titlex,ISBNx,callNumberx);
	//	LibraryBook(authorx,titlex,ISBNx,callNumberx);
    }
    public String toString(){
	return super.toString()+ ", "+currentHolder+", "+dueDate;
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
    public void checkout(String patron, String due){
        currentHolder=patron;
	dueDate=due;
    }
    public void returned(){
	currentHolder=null;
	dueDate=null;
    }
    public String circulationStatus(){
	if (currentHolder!=null && dueDate!=null){
	    return "current Holder is: "+currentHolder+"/n Due Date is: "+dueDate;
	}
	else{
	    return "book available on shelves";
	}
    }
}
/*fields
currentHolder (patron, if any, who checked out the book)
dueDate (when book should be returned)
constructors and methods
a constructor using 4 parameters for an author, title, ISBN number, and call number. When constructed, currentHolder and dueDate should be null.
getters and setters
void checkout handles processing when a book is checked out, storing the patron's name and the date the book is due in the fields.
void returned handles process when a book is returned (currentHolder and dueDate are set to null).
String circulationStatus should return the currentHolder's name and due date if the book has been checked out; or "book available on shelves" if the book is available.
String toString from LibraryBook should be augmented with current holder and due date, if applicable.*/
