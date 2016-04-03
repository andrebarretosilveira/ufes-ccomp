/**
 * MediaCollection class interface
 */

#include "MediaCollection.hpp"

// Constructor
MediaCollection::MediaCollection() {}

// Private functions
void MediaCollection::addBook(Book& book) {
    list<Person*> authors = book.getAuthors();
    list<Person*>::iterator authorIterator = authors.begin();
    for (; authorIterator != authors.end(); authorIterator++) {
        Person* author = *authorIterator;
        Person* containedAuthor = this->personMap[author->getId()];
        if(containedAuthor != nullptr) {
            containedAuthor->addMedia((Media&) book);
            *authorIterator = containedAuthor;
        }
    }
}
void MediaCollection::addMovie(Movie& movie) {
    Person* containedDirector = this->personMap[movie.getDirector().getId()];
    if(containedDirector != nullptr) {
        containedDirector->addMedia((Media&) movie);
        movie.setDirector(*containedDirector);
    }

    list<Person*> actors = movie.getActors();
    list<Person*>::iterator actorIterator = actors.begin();
    for (; actorIterator != actors.end(); ++actorIterator) {
        Person* actor = *actorIterator;
        Person* containedActor = this->personMap[actor->getId()];
        if(containedActor != nullptr) {
            containedActor->addMedia((Media&) movie);
            *actorIterator = containedActor;
        }
    }
}
void MediaCollection::addTvSeriesSeason(TvSeriesSeason& season) {
    list<Person*> actors = season.getActors();
    list<Person*>::iterator actorIterator = actors.begin();
    for (; actorIterator != actors.end(); actorIterator++) {
        Person* actor = *actorIterator;
        Person* containedActor = this->personMap[actor->getId()];
        if(containedActor != nullptr) {
            containedActor->addMedia((Media&) season);
            *actorIterator = containedActor;
        }
    }
}

// Public Functions
void MediaCollection::addMedia(Media& media) {
    this->mediaMap.insert(pair<long,Media*>(media.getId(),&media));
    Genre& mediaGenre = media.getGenre();
    mediaGenre.addMedia(media);

    if(media.getConsumptionStatus(Media::WANT)) {
        this->wishList.push_back(&media);
    }

    if(Book::isBook(media)) {
        this->addBook((Book&) media);
    }
    else if(Movie::isMovie(media)) {
        this->addMovie((Movie&) media);
    }
    if(TvSeriesSeason::isTvSeriesSeason(media)) {
        this->addTvSeriesSeason((TvSeriesSeason&) media);
    }
}

void MediaCollection::addGenre(Genre& genre) {
    this->genreMap.insert(pair<string,Genre*>(genre.getInitials(),&genre));
}

void MediaCollection::addPerson(Person& person) {
    this->personMap.insert(pair<long,Person*>(person.getId(),&person));
}

void MediaCollection::lend(Loan& loan) {
    this->loanList.push_back(&loan);
}

Loan* MediaCollection::getLoanByPersonName(const string& name) {
    list<Loan*>::iterator loanIterator;
    for (loanIterator = this->loanList.begin(); loanIterator != this->loanList.end(); loanIterator++) {
        if((*loanIterator)->getPersonName() == name)
            return (*loanIterator);
    }
    return nullptr;
}

Media* MediaCollection::getMediaById(const long mediaId) {
    map<long,Media*>::iterator it;
    it = mediaMap.find(mediaId);
    if(it == mediaMap.end())
        return nullptr;
    else
        return it->second;
}

Genre* MediaCollection::getGenreByInitials(const string& initials) {
    map<string,Genre*>::iterator it;
    it = genreMap.find(initials);
    if(it == genreMap.end())
        return nullptr;
    else
       return it->second;
}

Person* MediaCollection::getPersonByCode(const long code) {
    map<long,Person*>::iterator it;
    it = personMap.find(code);
    if(it == personMap.end())
        return nullptr;
    else
        return personMap[code];
}

list<Media*>& MediaCollection::getWishList() {
    return this->wishList;
}

list<Person*> MediaCollection::getPeopleFromMap() {
    list<Person*> people;
    for(map<long,Person*>::iterator it = this->personMap.begin(); it != this->personMap.end(); ++it) {
        people.push_back(it->second);
    }
    return people;
}

list<Media*> MediaCollection::getMediasFromMap() {
    list<Media*> medias;
    for(map<long,Media*>::iterator it = this->mediaMap.begin(); it != this->mediaMap.end(); ++it) {
        medias.push_back(it->second);
    }
    return medias;
}

list<Genre*> MediaCollection::getGenresFromMap() {
    list<Genre*> genres;
    for(map<string,Genre*>::iterator it = this->genreMap.begin(); it != this->genreMap.end(); ++it) {
        genres.push_back(it->second);
    }
    return genres;
}

list<Loan*>& MediaCollection::getLoanList() {
    return this->loanList;
}

map<string,Genre*>& MediaCollection::getGenreMap() {
    return this->genreMap;
}

map<long,Person*>& MediaCollection::getPersonMap() {
    return this->personMap;
}

map<long,Media*>& MediaCollection::getMediaMap() {
    return this->mediaMap;
}

MediaCollection::~MediaCollection() {
    
    for(map<long,Media*>::iterator it = this->mediaMap.begin(); it != this->mediaMap.end();it++) {
        if(Book::isBook(*it->second)) {
            delete ((Book*) it->second);
        }
        else if(Movie::isMovie(*it->second)) {
            delete ((Movie*) it->second);
        }
        else if(TvSeriesSeason::isTvSeriesSeason(*it->second)) {
            delete ((TvSeriesSeason*) it->second);
        }
    }
    for(map<long,Person*>::iterator it = this->personMap.begin(); it != this->personMap.end();it++) {
        delete (it->second);
    }
    for(map<string,Genre*>::iterator it = this->genreMap.begin(); it != this->genreMap.end();it++) {
        delete (it->second);
    }

}
