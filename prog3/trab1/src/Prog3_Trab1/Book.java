package Prog3_Trab1;

import java.util.List;
import java.util.ListIterator;
import java.io.Serializable;
import java.util.ArrayList;

final class Book extends Media implements Serializable {

	private static final long serialVersionUID = 1L;
	protected static final int mediaTypeId = 3;
	private List<Person> authors = new ArrayList<Person>();
	private int numberPages;
	
	
	public Book(long mediaId,String name,int numberPages,Genre genre) {
		super(mediaId,Book.mediaTypeId,name,genre);
		this.numberPages = numberPages;
	}

	public final ListIterator<Person> getAuthorIterator() {
		return this.authors.listIterator();
	}

	public final int getNumberPages() {
		return numberPages;
	}
	
	public final void addAuthors(Person authorName) {
		this.authors.add(authorName);
	}
	
	public static boolean isBook(Media media) {
		return media.getMediaTypeId() == Book.mediaTypeId;
	}
	
}
