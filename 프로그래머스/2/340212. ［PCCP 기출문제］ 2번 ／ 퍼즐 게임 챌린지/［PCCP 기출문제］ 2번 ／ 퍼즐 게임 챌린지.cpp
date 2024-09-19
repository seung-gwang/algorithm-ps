#include <string>
#include <vector>

using namespace std;

int solution(vector<int> diffs, vector<int> times, long long limit) {
    const int TIMES_LEN = times.size();
    int answer = 0;
    int left = 0;
    int right = 500000;
    
    while(left <= right) {
        long long solveTime = 0;
        int mid = (left + right) / 2;        
        solveTime += times[0];
        
        for(int i = 1; i < TIMES_LEN; ++i) {
            int timeCur = times[i];
            int timePrev = times[i - 1];
            int retryCnt = (diffs[i] - mid);
            retryCnt = retryCnt < 0 ?  0 : retryCnt;
            
            solveTime += (timeCur+timePrev) * retryCnt + timeCur;
        }
        
        //빠르게 끝냈으므로 레벨이 더 낮아도 된다.
        if(solveTime <= limit) {
            right = mid - 1;
            answer = mid;
            continue;
        }
        
        left = mid + 1;
    }
    
    answer = answer == 0 ? diffs[0] : answer;
    
    
    return answer;
}