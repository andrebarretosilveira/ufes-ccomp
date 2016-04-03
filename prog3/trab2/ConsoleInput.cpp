/**
 * ConsoleInput class implementation
 */

#include "ConsoleInput.hpp"
using namespace std;

// Constructor
ConsoleInput::ConsoleInput(const int argc, const char** args):
    argc(argc), args(args)
    {}

// Functions
string* ConsoleInput::getFilePath(const string& parameter) {
    int i = 0;
    while(i < argc && string(args[i]).compare(parameter) != 0) i++;
    if(i < argc-1) {
        return new string(args[i+1]);
    }
    else
        throw IOException();
}

// Destructor
ConsoleInput::~ConsoleInput() {}
