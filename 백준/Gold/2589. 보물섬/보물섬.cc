#include <iostream>
#include <vector>
#include <string>
#include <limits.h>
#include <queue>
#include <algorithm>

using namespace std;

typedef pair<int, pair<int, int>> distPos_t;
typedef pair<int, int> pos;

#define WATER ('W')
#define LAND ('L')

char map[50][50];
int N;
int M; 

int dist[50][50];
bool  visit[50][50];

int dy[] = { -1, 1, 0, 0 };
int dx[] = { 0, 0, -1, 1 };

void bfs(const int sy, const int sx) {
    queue<pos> q;

    visit[sy][sx] = true;
    dist[sy][sx] = 0;
    q.push({sy, sx});

    int d = 0;

    while (!q.empty()) {
        int popSize = q.size();
        d++;
        for (int p = 0; p < popSize; ++p) {
            pos cur = q.front();
            q.pop();

            int cy = cur.first;
            int cx = cur.second;

            for (int dir = 0; dir < 4; ++dir) {
                int ny = cy + dy[dir];
                int nx = cx + dx[dir];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }

                if (map[ny][nx] == WATER) {
                    continue;
                }


                if (visit[ny][nx]) {
                    continue;
                }

                q.push({ ny, nx });
                visit[ny][nx] = true;
                dist[ny][nx] = d;
            }
        }

        
    }
}

int main() {
    cin >> N >> M;
    for (int i = 0; i < N; ++i) {
        string row;
        cin >> row;
        for (int j = 0; j < M; ++j) {
            map[i][j] = row[j];
        }
    }

    int answer = -1;

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            int sy = i; //start y
            int sx = j; //start x

            if (map[sy][sx] == WATER) {
                continue;
            }

            //방문 배열, 거리 배열 초기화
            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < M; ++c) {
                    visit[r][c] = false;
                    dist[r][c] = INT_MAX;
                }
            }

            bfs(sy, sx);

            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < M; ++c) {
                    if (dist[r][c] == INT_MAX) { continue; }
                    answer = dist[r][c] > answer ? dist[r][c] : answer;
                   
                }
            }
        }
    }

    cout << answer;
}
