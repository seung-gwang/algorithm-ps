#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";

    unordered_map<string, int>  pCnt;
    
    for(const auto& p : participant) {
        pCnt[p]++;
    }
    
    for(const auto& c : completion) {   
        pCnt[c]--;
    }
    
    for(const auto& kv : pCnt) {
        if(kv.second == 1) {
            answer = kv.first;
        }
    }
    
    return answer;
}