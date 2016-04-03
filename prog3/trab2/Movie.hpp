/**
 * Movie class interface
 */

#ifndef MOVIE_H
#define MOVIE_H

#include "Media.hpp"

using namespace std;

// Forward declarations
class Person;
class Media;

class Movie : public Media {

private:
    Person* director;
    list<Person*> actors;
    int featureLength;

public:

    //Atributtes
    static int mediaTypeId;

    // Constructor
    Movie(const long, const string&, Person&, const int, Genre&);

    // Functions
    void addActor(Person&);
    static bool isMovie(Media&);

    // Getters
    int getFeatureLength();
    Person& getDirector();
    list<Person*>& getActors();

    // Setters
    void setFeatureLength(const int);
    void setDirector(Person&);

    // Destructor
    ~Movie();
};

#endif
