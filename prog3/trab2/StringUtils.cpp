
#include "StringUtils.hpp"

using namespace std;

namespace br_ufes_inf_nemo_cpp_util {

bool stringCompare(string s1, string s2) {
       const collate<char>& col = use_facet<collate<char> >(locale());
       transform(s1.begin(), s1.end(), s1.begin(), ::tolower);
       transform(s2.begin(), s2.end(), s2.begin(), ::tolower);
       const char* pb1 = s1.data();
       const char* pb2 = s2.data();
       return (col.compare(pb1, pb1 + s1.size(), pb2, pb2 + s2.size()) < 0);
}

bool isNumber(const string& s) {
    if (s.empty()) return false;
    for (int i = 0; i < s.size(); i++)
        if (! isdigit(s.at(i))) return false;
    return true;
}

}
