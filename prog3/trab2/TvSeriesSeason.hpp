/**
 * TvSeriesSeason class interface
 */

#ifndef TVSERIESEASON_H
#define TVSERIESEASON_H

#include "Media.hpp"

// Forward declarations
class Person;
class Media;

class TvSeriesSeason : public Media {

private:
    list<Person*> actors;
    string seriesName;
    int seasonLength, seasonNumber;

public:

    //Attributes
    static int mediaTypeId;

    // Constructor
    TvSeriesSeason(const long, const string&, const string&, const int, const int, Genre&);

    // Functions
    void addActor(Person&);
    static bool isTvSeriesSeason(Media&);

    // Getters
    string getSeriesName();
    int getSeasonNumber();
    int getSeasonLength();
    list<Person*> getActors();

    // Setters
    void setSeriesName(const string&);
    void setSeasonNumber(const int);
    void setSeasonLength(const int);

    // Destructor
    ~TvSeriesSeason();


};

#endif
