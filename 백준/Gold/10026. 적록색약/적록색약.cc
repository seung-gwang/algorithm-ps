#include <iostream>
using namespace std;

int N;
char board[101][101];
bool visit[101][101];

//상하좌우
int dy[] = { -1,1,0,0 };
int dx[] = { 0,0,-1,1 };

void initializeVisit() {
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            visit[i][j] = false;
        }
    }   
}

void DFS(const int cy, const int cx, const char color) {
    visit[cy][cx] = true;

    for (int dir = 0; dir < 4; ++dir) {
        int ny = cy + dy[dir];
        int nx = cx + dx[dir];

        if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
            continue;
        }

        if (visit[ny][nx]) {
            continue;
        }

        if (board[ny][nx] != color) {
            continue;
        }

        DFS(ny, nx, color);
    }
}

int main(void) {
    cin >> N;

    for (int i = 0; i < N; ++i) {
        string row;
        cin >> row;
        for (int j = 0; j < N; ++j) {
            board[i][j] = row[j];
        }
    }

    initializeVisit();
    int normal = 0;
    for (int cy = 0; cy < N; ++cy) {
        for (int cx = 0; cx < N; ++cx) {
            if (visit[cy][cx]) { continue; }
            DFS(cy, cx, board[cy][cx]);
            normal++;
        }
    }
    

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            if (board[i][j] == 'R') {
                board[i][j] = 'G';
            }
        }
    }


    initializeVisit();
    int blind = 0;
    for (int cy = 0; cy < N; ++cy) {
        for (int cx = 0; cx < N; ++cx) {
            if (visit[cy][cx]) { continue; }
            DFS(cy, cx, board[cy][cx]);
            blind++;
        }
    }

    printf("%d %d", normal, blind);

    return 0;
}
