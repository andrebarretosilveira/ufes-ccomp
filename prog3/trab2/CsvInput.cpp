
#include "CsvInput.hpp"

template <class T>
inline std::string to_string (const T& t)
{
    std::stringstream ss;
    ss << t;
    return ss.str();
}

std::vector<std::string> split(std::string str,std::string sep){
    char* cstr=const_cast<char*>(str.c_str());
    char* current;
    std::vector<std::string> arr;
    current=strtok(cstr,sep.c_str());
    while(current!=NULL){
        arr.push_back(current);
        current=strtok(NULL,sep.c_str());
    }
    return arr;
}

string& ltrim(string &s) {
    s.erase(s.begin(), find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace))));
    return s;
}

string& rtrim(string &s) {
    s.erase(find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(), s.end());
    return s;
}

string& trim(string& s) {
    return ltrim(rtrim(s));
}

// Constructor
CsvInput::CsvInput(MediaCollection& mediaCollection) : mediaCollection(mediaCollection) {}


/*Private*/ void CsvInput::readCsvFile(void (CsvInput::*dataHandler) (const vector<std::string>&)) {

	string record;
	vector<string> fields;
	const char* filePath = this->csvFilePath.c_str();
	ifstream csvInputFile (filePath);

    try {
        if(!csvInputFile.good()) {
            throw IOException();
        }

        getline(csvInputFile,record);//Header line

        while(getline(csvInputFile,record)) {

            Tokenizer* lineTokenizer = new Tokenizer(record,';');

            while(lineTokenizer->hasNext()) {
                string line = lineTokenizer->next();
                line = trim(line);
                fields.push_back(line);
            }

            (this->*dataHandler)(fields);
            fields.clear();
            delete lineTokenizer;
        }

        csvInputFile.close();
    }
    catch(IOException e) {
        cout << e.what() << endl;
        throw ProgramException();
    }
    catch(DataFormatException e) {
        cout << e.what() << endl;
        throw ProgramException();
    }
    catch(InconsistentDataException e) {
        cout << e.what() << endl;
        throw ProgramException();
    }
}

/*Private*/ void CsvInput::insertGenreFromString(const vector<std::string>& fields) {

	string genreInitials;
	string genreName;

	if(fields.size() == 2) {
		genreInitials = fields[0];
		genreName = fields[1];
		Genre* newGenre = new Genre(genreInitials,genreName);
		this->mediaCollection.addGenre(*newGenre);
		if(this->mediaCollection.getGenreByInitials(genreInitials) != nullptr) {
		}
	}
	else {
		throw DataFormatException();
		//Error: Data Format Exception
	}
}

/*Private*/ void CsvInput::insertPersonFromString(const vector<std::string>& fields) {

	string personName;
	long personId;

	if(fields.size() == 2) {
        try {
            if(!isNumber(fields[0])) throw DataFormatException();
            personId = stol(fields[0],nullptr,10);/*Error: Handle DataFormatException*/
            personName = fields[1];
            Person* person = new Person(personId,personName);
            this->mediaCollection.addPerson(*person);
        }
        catch(invalid_argument& e) {
            throw DataFormatException();
        }
	}
	else {
		throw DataFormatException();
		//Error: Data Format Exception
	}
}

/*Private*/ Media* CsvInput::insertBookFromString(const vector<std::string>& fields) {

	unsigned int i;
	long mediaId,authorCode;
	int numberPages;
	Genre *genrePtr;
	string mediaName;


	mediaId = stol(fields[0],nullptr,10);
	numberPages = stoi(fields[5],nullptr,10);
	mediaName = fields[1];
	genrePtr = this->mediaCollection.getGenreByInitials(fields[6]);
	if(genrePtr == nullptr) {
        throw InconsistentDataException("Gênero", fields[6]);
		//Error: genre not found
	}

	Book* book = new Book(mediaId,mediaName,numberPages,*genrePtr);
	vector<string> authorCodesStr = split(fields[4],",");
	for(i=0;i < authorCodesStr.size() ;i++) {
        try {
            if(!isNumber(authorCodesStr[i])) throw DataFormatException();
            authorCode = stol(authorCodesStr[i],nullptr,10); //Error: Possible number conversion error.
            Person* person = (this->mediaCollection.getPersonByCode(authorCode));
            if(person == nullptr) {
                throw InconsistentDataException("Pessoa", to_string(authorCode));
            }
            book->addAuthor(*person);
        }
        catch(invalid_argument& e) {
            throw DataFormatException();
        }
	}
	return (Media*) book;
}

/*Private*/ Media* CsvInput::insertMovieFromString(const vector<std::string>& fields) {

	long mediaId, directorId,actorCode;
	int featureLength;
	unsigned int i;
	string mediaName;

	mediaId = stol(fields[0],nullptr,10);
	featureLength = stol(fields[5],nullptr,10);
    if(!isNumber(fields[3])) throw DataFormatException();
	directorId = stol(fields[3],nullptr,10);

	mediaName = fields[1];

	Genre* genrePtr = this->mediaCollection.getGenreByInitials(fields[6]);
	Person* directorPtr = this->mediaCollection.getPersonByCode(directorId);

	if(directorPtr == nullptr) {
        throw InconsistentDataException("Diretor", fields[3]);
		//Error: InconsistentDataException
	}

	if(genrePtr == nullptr) {
        throw InconsistentDataException("Gênero", fields[6]);
		//Error: InconsistentDataException
	}

	Movie* movie = new Movie(mediaId,mediaName,*directorPtr,featureLength,*genrePtr);
	vector<string> actorCodesStr = split(fields[4],",");
	for(i=0;i<actorCodesStr.size();i++) {
        try {
            if(!isNumber(actorCodesStr[i])) throw DataFormatException();
            actorCode = stol(actorCodesStr[i],nullptr,10); //Error: possible DataFormatException
            Person* actorPtr = this->mediaCollection.getPersonByCode(actorCode);
            if(actorPtr == nullptr) {
                throw InconsistentDataException("Ator", to_string(actorCode));
                //Error: possble InconsistentDataException
            }
            movie->addActor(*actorPtr);
        }
        catch(invalid_argument& e) {
            throw DataFormatException();
        }
	}
	return (Media*) movie;
}

