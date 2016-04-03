package Prog3_Trab1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

final class TvSeriesSeason extends Media implements Serializable {

	private static final long serialVersionUID = 1L;
	protected static final int mediaTypeId = 1;
	private List<Person> mainActors = new ArrayList<Person>();
	private String seriesName;
	private int seasonLength;
	private int seasonNumber;
	
	public TvSeriesSeason(long mediaId,String name,String seriesName,int seasonLength,int seasonNumber,Genre genre) {
		super(mediaId,TvSeriesSeason.mediaTypeId,name,genre);
		this.seasonLength = seasonLength;
		this.seasonNumber = seasonNumber;
		this.seriesName = seriesName;
	}

	public final ListIterator<Person> getMainActorsIterator() {
		return this.mainActors.listIterator();
	}
	
	public final String getSeriesName() {
		return this.seriesName;
	}

	public final int getSeasonLength() {
		return this.seasonLength;
	}

	public final int getSeasonNumber() {
		return this.seasonNumber;
	}

	public final void setSeasonLength(int seasonLength) {
		this.seasonLength = seasonLength;
	}
	
	public final void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public final void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
	}
	
	public final void addMainActors(Person actor) {
		this.mainActors.add(actor);
	}
	
	public static boolean isTvSeriesSeason(Media media) {
		return media.getMediaTypeId() == TvSeriesSeason.mediaTypeId;
	}
}
