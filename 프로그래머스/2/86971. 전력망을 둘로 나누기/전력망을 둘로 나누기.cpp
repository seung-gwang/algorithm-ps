#include <string>
#include <vector>

using namespace std;
vector<vector<int>> A;

int DFS(const int cur, const int x1, const int x2, vector<bool>& visit, int cnt) {
    visit[cur] = true;
    int ret = cnt + 1;
    
    for(const auto& next : A[cur]) {
        if(cur == x1 && next == x2) {
            continue;
        }
        
        if(cur == x2 && next == x1) {
            continue;
        }
        
        if(visit[next]) {
            continue;
        }
        
        ret = DFS(next, x1, x2, visit, ret);
        
    }
    
    return ret;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = 9999999;
    
    A.clear();
    A.resize(n + 1);
    for(const auto& w : wires) {
        int s = w[0];
        int e = w[1];
        
        A[s].push_back(e);
        A[e].push_back(s);
    }
    
    
    for(const auto& w : wires) {
        int s = w[0];
        int e = w[1];
        
        vector<bool> visit(n + 1, false);
        int a = DFS(s, s, e, visit, 0);
        int b = DFS(e, s, e, visit, 0);
        
        int abs = a - b > 0 ? a - b : b - a;
        
        answer = answer > abs ? abs : answer;
    }
    
    return answer;
}