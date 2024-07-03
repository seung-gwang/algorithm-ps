#include<vector>
#include <queue>

using namespace std;
typedef struct pair<int, int> pos_t;
const int dy[] = {-1, 1, 0, 0};
const int dx[] = {0, 0, -1, 1}; //상하좌우
bool visit[101][101];

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    const int N = maps.size();
    const int M = maps[0].size();
    
    for(int y = 0; y < N; ++y) {
        for(int x = 0; x < M; ++x) {
            visit[y][x] = false;
        }
    }
    
    //BFS N X M MAP
    
    queue<pos_t> q;
    q.push({0, 0});
    
    int len = 0;
    while(!q.empty()) {
        len++;
        int popCnt = q.size();
        //bool found = false;
        for(int p = 0; p < popCnt; ++p) {
            int cy = q.front().first;
            int cx = q.front().second;
            q.pop();
            //visit[cy][cx] = true;
            
            if(cy == N-1 && cx == M-1) {
                //found = true;
                return len;
            }
            
            for(int dir = 0; dir < 4; ++dir) {
                int ny = cy + dy[dir];
                int nx = cx + dx[dir];
                
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }
                
                if(visit[ny][nx]) {
                    continue;
                } 
                
                if(maps[ny][nx] == 0) {
                    continue;
                }
                
                q.push({ny, nx});       
                visit[ny][nx] = true;
            }
            
        }
        
        //if(found) {return len;}
    }
    
    return -1;
    //return answer;
}