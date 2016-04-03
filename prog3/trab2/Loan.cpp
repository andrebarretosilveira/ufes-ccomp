/**
 * Loan class implementation
 */

#include "Loan.hpp"

// Constructors
Loan::Loan(const string& personName, Media& media, const time_t limitReturnDate)
    : person(personName),lentMedia(media),
    limitReturnDate(limitReturnDate),returnDate(-1)
    {}

Loan::Loan(const string& personName, Media& media, const time_t startDate, const time_t limitReturnDate)
    : person(personName),lentMedia(media),startDate(startDate),
    limitReturnDate(limitReturnDate),returnDate(-1)
    {}

// Functions
bool Loan::isReturned() {
    return this->returnDate != -1;
}

bool Loan::isLate() {
  if(this->limitReturnDate != -1 && this->returnDate != -1) {
    return (difftime(this->limitReturnDate,this->returnDate) < 0);
  }
  return false;
}

long Loan::calculateDaysLate() {
  time_t returnDate;
  long diff_seconds;
  if(this->isReturned()) {
    returnDate = this->returnDate;
  }
  else {
    returnDate = time(0);
  }
  diff_seconds = difftime(this->limitReturnDate,returnDate);
  if(diff_seconds < 0) {
    diff_seconds *= -1;
    return (long) diff_seconds / 86400;
  }
  return 0;
}

// Getters
string& Loan::getPersonName() { return this->person; }
Media& Loan::getLentMedia() { return this->lentMedia; }
time_t Loan::getStartDate() { return this->startDate; }

// Setters
void Loan::setReturnDate(time_t returnDate) {
  this->returnDate = returnDate;
}

// Destructor
Loan::~Loan() {}
