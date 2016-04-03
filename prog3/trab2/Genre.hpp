/**
 * Genre class interface
 */

#ifndef GENRE_H
#define GENRE_H

#include <iostream>
#include <string>
#include <list>
using namespace std;

// Forward declaration
class Media;

class Genre {

private:
    string initials;
    string name;
    list<Media*> medias;

public:
    // Constructor
    Genre(const string&, const string&);

    // Functions
    void addMedia(Media&);
    int getMediaCount();

    // Getters
    string& getInitials();
    string& getName();

    // Setters
    void setName(const string&);
    void setInitials(const string&);

    // Destructor
    ~Genre();

};

#endif
