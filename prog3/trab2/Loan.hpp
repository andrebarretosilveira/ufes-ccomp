/**
 * Loan class interface
 */

#ifndef LOAN
#define LOAN

#include <string>
using namespace std;

class Media;

class Loan {

private:
    string person;
    Media& lentMedia;
    time_t startDate;
    time_t limitReturnDate;
    time_t returnDate;

public:
    // Constructors
    Loan(const string&, Media&, const time_t);
    Loan(const string&, Media&, const time_t, const time_t);

    // Functions
    long calculateDaysLate();
    bool isReturned();
    bool isLate();

    // Getters
    string& getPersonName();
    Media& getLentMedia();
    time_t getStartDate();

    // Setters
    void setReturnDate(const time_t returnDate);

    // Destructor
    ~Loan();
};

#endif
