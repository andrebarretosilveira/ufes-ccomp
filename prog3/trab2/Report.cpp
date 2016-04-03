/**
 * Report class implementation
 */

#include "Report.hpp"

// Constructor
Report::Report(MediaCollection& collection): mediaCollection(collection) {}

// Public functions
void Report::createReport(void (Report::*specialReportGenerator) (ofstream& ofs)) {
    try {
        ofstream ofs (reportPath);
        if(!ofs.good()) {
            ofs.close();
            throw IOException();
        }
        (this->*specialReportGenerator)(ofs);
        ofs.close();
    } catch(IOException& e) {
        cout << e.what() << endl;
        throw ProgramException();
    }
}
void Report::createStatisticsReport(const string& reportPath) {
    this->reportPath = reportPath;
	this->createReport(&Report::generateStatisticsReport);
}
void Report::createMediasByPersonReport(const string& reportPath) {
    this->reportPath = reportPath;
	this->createReport(&Report::generateMediasByPersonReport);
}
void Report::createLoanReport(const string& reportPath) {
    this->reportPath = reportPath;
	this->createReport(&Report::generateLoanReport);
}
void Report::createWishListReport(const string& reportPath) {
    this->reportPath = reportPath;
	this->createReport(&Report::generateWhishListReport);
}

// Private functions
void Report::generateStatisticsReport(ofstream& ofs) {
    long wantToWatchTime = 0;
    long haveWatchedTime = 0;
    map<string,vector<int>> seriesMap = map<string,vector<int>>();

    list<Media*> medias = this->mediaCollection.getMediasFromMap();
    for(list<Media*>::iterator it = medias.begin(); it != medias.end(); it++) {
        Media* media = *it;
        if(TvSeriesSeason::isTvSeriesSeason(*media)) {
            TvSeriesSeason& season = (TvSeriesSeason&) *media;
            vector<int> comsuptionArray(2);

            map<string,vector<int>>::iterator it2;
            it2 = seriesMap.find(season.getSeriesName());
            if(it2 == seriesMap.end())
                seriesMap.insert(pair<string,vector<int>>(season.getSeriesName(),comsuptionArray));
            else
                comsuptionArray = seriesMap[season.getSeriesName()];

            if(media->getConsumptionStatus(Media::WANT)) {
                cout << "WANT" << endl;
                wantToWatchTime += season.getSeasonLength();
                comsuptionArray[0] += 1;
            }
            else if(media->getConsumptionStatus(Media::WATCHED)) {
                cout << "WATCHED" << endl;
                haveWatchedTime += season.getSeasonLength();
                comsuptionArray[1] += 1;
            }
            cout << season.getSeriesName() << " : " << comsuptionArray[0] << " "<< comsuptionArray[1] << endl;
            seriesMap[season.getSeriesName()] = comsuptionArray;
        }
        else if(Movie::isMovie(*media)) {
            Movie& movie = (Movie&) *media;
            if(media->getConsumptionStatus(Media::WATCHED)) {
                haveWatchedTime += movie.getFeatureLength();
            }
            if(media->getConsumptionStatus(Media::WANT)){
                wantToWatchTime += movie.getFeatureLength();
            }
        }
    }

    ofs << "Horas consumidas: " << haveWatchedTime << " minutos" << endl;
    ofs << "Horas a consumir: " << wantToWatchTime << " minutos" << endl << endl;
    ofs << "Mídias por gênero:" << endl;

    list<Genre*> genres = this->mediaCollection.getGenresFromMap();
    //genres.sort(GenreComparator);
    for(list<Genre*>::iterator it = genres.begin(); it != genres.end(); it++) {
        Genre* genre = *it;
        ofs << "\t" << genre->getName() << ": " << genre->getMediaCount() << endl;
    }

    ofs << endl << "Temporadas por série:" << endl;

    for(map<string,vector<int>>::iterator it = seriesMap.begin(); it != seriesMap.end(); it++) {
        vector<int> value = it->second;
        ofs << "\t" << it->first << ": " << value[1] << " assistidas, "
        << value[0] << " a assistir" << endl;
    }
}
void Report::generateMediasByPersonReport(ofstream& ofs) {
    list<Person*> people = mediaCollection.getPeopleFromMap();
    people.sort(PersonComparator);

    ofs << "Pessoa;Produção" << endl;
    for(list<Person*>::iterator it = people.begin(); it != people.end(); it++) {
        Person* person = *it;
        if(person->getMediaCount() > 0) {
            ofs << person->getName() << ";";
            list<Media*>& medias = person->getMedias();
            medias.sort(WishListMediaComparator);
            list<Media*>::iterator it2 = medias.begin();
            if(it2 != medias.end()) {
                ofs << (*it2)->getName();
                for(it2++; it2 != medias.end(); it2++) {
                    Media* media = *it2;
                    ofs << ", " << media->getName();
                }
            }
            ofs << endl;
        }
    }
}
void Report::generateLoanReport(ofstream& ofs) {
    list<Loan*>& loanList = this->mediaCollection.getLoanList();
    time_t todayDate = parseDate("06/11/2015", DATE_FORMAT);
    loanList.sort(LoanComparator);

    ofs << "Data;Tomador;Atrasado?;Dias de Atraso" << endl;

    for(list<Loan*>::iterator it = loanList.begin(); it != loanList.end(); it++) {
        Loan* loan = *it;
        string startDate = formatDate(loan->getStartDate(), DATE_FORMAT);
        string& lentTo = loan->getPersonName();
        string lateString = "Sim";

        loan->setReturnDate(todayDate);
        if(!loan->isLate()) {
            lateString = "Não";
        }
        long daysLate = loan->calculateDaysLate();
        ofs << startDate << ";" << lentTo << ";" << lateString << ";" << daysLate << endl;
    }
}
void Report::generateWhishListReport(ofstream& ofs) {
    list<Media*>& wishList = this->mediaCollection.getWishList();
    wishList.sort(WishListMediaComparator);

    ofs << "Tipo;Mídia;Gênero;Preço" << endl;
    for(list<Media*>::iterator it = wishList.begin(); it != wishList.end(); it++) {
        Media* media = *it;
        string mediaTypeName;
        if(Book::isBook(*media))
            mediaTypeName = "Livro";
        else if(Movie::isMovie(*media))
            mediaTypeName = "Filme";
        else if(TvSeriesSeason::isTvSeriesSeason(*media))
            mediaTypeName = "Série";

        std::stringstream ss;
        ss << setprecision(2) << fixed << media->getPrice();
        string money = ss.str();

        for(string::iterator it = money.begin(); it != money.end(); it++) {
            if(*it == '.') *it = ',';
        }

        ofs << mediaTypeName << ";" << media->getName() << ";"
        << media->getGenre().getName() << ";R$ " << setprecision(2) << fixed << money << endl;
    }
}

// Destructor
Report::~Report() {}
