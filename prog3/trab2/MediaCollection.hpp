/**
 * MediaCollection class interface
 */

#ifndef MEDIACOLLECTION_H
#define MEDIACOLLECTION_H

#include <map>
#include <list>
#include <string>
#include "Media.hpp"
#include "Genre.hpp"
#include "Person.hpp"
#include "Loan.hpp"
#include "Movie.hpp"
#include "Book.hpp"
#include "TvSeriesSeason.hpp"

using namespace std;

class MediaCollection {

private:
	// Private attributes
	list<Loan*> loanList;
	list<Media*> wishList;
	map<long,Media*> mediaMap;
	map<long,Person*> personMap;
	map<string,Genre*> genreMap;

	// Private functions
	void addBook(Book&);
	void addMovie(Movie&);
	void addTvSeriesSeason(TvSeriesSeason&);


public:
    // Constructor
    MediaCollection();

    // Functions
	void addMedia(Media&);
	void addGenre(Genre&);
	void addPerson(Person&);
	void lend(Loan&);

    // Getters
    list<Media*>& getWishList();
	list<Person*> getPeopleFromMap();
	list<Media*> getMediasFromMap();
	list<Genre*> getGenresFromMap();
    list<Loan*>& getLoanList();
    map<string,Genre*>& getGenreMap();
    map<long,Person*>& getPersonMap();
    map<long,Media*>& getMediaMap();
	Media* getMediaById(const long);
	Loan* getLoanByPersonName(const string&);
	Genre* getGenreByInitials(const string&);
	Person* getPersonByCode(const long);
	~MediaCollection();
};

#endif
