#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//왼쪽 아래 좌표 기준 표시
int M, N, K;
int map[100][100];
bool visit[100][100];

//상하좌우
int dy[] = { 1, -1, 0, 0 };
int dx[] = { 0, 0, -1, 1 };

int DFS(const int cx, const int cy, const int curArea) {
    int retArea = curArea + 1;
    visit[cx][cy] = true;


    for (int dir = 0; dir < 4; ++dir) {
        int nx = cx + dx[dir];
        int ny = cy + dy[dir];

        if (nx < 0 || ny < 0 || ny >= M || nx >= N) {
            continue;
        }

        if (visit[nx][ny]) {
            continue;
        }

        if (map[nx][ny] == 1) {
            continue;
        }

        retArea = DFS(nx, ny, retArea);
    }

    return retArea;
}

void solve() {
    cin >> M >> N >> K;
    for (int x = 0; x < M; ++x) {
        for (int y = 0; y < N; ++y) {
            map[x][y] = 0;
            visit[x][y] = false;
        }
    }

    for (int i = 0; i < K; ++i) {
        int ldx, ldy, rux, ruy;
        cin >> ldx >> ldy >> rux >> ruy;

        for (int x = ldx; x < rux; ++x) {
            for (int y = ldy; y < ruy; ++y) {
                map[x][y] = 1;
            }
        }

    }

    vector<int> areas;
    for (int x = 0; x < N; ++x) {
        for (int y = 0; y < M; ++y) {
            if (map[x][y] == 0 && !visit[x][y]) {
                int area = DFS(x, y, 0);
                areas.push_back(area);
            }
        }
    }

    sort(areas.begin(), areas.end());

    cout << areas.size() << endl;

    for (int a : areas) {
        cout << a << " ";
    }
}

int main() {
    solve();
    return 0;
}