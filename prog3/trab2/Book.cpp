/**
 * Book class implementation
 */

#include "Book.hpp"

// Static values
int Book::mediaTypeId = 3;

// Constructor
Book::Book(const long id, const string& name, const int numberOfPages, Genre& genre)
    : Media(id, mediaTypeId, name, genre)
    , numberOfPages(numberOfPages)
    {}

// Functions
void Book::addAuthor(Person& person) {
    this->authors.push_back(&person);
}

bool Book::isBook(Media& media) {
    return (media.getTypeId() == mediaTypeId);
}

// Getters
int Book::getNumberOfPages() { return numberOfPages; }
list<Person*> Book::getAuthors() { return authors; }

// Setters
void Book::setNumberOfPages(const int num) {
    numberOfPages = num;
}

// Destructor
Book::~Book() {}
