#include <iostream>
#include <vector>

using namespace std;

int board[9][9];
int boardCpy[9][9];

int N;
int M;

//상하좌우
const int dy[] = { -1,1,0,0 };
const int dx[] = { 0,0,-1,1 };

void DFS(int cy, int cx) {
    for (int dir = 0; dir < 4; ++dir) {
        int ny = cy + dy[dir];
        int nx = cx + dx[dir];

        if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
            continue;
        }

        if (board[ny][nx] == 1) {
            continue;
        }

        if (board[ny][nx] == 2) {
            continue;
        }

        if (board[ny][nx] == -2) {
            continue;
        }

        board[ny][nx] = -2;
        DFS(ny, nx);
    }
}

void spreadVirus() {

    for (int y = 0; y < N; ++y) {
        for (int x = 0; x < M; ++x) {
            if (board[y][x] == 2) {
                DFS(y, x);
            }

            
        }
    }
}
int getSafeZoneArea() {
    int area = 0;
    for (int y = 0; y < N; ++y) {
        for (int x = 0; x < M; ++x) {
            if (board[y][x] == 0) {
                area++;
            }
        }
    }

    return area;
}
void restoreBoard() {
    for (int y = 0; y < N; ++y) {
        for (int x = 0; x < M; ++x) {
            board[y][x] = boardCpy[y][x];
        }
    }
}


int main() {
    cin >> N >> M;

    vector<pair<int, int>> emptySpaceCoords;

    for (int y = 0; y < N; ++y) {
        for (int x = 0; x < M; ++x) {
            cin >> board[y][x];
            boardCpy[y][x] = board[y][x];
            if (board[y][x] == 0) {
                emptySpaceCoords.push_back({ y,x }); //Left Up 좌표 기준
            }
        }
    }

    const int sz = emptySpaceCoords.size();

    int answer = -1;
    for (int i = 0; i < sz; ++i) {
        for (int j = 0; j < sz; ++j) {
            for (int k = 0; k < sz; ++k) {
                if (i == j || i == k || j == k) {
                    continue;
                }

                int iy = emptySpaceCoords[i].first;
                int ix = emptySpaceCoords[i].second;

                int jy = emptySpaceCoords[j].first;
                int jx = emptySpaceCoords[j].second;
                
                int ky = emptySpaceCoords[k].first;
                int kx = emptySpaceCoords[k].second;

                board[iy][ix] = 1;
                board[jy][jx] = 1;
                board[ky][kx] = 1;

                spreadVirus();
                int area = getSafeZoneArea();
                answer = area > answer ? area : answer;
                restoreBoard();

                board[iy][ix] = 0;
                board[jy][jx] = 0;
                board[ky][kx] = 0;
                
            }
        }
    }

    cout << answer;
}



