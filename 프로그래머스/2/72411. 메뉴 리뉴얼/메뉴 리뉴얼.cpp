#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

map<string, int> combi;

void dfs(string& order, int& len, string menus, int idx) {
    if (menus.length() == len) {
        combi[menus]++; 
        return;
    }

    for (int i = idx; i < order.length(); i++) {
        dfs(order, len, menus + order[i], i + 1);
    }
}

vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;

    for (int len : course) {
        for (string order : orders) {
            sort(order.begin(), order.end());
            dfs(order, len, "", 0);
        }

        int maxCnt = 0; 
        for (const auto& it : combi) {
            maxCnt = max(maxCnt, it.second);
        }

        for (const auto& it : combi) {
            if (maxCnt < 2) { 
                break; 
            }
            else if (combi[it.first] == maxCnt) {
                answer.push_back(it.first);
            } 
        }

        combi.clear();
    }

    sort(answer.begin(), answer.end());
    return answer;
}