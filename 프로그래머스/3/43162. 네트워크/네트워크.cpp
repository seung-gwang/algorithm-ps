#include <string>
#include <vector>

using namespace std;

void DFS(const int curIdx, vector<vector<int>>& A, vector<bool>& visit) {
    visit[curIdx] = true;
    for(int next : A[curIdx]) {
        if(visit[next]) {continue;}
        DFS(next, A, visit);
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    vector<vector<int>> A(n);
    vector<bool> visit(n, false);
    
    for(int i = 0; i < n; ++i) {
        for(int j = 0; j < n; ++j) {
            if(computers[i][j] == 1) {
                A[i].push_back(j);
            }
        }
    }
    
    int networkCnt = 0;
    for(int i = 0; i < n; ++i) {
        if(visit[i]) {continue;}
        DFS(i, A, visit);
        networkCnt++;
    }
    
    answer = networkCnt;
    return answer;
}