#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    vector<int> order;
    for(int i = 0; i < dungeons.size(); ++i) {
        order.push_back(i);
    }
    
    do {
        int piro = k;
        int cnt = 0;
        for(const auto& i : order) {
            int req = dungeons[i][0];
            int use = dungeons[i][1];
            
            if(piro >= req) {
                piro -= use;
                cnt++;
            }
            else {
                break;
            }
        }
        answer = cnt > answer ? cnt : answer;
    }while(next_permutation(order.begin(), order.end()));
        
    return answer;
}