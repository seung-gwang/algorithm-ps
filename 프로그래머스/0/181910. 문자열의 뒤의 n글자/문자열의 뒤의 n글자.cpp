#include <string>
#include <vector>

using namespace std;

string solution(string my_string, int n) {
    const int startIdx = my_string.length() - n;
    
    return my_string.substr(startIdx, n);
}