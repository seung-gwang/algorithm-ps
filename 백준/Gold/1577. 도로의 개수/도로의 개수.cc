#include <iostream>
#include <set>
#include <vector>
#define MAX_SIDE (100)

using namespace std;

int N, M; //가로 세로

set<vector<int>> ban;

size_t dp[MAX_SIDE + 2][MAX_SIDE + 2];

int main() {
    cin >> N >> M;
    for (int y = 0; y <= M; ++y) {
        for (int x = 0; x <= N; ++x) {
            dp[y][x] = 0;
        }
    }

    int k;
    cin >> k;

    ban.clear();
    for (int i = 0; i < k; ++i) {
        int a, b, c, d;
        cin >> a >> b >> c >> d; //xy xy
        ban.insert({ a,b,c,d });
        ban.insert({ c,d,a,b });
    }

    size_t answer = -1;

    dp[0][0] = 1;
    for (int cy = 0; cy <= M; ++cy) {
        for (int cx = 0; cx <= N; ++cx) {

            if (dp[cy][cx] == 0) {
                continue;
            }

            //위로 가기
            int uy = cy + 1;
            int ux = cx;

            if (ban.find({cx,cy,ux,uy}) == ban.end()) {
                dp[uy][ux] += dp[cy][cx];
            }

            //왼쪽으로 가기
            int ly = cy;
            int lx = cx + 1;

            if (ban.find({cx,cy,lx,ly}) == ban.end()) {
                dp[ly][lx] += dp[cy][cx];
            }
        }
    }

    cout << dp[M][N];

}