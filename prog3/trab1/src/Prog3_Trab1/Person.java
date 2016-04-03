package Prog3_Trab1;

import java.util.List;
import java.util.ListIterator;
import java.io.Serializable;
import java.util.LinkedList;

final class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private long personId;
	private String personName;
	private List<Media> medias;
	
	public Person(long personId) {
		this.personId = personId;
		this.medias = new LinkedList<Media>();
	}
	
	public long getPersonId() {
		return this.personId;
	}
	
	public String getPersonName() {
		return this.personName;
	}
	
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public void addMedia(Media media) {
		this.medias.add(media);
	}
	
	public int getMediaCount() {
		return this.medias.size();
	}
	
	public ListIterator<Media> getMediaIterator() {
		return this.medias.listIterator();
	}
	
	@Override
	public String toString() {
		return this.personId+";"+this.personName;
	}
}
