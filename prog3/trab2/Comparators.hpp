/**
 * Comparators class interface
 */

#ifndef COMPARATORS_H
#define COMPARATORS_H

#include <string>
#include "Collator.hpp"
#include "Media.hpp"
#include "Person.hpp"
#include "TvSeriesSeason.hpp"
#include "Loan.hpp"
#include "Genre.hpp"
#include "Book.hpp" 
#include "Movie.hpp"

class Media;
class Loan;
class Genre;
class Book;
class Movie;

namespace Comparators {

bool TvSeriesWatchComparator( TvSeriesSeason*, TvSeriesSeason*);
bool PersonComparator(Person*,Person*);
bool LoanComparator(Loan*,Loan*);
bool GenreComparator(Genre*,Genre*);
bool WishListMediaComparator(Media*, Media*);
string getMediaTypeString(Media& m);

}

#endif
