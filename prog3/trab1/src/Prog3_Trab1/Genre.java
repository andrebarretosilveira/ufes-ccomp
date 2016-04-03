package Prog3_Trab1;

import java.util.List;
import java.io.Serializable;
import java.util.LinkedList;

final class Genre implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String initials;
	private String name;
	private List<Media> medias;
	
	public Genre(String initials) {
		this.initials = initials;
		this.medias = new LinkedList<Media>();
	}
	
	public String getInitials() {
		return initials;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addMedia(Media media) {
		this.medias.add(media);
	}
	
	public int getMediaCount() {
		return this.medias.size();
	}
	
	@Override
	public String toString() {
		return this.initials+";"+this.name;
	}
}