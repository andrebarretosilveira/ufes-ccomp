/**
 * Book class interface
 */

#ifndef BOOK_H
#define BOOK_H

#include "Media.hpp"
using namespace std;

// Forward declarations
class Person;

class Book : public Media {

private:
    list<Person*> authors;
    int numberOfPages;

public:

    //Attributes
    static int mediaTypeId;

    // Constructor
    Book(const long, const string&, const int, Genre&);

    // Functions
    void addAuthor(Person&);
    static bool isBook(Media&);
    list<Person*>::iterator getAuthorIterator();
    string toString();

    // Getters
    int getNumberOfPages();
    list<Person*> getAuthors();

    // Setters
    void setNumberOfPages(const int);

    // Destructor
    ~Book();
};

#endif
