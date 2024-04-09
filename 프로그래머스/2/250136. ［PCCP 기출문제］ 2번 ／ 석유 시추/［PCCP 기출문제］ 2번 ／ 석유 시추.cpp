#include <string>
#include <vector>
#include <map>
#include <set>

using namespace std;
vector<vector<int>> board;
int N;
int M;
bool visit[500][500];
pair<int,int> dp[500][500];
map<pair<int,int>, int> oilSize;

const int dy[] = {-1, 1, 0, 0};
const int dx[] = {0, 0, -1, 1};

int DFS(const int cy, const int cx, const int ry, const int rx, const int curArea) {
    int retArea = curArea;
    visit[cy][cx] = true;
    dp[cy][cx] = {ry, rx};
    retArea++;
    
    for(int dir = 0; dir < 4; ++dir) {
        int ny = cy + dy[dir];
        int nx = cx + dx[dir];
        
        if(ny >= N || ny < 0 || nx >= M || nx < 0) {
            continue;
        }
        
        
        if(board[ny][nx] == 0 || visit[ny][nx]) {continue;}
        
        retArea = DFS(ny, nx, ry, rx, retArea);
    }
    
    return retArea;
}

int solution(vector<vector<int>> land) {
    int answer = 0;
    board = land;
    N = board.size();
    M = board[0].size();
    for(int y = 0; y < N; ++y) {
        for(int x = 0; x < M; ++x) {
            dp[y][x] = {-1,-1};
        }
    }
    
    
    for(int cy = 0; cy < N; ++cy) {
        for(int cx = 0; cx < M; ++cx) {
            if(board[cy][cx] == 1 && visit[cy][cx] == false) {
                int size = DFS(cy, cx, cy, cx, 0);
                oilSize.insert({{cy, cx}, size});
            }
        }
    }
    
    
    for(int x = 0; x < M; ++x) {
        set<pair<int, int>> usedArea;
        int sum = 0;
        for(int y = 0; y < N; ++y) {
            if(board[y][x] == 0) {continue;}
            pair<int, int> pos = dp[y][x];
            if(usedArea.find(pos) == usedArea.end()) {
                sum += oilSize[pos];
                usedArea.insert(pos);
            }    
        }
        
        answer = answer > sum ? answer : sum;
    }
    
    return answer;
}