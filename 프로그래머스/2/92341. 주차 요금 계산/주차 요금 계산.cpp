#include <string>
#include <vector>
#include <map>
#include <cmath> 

using namespace std;

vector<int> solution(vector<int> fees, vector<string> records) {
    vector<int> answer;
    
    map<string, int> carInTimes;
    map<string, int> useTimes;
    
    for(const auto& s : records) {
        string hh = s.substr(0, 2);
        string mm = s.substr(3, 2);
        string nnnn = s.substr(6, 4);
        string io = s.substr(11);
        int minuteTime = stoi(hh) * 60 + stoi(mm);

        if (io == "IN") {
            carInTimes[nnnn] = minuteTime; 
        } else {
            int inMinuteTime = carInTimes[nnnn];
            int useTime = minuteTime - inMinuteTime;
            useTimes[nnnn] += useTime; 
            carInTimes.erase(nnnn); 
        }
    }
    
    for (const auto& kv : carInTimes) {
        int outMinute = 23 * 60 + 59;
        int useTime = outMinute - kv.second;
        useTimes[kv.first] += useTime;
    }
    
    for (const auto& kv : useTimes) {
        int useTime = kv.second;
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int extraUnitTime = fees[2];
        int extraUnitFee = fees[3];
        
        if (useTime <= defaultTime) {
            answer.push_back(defaultFee);
        } else {
            int extraTime = useTime - defaultTime;
            int extraFee = ceil((double)extraTime / extraUnitTime) * extraUnitFee; 
            answer.push_back(defaultFee + extraFee);
        }
    }
    
    return answer;
}
