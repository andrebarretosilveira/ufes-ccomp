/**
 * Person class implementation
 */

#include "Person.hpp"

// Constructor
Person::Person(const long id, const string& name)
    : id(id), name(name)
    {}

// Functions
void Person::addMedia(Media& media) {
    this->medias.push_back(&media);
}

// Getters
long Person::getId() {
    return id;
}
string& Person::getName() {
    return name;
}
list<Media*>& Person::getMedias() {
    return medias;
}
int Person::getMediaCount() {
    return medias.size();
}

// Setters
void Person::setId(const long id) {
    this->id = id;
}
void Person::setName(const string& name) {
    this->name = name;
}

// Destructor
Person::~Person() {}
