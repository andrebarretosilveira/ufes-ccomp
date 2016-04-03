/**
 * TvSeriesSeason class implementation
 */

#include "TvSeriesSeason.hpp"

// Static values
int TvSeriesSeason::mediaTypeId = 1;

// Constructor
TvSeriesSeason::TvSeriesSeason(const long id, const string& name, const string& seriesName,
    const int seasonLengh, const int seasonNumber, Genre& genre)
    : Media(id, mediaTypeId, name, genre), seriesName(seriesName)
    , seasonLength(seasonLengh), seasonNumber(seasonNumber)
    {}

// Functions
void TvSeriesSeason::addActor(Person& person) {
    this->actors.push_back(&person);
}
bool TvSeriesSeason::isTvSeriesSeason(Media& media) {
    return (media.getTypeId() == mediaTypeId);
}

// Getters
string TvSeriesSeason::getSeriesName() {
    return seriesName;
}
int TvSeriesSeason::getSeasonLength() {
    return seasonLength;
}
int TvSeriesSeason::getSeasonNumber() {
    return seasonNumber;
}
list<Person*> TvSeriesSeason::getActors() {
    return actors;
}

// Setters
void TvSeriesSeason::setSeriesName(const string& seriesName) {
    this->seriesName = seriesName;
}
void TvSeriesSeason::setSeasonNumber(const int num) {
    this->seasonNumber = num;
}
void TvSeriesSeason::setSeasonLength(const int length) {
    this->seasonLength = length;
}

// Destructor
TvSeriesSeason::~TvSeriesSeason() {}
