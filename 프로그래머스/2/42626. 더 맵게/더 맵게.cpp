#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    
    priority_queue<int, vector<int>, greater<>> pq;
    for(const auto& s : scoville) {
        pq.push(s);
    }
    
    int cnt = 0;
    while(pq.top() < K && !pq.empty()) {
        
        
        int least = pq.top();
        pq.pop();
        
        if(pq.empty()) {
            return -1;
        }
        int secondLeast = pq.top();
        pq.pop();
        
        int mix = least + secondLeast * 2;
        pq.push(mix);
        
        cnt++;
    }
    answer = cnt;
    return answer;
}