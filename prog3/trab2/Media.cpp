/**
 * Media class implementation
 */

#include "Media.hpp"

// Constructor
Media::Media(const long id1, const int typeId, const string& name, Genre& genre)
    : id(id1), typeId(typeId), price(0)
    , name(name), genre(genre)
    {}

// Static values
int Media::NOTWATCHED = 0;
int Media::WATCHED = 1;
int Media::WANT = 2;

// Getters
long Media::getId() {
    return id;
}
int Media::getTypeId() {
    return typeId;
}
double Media::getPrice() {
    return price;
}
bool Media::getConsumptionStatus(const int consumptionStatusType)
{
    if(consumptionStatusType >= 0 && consumptionStatusType <= 2) {
        return this->consumptionStatus[consumptionStatusType];
    }
    return false;
}
string& Media::getName() {
    return name;
}
Genre& Media::getGenre() {
    return genre;
}
Loan* Media::getLoan() {
    return loan;
}

// Setters
void Media::setId(const long id) {
    this->id = id;
}
void Media::setTypeId(const long id) {
    this->typeId = id;
}
void Media::setPrice(const double price) {
    this->price = price;
}
void Media::setConsumptionStatus(int consumptionStatusType, bool value)
{
    if(consumptionStatusType >= 0 && consumptionStatusType <= 2) {
        this->consumptionStatus[consumptionStatusType] = value;
    }
}
void Media::setName(const string& name) {
    this->name = name;
}
void Media::setLoan(Loan& loan) {
    this->loan = &loan;
}

// Destructor
Media::~Media() {}
