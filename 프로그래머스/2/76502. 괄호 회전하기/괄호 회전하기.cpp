#include <string>
#include <vector>
#include <stack>

using namespace std;

bool isCorrect(const string& str) {
    stack<char> st;
    for(const auto& s : str) {
        if(s == '{' || s == '(' || s == '[') {
            st.push(s);
            continue;
        }
        
        if(st.empty()) {
            return false;
        }
        
        if(s == '}' && st.top() == '{') {
            st.pop();
            continue;
        }
        
        if(s == ')' && st.top() == '(') {
            st.pop();
            continue;
        }
        
        if(s == ']' && st.top() == '[') {
            st.pop();
            continue;
        }
        
        return false;
    }
    
    if(st.empty()) {return true;}
    return false;
}

int solution(string s) {
    int answer = -1;
    const int LEN = s.length();
    
    int cnt = 0;
    string cur = s;
    for(int i = 0; i < LEN; ++i) {
        char front = cur[0];
        cur = cur.substr(1, LEN - 1);
        cur += front;
        
        if(isCorrect(cur)) {
            cnt++;
        }
    }
    
    answer = cnt;
    
    return answer;
}