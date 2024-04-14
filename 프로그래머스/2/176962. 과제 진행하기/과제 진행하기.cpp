#include <string>
#include <vector>
#include <stack>
#include <queue>
#include <algorithm>
#define daystart (0) //00:00
#define dayend (23 * 60 + 59) //23:59
using namespace std;

typedef struct task {
    unsigned int startTime;
    unsigned int remainTime;
    string name;
} task_t;

struct comp {
    bool operator() (task_t left, task_t right) {
        return left.startTime < right.startTime;
    }
};

vector<string> solution(vector<vector<string>> plans) {
    vector<string> answer;
    vector<task_t> vt;
    
    for(const auto& p : plans) {
        string name = p[0];
        string s = p[1];
        string d = p[2];
        
        unsigned int uintS = stoi(s.substr(0,2)) * 60 + stoi(s.substr(3));
        unsigned int r = stoi(d);
        
        vt.push_back(task_t{uintS, r, name});
    }
    
    sort(vt.begin(), vt.end(), comp());
    queue<task_t> qt;
    for(const auto& t : vt) {
        qt.push(t);
    }
    
    stack<task_t> st;
    
    task_t cur = qt.front();
    qt.pop();
    for(int t = cur.startTime; t <= 100000; ++t) {
        if(cur.startTime != -1) {
            cur.remainTime--;
        }
        
        if(cur.remainTime == 0) {
            answer.push_back(cur.name);
            cur =  {(unsigned int)-1, (unsigned int)-1, ""};
        }
        
        if(cur.startTime == -1 && !st.empty()) {
            cur = st.top();
            st.pop();
        }
        
        if(qt.front().startTime == t) { //새로 시작해야하는 과제가 생김    
            if(cur.startTime != -1) { //진행중이던 과제가 있다면, 스택에 담고 새 과제 시작
                st.push(cur);
            }
            
            cur = qt.front();
            qt.pop();
        }
        
        
//         if(cur.startTime == -1) {
//             continue;
//         }
        
//         --cur.remainTime;
//         if(cur.remainTime == 0) {
//             answer.push_back(cur.name);
//             cur =  {(unsigned int)-1,(unsigned int)-1,""};
//         }
        
        
    }
    return answer;
}