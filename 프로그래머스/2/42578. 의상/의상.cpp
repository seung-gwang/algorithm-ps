#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 0;
    map<string, vector<string>> m;
    
    for(const auto& c : clothes) {
        string k = c[1];
        string v = c[0];
        
        m[k].push_back(v);
    }
    
    int combi = 1;
    for(auto it = m.begin(); it != m.end(); ++it) {
        combi *= (it->second).size() + 1;
    }
    
    answer = combi - 1;
    return answer;
}