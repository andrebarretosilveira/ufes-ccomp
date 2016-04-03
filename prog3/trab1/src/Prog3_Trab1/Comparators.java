package Prog3_Trab1;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

final class TvSeriesWatchComparator implements Comparator<String> {

	@Override
	public int compare(String seriesName1, String seriesName2) {
		Locale brazilLocale = new Locale("pt", "BR");
		Collator collator = Collator.getInstance(brazilLocale);
		return collator.compare(seriesName1, seriesName2);
	}
	
}

final class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {
		Locale brazilLocale = new Locale("pt", "BR");
		Collator collator = Collator.getInstance(brazilLocale);
		return collator.compare(person1.getPersonName(), person2.getPersonName());
	}
	
}

final class LoanComparator implements Comparator<Loan> {

	@Override
	public int compare(Loan loan1, Loan loan2) {
		int cmp;
		cmp = loan1.getStartDate().compareTo(loan2.getStartDate());
		if(cmp < 0) {
			cmp = 1;
		}
		else if(cmp > 0) {
			cmp = -1;
		}
		else if(cmp == 0) {
			Locale brazilLocale = new Locale("pt", "BR");
			Collator collator = Collator.getInstance(brazilLocale);
			cmp = collator.compare(loan1.getPersonName(), loan2.getPersonName());
		}
		return cmp;
	}
	
}

final class GenreComparator implements Comparator<Genre> {

	
	@Override
	public int compare(Genre genre1,Genre genre2) {
		if(genre1.getMediaCount() > genre2.getMediaCount()) {
			return -1;
		}
		else if(genre1.getMediaCount() < genre2.getMediaCount()) {
			return 1;
		}
		else {
			Locale brazilLocale = new Locale("pt", "BR");
			Collator collator = Collator.getInstance(brazilLocale);
			return collator.compare(genre1.getName(), genre2.getName());
		}
	}
}

final class WhishListMediaComparator implements Comparator<Media> {

	private String mediaTypeSymbol(int mediaTypeId) {
		if(Book.mediaTypeId == mediaTypeId) {
			return "Livro";
		}
		else if(Movie.mediaTypeId == mediaTypeId) {
			return "Filme";
		}
		else if(TvSeriesSeason.mediaTypeId == mediaTypeId) {
			return "Série";
		}
		return null;
	}
	
	@Override
	public int compare(Media media1, Media media2) {
		int cmp;
		String media1TypeSymbol = this.mediaTypeSymbol(media1.getMediaTypeId());
		String media2TypeSymbol = this.mediaTypeSymbol(media2.getMediaTypeId());
		cmp = media1TypeSymbol.compareTo(media2TypeSymbol);
		if(cmp == 0) {
			if(media1.getPrice() > media2.getPrice()) {
				return -1;
			}
			else if(media1.getPrice() < media2.getPrice()) {
				return 1;
			}
			else {
				Locale brazilLocale = new Locale("pt", "BR");
				Collator collator = Collator.getInstance(brazilLocale);
				return collator.compare(media1.getName(), media2.getName());
			}
		}
		return cmp;
	}
	
}