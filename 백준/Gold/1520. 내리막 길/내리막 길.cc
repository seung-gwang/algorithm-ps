#include <iostream>
using namespace std;
int map[500][500];
int M;//세로
int N;//가로
int dy[] = { -1,1,0,0 };
int dx[] = { 0,0,-1,1 };

bool visit[500][500];
int dp[500][500];

int DFS(const int cy, const int cx) {

    if (dp[cy][cx] != -1) {
        return dp[cy][cx];
    }

    if (cy == M - 1 && cx == N - 1) {
        dp[cy][cx] = 1;
        return 1;
    }

    dp[cy][cx] = 0;

    int curHeight = map[cy][cx];

    for (int dir = 0; dir < 4; ++dir) {
        int ny = cy + dy[dir];
        int nx = cx + dx[dir];

        if (ny < 0 || nx < 0 || ny >= M || nx >= N) {
            continue;
        }

        if (map[ny][nx] >= curHeight) {
            continue;
        }

        if (visit[ny][nx]) {
            continue;
        }

        visit[ny][nx] = true;
        dp[cy][cx] += DFS(ny, nx);
        visit[ny][nx] = false;
    }

    return dp[cy][cx];
}

void solve() {
    cin >> M >> N;
    for (int y = 0; y < M; ++y) {
        for (int x = 0; x < N; ++x) {
            cin >> map[y][x];
            visit[y][x] = false;
            dp[y][x] = -1;
        }
    }

    visit[0][0] = true;
    cout << DFS(0, 0);
}

int main() {
    solve();
    return 0;
}