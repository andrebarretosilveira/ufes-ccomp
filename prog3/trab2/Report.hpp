/**
 * Report class interface
 */

#ifndef REPORT_H
#define REPORT_H

#include <list>
#include <vector>
#include <string>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <iostream>
#include <locale>
#include "MediaCollection.hpp"
#include "Exceptions.hpp"
#include "DateUtils.hpp"
#include "Comparators.hpp"
using namespace std;
using namespace br_ufes_inf_nemo_cpp_util;
using namespace Comparators;


class Media;
class Book;
class Movie;
class TvSeriesSeason;

class Report {

private:
    string reportPath;
	//static const string reportEncoding;
	MediaCollection& mediaCollection;
	//ofstream ofs;

	// Private functions
	void generateStatisticsReport(ofstream&);
	void generateMediasByPersonReport(ofstream&);
	void generateLoanReport(ofstream&);
	void generateWhishListReport(ofstream&);

public:
	// Constructor
	Report(MediaCollection&);

    // Public functions
    void createReport(void (Report::*specialReportGenerator) (ofstream&));
    void createStatisticsReport(const string&);
    void createMediasByPersonReport(const string&);
    void createLoanReport(const string&);
    void createWishListReport(const string&);

    // Destructor
    ~Report();
};

#endif
