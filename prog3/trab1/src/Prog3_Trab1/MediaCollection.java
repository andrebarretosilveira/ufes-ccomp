package Prog3_Trab1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ListIterator;
import java.util.LinkedList;

final class MediaCollection implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Map<Long,Media> mediaMap = new HashMap<Long,Media>();
	private List<Loan> loanList = new LinkedList<Loan>();
	private List<Media> wishList = new LinkedList<Media>();
	private Map<String,Genre> genreTree = new TreeMap<String,Genre>();
	private Map<Long,Person> personHash = new TreeMap<Long,Person>();

	public void addMedia(Media media) {
		this.mediaMap.put(media.getMediaId(),media);
		Genre mediaGenre = this.genreTree.get(media.getGenre().getInitials());
		mediaGenre.addMedia(media);
		media.setGenre(mediaGenre);
		
		if(media.getConsumptionStatus(Media.WANT)) {
			this.wishList.add(media);
		}
		
		if(Book.isBook(media)) {
			this.addBook((Book) media);
		}
		else if(Movie.isMovie(media)) {
			this.addMovie((Movie) media);
		}
		else if(TvSeriesSeason.isTvSeriesSeason(media)) {
			this.addTvSeriesSeason((TvSeriesSeason) media);
		}
	}
	
	private void addBook(Book book) {
		ListIterator<Person> authorIterator = book.getAuthorIterator();
		while(authorIterator.hasNext()) {
			Person author = authorIterator.next();
			Person containedAuthor = this.personHash.get(author.getPersonId());
			if(containedAuthor != null) {
				containedAuthor.addMedia((Media) book);
				authorIterator.set(containedAuthor);
			}
		}
	}
	
	private void addMovie(Movie movie) {
		Person containedDirector = this.personHash.get(movie.getDirector().getPersonId());
		if(containedDirector != null) {
			containedDirector.addMedia((Media) movie);
			movie.setDirector(containedDirector);
		}
		ListIterator<Person> mainActorsIterator = movie.getMainActorsIterator();
		while(mainActorsIterator.hasNext()) {
			Person actor = mainActorsIterator.next();
			Person containedActor = this.personHash.get(actor.getPersonId());
			if(containedActor != null) {
				containedActor.addMedia((Media) movie);
				mainActorsIterator.set(containedActor);
			}
		}
	}
	
	private void addTvSeriesSeason(TvSeriesSeason season) {
		ListIterator<Person> mainActorsIterator = season.getMainActorsIterator();
		while(mainActorsIterator.hasNext()) {
			Person actor = mainActorsIterator.next();
			Person containedActor = this.personHash.get(actor.getPersonId());
			if(containedActor != null) {
				containedActor.addMedia((Media) season);
				mainActorsIterator.set(containedActor);
			}
		}
	}
	
	public void addGenre(Genre genre) {
		this.genreTree.put(genre.getInitials(),genre);
	}
	
	public void addPerson(Person person) {
		this.personHash.put(person.getPersonId(),person);
	}
	
	public void lend(Loan loan) {
		this.loanList.add(loan);
	}
	
	public Media getMediaById(long mediaId) {
		return this.mediaMap.get(mediaId);
	}
	
	public ListIterator<Media> getWishListIterator() {
		return this.wishList.listIterator();
	}
	
	public ListIterator<Media> getSortedWishListIterator(Comparator<Media> mediaComp) {
		Collections.sort(this.wishList,mediaComp);
		return this.wishList.listIterator();
	}
	
	public ListIterator<Loan> getLoanIterator() {
		return this.loanList.listIterator();
	}
	
	public ListIterator<Loan> getSortedLoanIterator(Comparator<Loan> loanComp) {
		Collections.sort(this.loanList,loanComp);
		return this.loanList.listIterator();
	}
	
	public Collection<Media> getMedias() {
		return this.mediaMap.values();
	}
	
	public ListIterator<Genre> getGenreIterator() {
		List<Genre> genreList = new ArrayList<Genre>(this.genreTree.values());
		return genreList.listIterator();
	}
	
	public ListIterator<Genre> getSortedGenreIterator(Comparator<Genre> comparator) {
		List<Genre> genreList = new ArrayList<Genre>(this.genreTree.values());
		Collections.sort(genreList,comparator);
		return genreList.listIterator();
	}
	
	public ListIterator<Person> getPersonIterator() {
		List<Person> personList = new ArrayList<Person>(this.personHash.values());
		return personList.listIterator();
	}
	
	public ListIterator<Person> getSortedPersonIterator(Comparator<Person> comparator) {
		List<Person> personList = new ArrayList<Person>(this.personHash.values());
		Collections.sort(personList,comparator);
		return personList.listIterator();
	}
	
	public Loan getLoanByPersonName(String name) {
		for(Loan loan: this.loanList) {
			if(loan.getPersonName() == name) {
				return loan;
			}
		}
		return null;
	}
	
	public Genre getGenreByInitials(String initials) {
		return this.genreTree.get(initials);
	}
	
	public Person getPersonByCode(long personCode) {
		return this.personHash.get(personCode);
	}


	public void writeObjectToFile(String filePath) throws ProgramException {
		File file = new File(filePath);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Erro de I/O");
				throw new ProgramException();
			}
		}
		try(ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file))) {
			objectOutput.writeObject(this);
			objectOutput.close();
		} catch(IOException e) {
			System.out.println("Erro de I/O");
			throw new ProgramException();
		}
	}
	
	public static MediaCollection readObjectFromFile(String filePath) throws ProgramException {
		
		try(ObjectInputStream ObjectInput = new ObjectInputStream(new FileInputStream(filePath));) {
			MediaCollection mediaCollection = (MediaCollection) ObjectInput.readObject();
			
			ObjectInput.close();
			return (MediaCollection) mediaCollection;
		} catch(IOException e) {
			System.out.println("Erro de I/O");
			throw new ProgramException();
		} catch(ClassNotFoundException e) {
			System.out.println("Unexpected Exception");
			throw new ProgramException();
		}
	}
}
