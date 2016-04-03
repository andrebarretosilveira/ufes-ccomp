/**
 * Program defined Exceptions
 */

#ifndef S_EXCEPTIONS_H
#define S_EXCEPTIONS_H

#include <exception>
using namespace std;

class ProgramException : public exception {

public:
    const char * what () const throw () {
        return "Erro de programa";
    }
};

class IOException : public ProgramException {

public:
    const char * what () const throw () {
        return "Erro de I/O";
    }
};

class DataFormatException : public ProgramException {

public:
    const char * what () const throw () {
        return "Erro de formatação";
    }
};

struct InconsistentDataException : public ProgramException {

private:
    string msg;

public:
    InconsistentDataException(const string& col, const string& value)
        : msg("Dados inconsistentes (" + col + string(": ")
        + value + ")") {}

    const char * what () const throw () {
        return msg.c_str();
    }

    virtual ~InconsistentDataException() throw() {} 

};

#endif
