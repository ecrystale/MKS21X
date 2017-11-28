public class Book{
    private String title;
    private String author;
    private String ISBN;
    public Book(){

    }
    public Book(String titlex, String authorx, String ISBNx){
	title=titlex;
	author=authorx;
	ISBN=ISBNx;
    }
    public String getTitle(){
	return title;
    }
    public String getAuthor(){
	return author;
    }
    public String getISBN(){
	return ISBN;
    }
    public String toString(){
	return title+", "+author+", "+ISBN;
    }
}
