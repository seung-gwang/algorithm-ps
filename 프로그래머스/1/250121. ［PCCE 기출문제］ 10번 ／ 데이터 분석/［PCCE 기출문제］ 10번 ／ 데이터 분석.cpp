#include <string>
#include <vector>
#include <queue>
using namespace std;

//sort by 
const string code = "code"; //0
const string date = "date"; //1
const string maximum = "maximum"; //2
const string remain = "remain"; //3


vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    vector<vector<int>> answer;
    
    int extIdx = -1;
    if(ext == "code") {
        extIdx = 0;
    }
    
    if(ext == "date") {
        extIdx = 1;
    }
    
    if(ext == "maximum") {
        extIdx = 2;
    }
    
    if(ext == "remain") {
        extIdx = 3;
    }
    
    int sortByIdx = -1;
    
    if(sort_by == "code") {
        sortByIdx = 0;
    }
    
    if(sort_by == "date") {
        sortByIdx = 1;
    }
    
    if(sort_by == "maximum") {
        sortByIdx = 2;
    }
    
    if(sort_by == "remain") {
        sortByIdx = 3;
    }
    
    priority_queue<pair<int, vector<int>>, vector<pair<int, vector<int>>>, greater<>> pq;
    for(const auto& d : data) {
        if(d[extIdx] < val_ext) {
             pq.push({d[sortByIdx], d});
        }
    }
    
    while(!pq.empty()){
        answer.push_back(pq.top().second);
        pq.pop();
    }
    
    
    
    return answer;
}