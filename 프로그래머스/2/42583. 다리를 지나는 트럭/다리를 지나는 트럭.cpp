#include <iostream>
#include<algorithm>
#include <vector>
#include<queue>
using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer=0;
    int weightSum = 0;
    int idx=0;
    int time=0;
    
    queue<pair<int,int>> q; //무게, 진입시각

    while(true) {
        ++time;
        
        if(idx >= truck_weights.size()) {
            time= q.back().second+ bridge_length;
            break;
        }

        if(weight >= weightSum + truck_weights[idx]) {
            q.push({truck_weights[idx],time});
            weightSum += truck_weights[idx];
            ++idx;
            
            auto frontTruck = q.front();
            
            if(frontTruck.second+bridge_length<=time) {
                q.pop();
                weightSum -= frontTruck.first;
            }
        }
        else {
            while(weight < truck_weights[idx] + weightSum) {
                weightSum -= q.front().first;
                time = q.front().second + bridge_length;
                q.pop();
                
            }
            q.push({truck_weights[idx],time});
            weightSum += truck_weights[idx];
            ++idx;
        }
    }

    answer = time;
    return answer;
}