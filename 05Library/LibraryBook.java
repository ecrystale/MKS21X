abstract Class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String authory, String titley, String ISBNy, String callNumbery){
	Book a=new Book(authory,titley,ISBNy);
	callNumber=callNumbery;
    }
    public String getAuthor(){
	return a.getAuthor();
    }
    public String getTitle(){
	return a.getTitle();
    }
    public String getISBN(){
	return a.getISBN();
    }
    public String getCN(){
	return callNumber;
    }
    public String setAuthor(){

    }
}
Class LibraryBook models information common for library books. In addition to author, title, and ISBN, library books have call numbers, and library books are stored on the shelves in order by call number. Further, many library books may be able to circulate. In addition to fields and methods of books, any library book has

constructors and methods
a constructor using 4 parameters for an author, title, ISBN number, and call number
getters and setters
abstract void checkout(String patron, String due)
abstract void returned()
abstract String circulationStatus()
compareTo allows comparison/ordering of library books by callNumber, following the format of Java's Comparable interface
toString from Book is augmented with a circulation status and call number
