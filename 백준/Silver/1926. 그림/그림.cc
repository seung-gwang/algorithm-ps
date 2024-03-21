#include <iostream>
using namespace std;

int M, N;
int map[500][500];
int visit[500][500];

const int dy[] = { -1,1,0,0 };
const int dx[] = { 0,0,-1,1 };

int maxArea;
int paintCnt;

int DFS(const int cy, const int cx, const int curArea) {
    visit[cy][cx] = true;
    int ret = curArea;
    ret++;

    for (int dir = 0; dir < 4; ++dir) {
        int ny = cy + dy[dir];
        int nx = cx + dx[dir];

        if (ny >= M || nx >= N || ny < 0 || nx < 0 || visit[ny][nx] || map[ny][nx] == 0) {
            continue;
        }

        ret = DFS(ny, nx, ret);
    }

    return ret;
}

void solve() {
    maxArea = 0;
    paintCnt = 0;

    cin >> M >> N;
    for (int y = 0; y < M; ++y) {
        for (int x = 0; x < N; ++x) {
            cin >> map[y][x];
            visit[y][x] = false;
        }
    }

    for (int y = 0; y < M; ++y) {
        for (int x = 0; x < N; ++x) {
            if (!visit[y][x] && map[y][x] == 1) {
                //curArea = 0;
                int curArea = DFS(y, x, 0);
                paintCnt++;
                maxArea = maxArea > curArea ? maxArea : curArea;
            }
        }
    }

    cout << paintCnt << endl;
    cout << maxArea << endl;
}

int main() {
    solve();
    return 0;
}