/*Private*/ Media* CsvInput::insertTvSeriesSeasonFromString(const vector<std::string>& fields) {

	long mediaId,actorCode;
	unsigned int i;
	int featureLength, seasonNumber;
	string mediaName,seriesName;

    try {
        mediaId = stol(fields[0],nullptr,10); //Error possible DataFormatException
        featureLength = stol(fields[5],nullptr,10);
        if(!isNumber(fields[8])) throw DataFormatException();
        seasonNumber = stol(fields[8],nullptr,10);

        mediaName = fields[1];
        seriesName = fields[7];
        Genre* genrePtr = this->mediaCollection.getGenreByInitials(fields[6]);
        if(genrePtr == nullptr) {
            throw InconsistentDataException("Gênero", fields[6]);
            //Error: possible InconsistentDataException
        }

        TvSeriesSeason* season = new TvSeriesSeason(mediaId, mediaName, seriesName,featureLength, seasonNumber, *genrePtr);

        vector<string> actorCodesStr = split(fields[4],",");

        for(i=0;i<actorCodesStr.size();i++) {
            if(!isNumber(actorCodesStr[i])) throw DataFormatException();
            actorCode = stol(actorCodesStr[i],nullptr,10); //Error: possible DataFormatException
            Person* actorPtr = this->mediaCollection.getPersonByCode(actorCode);
            if(actorPtr == nullptr) {
                throw InconsistentDataException("Ator", to_string(actorCode));
                //Error: possible InconsistentDataException
            }
            season->addActor(*actorPtr);
        }

        return season;
    }
    catch(invalid_argument& e) {
        throw DataFormatException();
    }
}

/*Private*/ void CsvInput::insertMediaFromString(const vector<std::string>& fields) {

	string genreInitials,priceStr;
	double mediaPrice;
	Media* media;

	if(fields.size() == 13) {

        if(!isNumber(fields[0])) throw DataFormatException();
		genreInitials = fields[6];
		Genre* genrePtr = this->mediaCollection.getGenreByInitials(genreInitials);
		if(genrePtr == nullptr) {
            throw InconsistentDataException("Gênero", genreInitials);
			//Error: possible InconsistentDataException
		}

		if(fields[2] == "L") {
			media = this->insertBookFromString(fields);
		}
		else if(fields[2] == "F") {
			media = this->insertMovieFromString(fields);
		}
		else if(fields[2] == "S") {
			media = this->insertTvSeriesSeasonFromString(fields);
		}
		else {
            throw InconsistentDataException("Tipo", fields[2]);
			//Error: possible InconsistentDataException
		}

		priceStr = fields[12];
        for(string::iterator it = priceStr.begin(); it != priceStr.end(); it++) {
            if(*it == ',')
                *it = '.';
        }
		mediaPrice = stod(priceStr.c_str());
		media->setPrice(mediaPrice);

		media->setConsumptionStatus(Media::WANT,fields[11] == "x");

		media->setConsumptionStatus(Media::WATCHED,fields[10] == "x");

		media->setConsumptionStatus(Media::NOTWATCHED,fields[9] == "x");


		this->mediaCollection.addMedia(*media);
	}
	else {
		throw DataFormatException();
	}
}

/*Private*/ void CsvInput::insertLoanFromString(const vector<std::string>& fields) {

	long mediaId;
	string lentTo;
	time_t limitDate,startDate;
	Media* mediaPtr;

	if(fields.size() != 4) {
		throw DataFormatException();
		//Error: DataFormatException
	}

    try {
        if(!isNumber(fields[0])) throw DataFormatException();
        mediaId = stol(fields[0],nullptr,10);
        lentTo = fields[1];
    }
    catch(invalid_argument& e) {
        throw DataFormatException();
    }

    if(!validDate(fields[2], DATE_FORMAT) || !validDate(fields[3], DATE_FORMAT))
        throw DataFormatException();

    limitDate = parseDate(fields[2],DATE_FORMAT); // Error: possible DataFormatException
    startDate = parseDate(fields[3],DATE_FORMAT); // Error: possible DataFormatException

	mediaPtr = this->mediaCollection.getMediaById(mediaId);

	if(mediaPtr == nullptr) {
        throw InconsistentDataException("Midia", to_string(mediaId));
		//Error: possible InconsistentDataException
	}

	Media& MediaRef = *mediaPtr;

	Loan* loan = new Loan(lentTo,MediaRef,startDate,limitDate);
	this->mediaCollection.lend(*loan);

}

/*Public*/ void CsvInput::readGenreCsv(string filePath) {
	this->csvFilePath = filePath;
	this->readCsvFile(&CsvInput::insertGenreFromString);
}

/*Public*/ void CsvInput::readPersonCsv(string filePath) {
	this->csvFilePath = filePath;
	this->readCsvFile(&CsvInput::insertPersonFromString);
}

/*Public*/ void CsvInput::readMediaCsv(string filePath) {
	this->csvFilePath = filePath;
	this->readCsvFile(&CsvInput::insertMediaFromString);
}

/*Public*/ void CsvInput::readLoanCsv(string filePath) {
	this->csvFilePath = filePath;
	this->readCsvFile(&CsvInput::insertLoanFromString);
}

CsvInput::~CsvInput() {}
