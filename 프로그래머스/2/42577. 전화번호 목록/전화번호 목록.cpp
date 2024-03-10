#include <string>
#include <vector>
#include <set>

using namespace std;

set<string> phoneSet;

bool solution(vector<string> phone_book) {
    bool answer = true;
    
    for(const auto&p : phone_book) {
        phoneSet.insert(p);
    }
    
    for(const auto& p : phone_book) {
        string temp = "";
        for(int i = 0; i < p.length() - 1; ++i) {
            temp += p[i];
            if(phoneSet.find(temp) != phoneSet.end()) {
                return false;
            }
        }
    }
      
    return true;
}