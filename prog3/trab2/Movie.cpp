/**
 * Movie class implementation
 */

#include "Movie.hpp"

// Static values
int Movie::mediaTypeId = 2;

// Constructor
Movie::Movie(const long id, const string& name, Person& director, const int featureLengh, Genre& genre)
    : Media(id, mediaTypeId, name, genre), director(&director)
    , featureLength(featureLengh)
    {}

// Functions
void Movie::addActor(Person& person) {
    this->actors.push_back(&person);
}
bool Movie::isMovie(Media& media) {
    return (media.getTypeId() == mediaTypeId);
}

// Getters
int Movie::getFeatureLength() {
    return featureLength;
}
Person& Movie::getDirector() {
    return *director;
}
list<Person*>& Movie::getActors() {
    return actors;
}

// Setters
void Movie::setFeatureLength(const int length) {
    featureLength = length;
}
void Movie::setDirector(Person& person) {
    director = &person;
}

// Destructor
Movie::~Movie() {}
