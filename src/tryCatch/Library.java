package tryCatch;

public class Library {
    private String name;
    private String city;
    private Book books[] = new Book[3];
    private int index = 0;

    public Library() {
    }

    public Library(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Book[] getBooks() {
        return books;
    }

    public int getIndex() {
        return index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void addBook(Book book){
        try{
            books[index] = book;
            index++;
        }catch(Exception e){
            System.out.println("The library is full");
        }
    }

    public void printBooks(){
        for(int i = 0; i < index; i++){
            try {
                System.out.println(books[i].getData( ));
            }catch(NullPointerException e){
                System.out.println("The book is empty");
            }
        }
    }
}
