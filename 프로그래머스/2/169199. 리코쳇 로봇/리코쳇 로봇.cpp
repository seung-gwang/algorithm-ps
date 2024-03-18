#include <string>
#include <vector>
#include <queue>
#include <limits.h>

using namespace std;

int n, m;
int moveCnt;
pair<int, int> sPos;
pair<int, int> gPos;
bool visit[101][101];

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

void bfs(vector<string>& board) {
    queue<pair<pair<int, int>, int>> q;

    q.push({ {sPos.first, sPos.second}, 0 });
    visit[sPos.first][sPos.second] = true;

    while (!q.empty()) {
        int cx = q.front().first.first;
        int cy = q.front().first.second;
        int cnt = q.front().second;
        q.pop();

        if (cx == gPos.first && cy == gPos.second) {
            moveCnt = min(moveCnt, cnt);
        }

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if ((nx < 0 || n <= nx || ny < 0 || m <= ny) || board[nx][ny] == 'D') {
                continue;
            }

            while (true) {
                nx += dx[i];
                ny += dy[i];

                if ((nx < 0 || n <= nx || ny < 0 || m <= ny) || board[nx][ny] == 'D') {
                    nx -= dx[i];
                    ny -= dy[i];
                    break;
                }
            }

            if (visit[nx][ny]) continue;

            q.push({ {nx, ny}, cnt + 1 });
            visit[nx][ny] = true;
        }
    }
}

int solution(vector<string> board) {
    moveCnt = INT_MAX;
    n = board.size();
    m = board[0].size();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {

            if (board[i][j] == 'R') {
                sPos = { i, j };
            }
            else if (board[i][j] == 'G') {
                gPos = { i, j };
            }
        }
    }

    bfs(board);

    if (moveCnt == INT_MAX) {
        return -1;
    }

    return moveCnt;
}