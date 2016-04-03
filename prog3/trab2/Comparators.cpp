/**
 * Comparators class implementation
 */

#include "Comparators.hpp"

namespace Comparators {

bool TvSeriesWatchComparator(TvSeriesSeason* serie1,TvSeriesSeason* serie2) {
    TvSeriesSeason s1 = *serie1;
    TvSeriesSeason s2 = *serie2;
	string cs1 = s1.getSeriesName();
	string cs2 = s2.getSeriesName();
	return stringCompare(cs1,cs2);
}

bool PersonComparator(Person* person1,Person* person2) {
    Person p1 = *person1;
    Person p2 = *person2;
	string p1Name = p1.getName();
	string p2Name = p2.getName();
	return stringCompare(p1Name,p2Name);
}

bool LoanComparator(Loan* loan1, Loan* loan2) {
	bool cmp = false;
    Loan l1 = *loan1;
    Loan l2 = *loan2;
	string loanName1 = l1.getPersonName();
	string loanName2 = l2.getPersonName();

	if(l1.getStartDate() < l2.getStartDate()) {
		cmp = false;
	}
	else if(l1.getStartDate() > l2.getStartDate()) {
		cmp = true;
	}
	else {
		cmp = stringCompare(loanName1,loanName2);
	}
	return cmp;
}

bool GenreComparator(Genre* genero1, Genre* genero2) {
	bool cmp;
    Genre g1 = *genero1;
    Genre g2 = *genero2;
	string g1Name = g1.getName();
	string g2Name = g2.getName();


	if(g1.getMediaCount() > g2.getMediaCount()) {
		cmp = true;
	}
	else if(g1.getMediaCount() < g2.getMediaCount()) {
		cmp = false;
	}
	else {
		cmp = stringCompare(g1Name,g2Name);
	}
	return cmp;
}

string getMediaTypeString(Media& m) {
	string typeString = "";
	if(Book::isBook(m)) {
		typeString = "Livro";
	}
	else if(Movie::isMovie(m)) {
		typeString = "Filme";
	}
	else if(TvSeriesSeason::isTvSeriesSeason(m)) {
		typeString = "Série";
	}	

	return typeString;
}

bool WishListMediaComparator(Media* media1, Media* media2) {
	bool cmp1,cmp2;
    Media m1 = *media1;
    Media m2 = *media2;

	string m1StringType = getMediaTypeString(m1);
	string m2StringType = getMediaTypeString(m2);
	cmp1 = stringCompare(m1StringType,m2StringType);
	cmp2 = stringCompare(m2StringType,m1StringType);
	if(cmp1 == cmp2) {
		if(m1.getPrice() > m2.getPrice()) {
			cmp1 = true;
		}
		else if(m1.getPrice() < m2.getPrice()) {
			cmp1 = false;
		}
		else {
			cmp1 = stringCompare(m1.getName(),m2.getName());
		}
	}
	return cmp1;
}

}
