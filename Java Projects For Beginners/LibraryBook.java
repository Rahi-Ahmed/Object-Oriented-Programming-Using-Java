
public class LibraryBook {
	
	// Attributes
	private String title;
	private String author;
	private int year;
	private boolean borrowed;
	
	// Parameterized constructor
	public LibraryBook(String title, String author, int year, boolean borrowed) {
		this.author = author;
		this.title = title;
		this.year = year;
		this.borrowed = borrowed;
	}
	
	// Default constructor
	public LibraryBook() {
		this.author = "Robert";
		this.title = "Rich Dad Poor Dad";
		this.year = 1998;
		this.borrowed = true;
	}
	
	// Finalizer method
	@Override
	protected void finalize() throws Throwable {
		// Perform cleanup operation here
		System.out.println("Persofming cleanup for author: " + author);
	}
	
	// Getter and setter
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean getBowrrowed() {
		return borrowed;
	}
	
	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}
	
	public void borrowBook() {
		this.borrowed = true;
	}
	
	public void returnBook() {
		this.borrowed = false;
	}
	
	public boolean isBorrowed() {
		return borrowed;
	}
	
    // Using StringBuffer to append title and author
    public String appendTitleAndAuthor() {
        StringBuffer sb = new StringBuffer();
        sb.append("Title: ").append(title).append(", Author: ").append(author);
        return sb.toString();
    }

    // Check if author's name contains a specific substring
    public boolean isAuthorContains(String substring) {
        return author.contains(substring);
    }

    // Display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Borrowed: " + (borrowed ? "Yes" : "No"));
    }



	public static void main(String[] args) {
		
		LibraryBook book = new LibraryBook("Effective Java", "Joshua Bloch", 2008, false);

        // Test the methods
        book.displayDetails();
        System.out.println("\nBorrowing the book...");
        book.borrowBook();
        book.displayDetails();

        System.out.println("\nUsing StringBuffer: " + book.appendTitleAndAuthor());
        System.out.println("Author contains 'Joshua'? " + book.isAuthorContains("Joshua"));

	}

}
