/**
 * ConsoleInput class interface
 */

#ifndef CONSOLEINPUT_H
#define CONSOLEINPUT_H

#include <string>
#include "Exceptions.hpp"
using namespace std;

class ConsoleInput {

private:
    int argc;
    const char** args;

public:
    // Constructor
    ConsoleInput(const int argc, const char** args);

    // Functions
    string* getFilePath(const string& parameter);
    
    // Destructor
    ~ConsoleInput();

};

#endif
