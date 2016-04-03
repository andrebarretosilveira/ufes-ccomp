/**
 * Media class interface
 */

#ifndef MEDIA_H
#define MEDIA_H

#include <iostream>
#include <string>
#include <vector>
#include <list>

using namespace std;

// Foward declarations
class Genre;
class Loan;
class Person;
class MediaComparator;

class Media {

friend class MediaComparator;

private:
    long id;
	int typeId;
    double price;
    bool consumptionStatus[3];
    string name;
	Genre& genre;
	Loan* loan;

public:
    static int NOTWATCHED;
    static int WATCHED;
    static int WANT;

    // Constructor
    Media(const long id1, const int typeId, const string& name, Genre& genre);

    // Getters
    long getId();
    int getTypeId();
    double getPrice();
    bool getConsumptionStatus(const int);
    string& getName();
    Genre& getGenre();
    Loan* getLoan();

    // Setters
    void setId(const long);
    void setTypeId(const long);
    void setPrice(const double);
    void setConsumptionStatus(int, bool);
    void setName(const string&);
    void setLoan(Loan&);

    // Destructor
    virtual ~Media();
};

#endif
