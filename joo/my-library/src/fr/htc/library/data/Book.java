package fr.htc.library.data;

public class Book {
	private static int cpt = 10;
	private String cote;
	private String title;
	private String author;
	private int year;

	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.cote = generateCote();
	}

	private String generateCote() {
		// AU17-10
		String authPart = this.author.substring(0, 2);
		int yearPart = this.year % 100;

		String cote = (authPart + yearPart + "-" + cpt++).toUpperCase();

		return cote;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCote() {
		return cote;
	}

	@Override
	public String toString() {
		return "Book [cote=" + cote + ", title=" + title + ", author=" + author + ", year=" + year + "]";
	}

	
}