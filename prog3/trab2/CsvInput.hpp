
#ifndef CSV_INPUT_H
#define CSV_INPUT_H


#include <algorithm>
#include <cctype>
#include <functional>
#include <locale>
#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <string.h>
#include <exception>
#include "Exceptions.hpp"
#include "DateUtils.hpp"
#include "StringUtils.hpp"
#include "Tokenizer.hpp"
#include "Loan.hpp"
#include "MediaCollection.hpp"

using namespace std;
using namespace br_ufes_inf_nemo_cpp_util;

class MediaCollection;
class Genre;
class Media;
class Loan;

class CsvInput {

private:
	//Private Attributes

	string csvFilePath;
	MediaCollection& mediaCollection;

	//Private Methods

	void readCsvFile(void (CsvInput::*dataHandler) (const vector<std::string>&));
	void insertGenreFromString(const vector<std::string>&);
	void insertPersonFromString(const vector<std::string>&);
	Media* insertBookFromString(const vector<std::string>&);
	Media* insertMovieFromString(const vector<std::string>&);
	Media* insertTvSeriesSeasonFromString(const vector<std::string>&);
	void insertLoanFromString(const vector<std::string>&);
	void insertMediaFromString(const vector<std::string>&);

public:

	//Public Methods

	CsvInput(MediaCollection&);
	void readGenreCsv(string);
	void readPersonCsv(string);
	void readMediaCsv(string);
	void readLoanCsv(string);

	// Destructor
    ~CsvInput();
};

#endif
