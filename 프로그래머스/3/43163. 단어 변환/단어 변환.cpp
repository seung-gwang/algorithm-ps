#include <string>
#include <vector>

using namespace std;
#define INF (999999999)

int gAnswer = INF;
string gTarget = "";
vector<string> gWords;
bool visit[50];

bool isTransferable(const string a, const string b) {
    int diff = 0;
    const int LEN = a.length();
    for(int i = 0; i < LEN; ++i) {
        if(a[i] != b[i]) {
            diff++;
        }
        
        if(diff > 1) {
            return false;
        }
    }
    
    return true;
}

void DFS(const string cur, const int step) {
    if(cur == gTarget) {
        gAnswer = step > gAnswer ? gAnswer : step;
        return;
    }
    
    const int LEN = gWords.size();
    for(int i = 0; i < LEN; ++i) {
        const string w = gWords[i];
        
        if(visit[i]) {
            continue;
        }
        
        if(w == cur) {
            continue;
        }
        
        if(isTransferable(cur, w)) {
            visit[i] = true;
            DFS(w, step+1);
            visit[i] = false;
        }
    }
    
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    gTarget = target;
    gWords = words;
    
    DFS(begin, 0);
    
    answer = gAnswer;
    if(answer == INF) {
        answer = 0;
    }
    
    return answer;
}