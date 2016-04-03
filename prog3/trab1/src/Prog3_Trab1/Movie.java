package Prog3_Trab1;

import java.util.List;
import java.util.ListIterator;
import java.io.Serializable;
import java.util.ArrayList;

final class Movie extends Media implements Serializable {

	private static final long serialVersionUID = 1L;
	protected static final int mediaTypeId = 2;
	private Person director;
	private List<Person> mainActors = new ArrayList<Person>();
	private int featureLength;
	
	public Movie(long mediaId,String name,Person director,int featureLength,Genre genre) {
		super(mediaId,Movie.mediaTypeId,name,genre);
		this.featureLength = featureLength;
		this.director = director;
	}

	public final Person getDirector() {
		return director;
	}

	public final ListIterator<Person> getMainActorsIterator() {
		return this.mainActors.listIterator();
	}

	public final int getFeatureLength() {
		return featureLength;
	}
	
	public final void setDirector(Person director) {
		this.director = director;
	}

	public final void setFeatureLength(int featureLength) {
		this.featureLength = featureLength;
	}

	public final void addMainActors(Person actor) {
		this.mainActors.add(actor);
	}
	
	public static boolean isMovie(Media media) {
		return media.getMediaTypeId() == Movie.mediaTypeId;
	}
	
}
