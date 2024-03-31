#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string g_target;
vector<string> g_words;
bool v[51];

int DFS(string cur, int cnt);

int diffCnt(string a, string b);

int solution(string begin, string target, vector<string> words) {
    for(int i = 0; i < words.size(); ++i) {
        v[i] = false;
    }
    int answer = 0;
    g_target = target;
    g_words = words;
    
    if(find(words.begin(), words.end(), target) == words.end()) {
        return 0;
    }
    
    return DFS(begin, 0);
}

int DFS(string cur, int cnt) {
    if(cur == g_target) {
        return cnt;
    }
    
    int rec = -1;
    for(int i = 0; i < g_words.size(); ++i) {
        if(diffCnt(cur, g_words[i]) == 1 && v[i] == false) {
            v[i] = true;
            rec = DFS(g_words[i], cnt+1);
            v[i] = false;
        }
    }
    
    return rec;
}

int diffCnt(const string a, const string b) {
    int diff = 0;
    const int len = a.length();
    for(int i = 0; i < len; ++i) {
        if(a[i] != b[i]) {diff++;}
    }
    
    return diff;
}