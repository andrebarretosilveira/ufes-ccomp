/**
 * Person class interface
 */

#ifndef PERSON_H
#define PERSON_H

#include <iostream>
#include <string>
#include <list>

using namespace std;

class Media;

class Person {

private:
    long id;
    string name;
    list<Media*> medias;

public:
    // Constructor
    Person(const long, const string&);

    // Functions
    void addMedia(Media&);

    // Getters
    long getId();
    int getMediaCount();
    string& getName();
    list<Media*>& getMedias();

    // Setters
    void setId(const long);
    void setName(const string&);

    // Destructor
    ~Person();

};

#endif
