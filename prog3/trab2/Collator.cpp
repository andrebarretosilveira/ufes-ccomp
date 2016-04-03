/**
 * Collator implemetation
 */

#include "Collator.hpp"

bool stringCompare( string s1, string s2) {
    const collate<char>& col = use_facet<collate<char> >(locale());
    transform(s1.begin(), s1.end(), s1.begin(), ::tolower);
    transform(s2.begin(), s2.end(), s2.begin(), ::tolower);
    const char* pb1 = s1.data();
    const char* pb2 = s2.data();
    return (col.compare(pb1, pb1 + s1.size(), pb2, pb2 + s2.size()) < 0);
}
