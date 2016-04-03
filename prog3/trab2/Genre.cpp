/**
 * Genre class implementation
 */

#include "Genre.hpp"

// Constructor
Genre::Genre(const string& initials, const string& name)
    : initials(initials), name(name)
    {}

// Functions
void Genre::addMedia(Media& media) {
    this->medias.push_back(&media);
}

int Genre::getMediaCount() {
    return this->medias.size();
}

// Getters
string& Genre::getInitials() { return this->initials; }
string& Genre::getName() { return this->name; }

// Setters
void Genre::setName(const string& s) { this->name = s; }
void Genre::setInitials(const string& s) { this->initials = s; }

// Destructor
Genre::~Genre() {}
