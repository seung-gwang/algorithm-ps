#include <iostream>
#define INF (5000000)
#define MIN(a, b) ((a) > (b) ? (b) : (a)) 
using namespace std;

int N; //N <= 50만
int M;
bool malfunc[10];

int dp[INF + 1];

int main() {
    for (int i = 0; i <= 9; ++i) {
        malfunc[i] = false;
    }

    for (int i = 0; i <= INF; ++i) {
        dp[i] = INF;
    }

    cin >> N;
    cin >> M;
    for (int j = 0; j < M; ++j) {
        int m;
        cin >> m;
        malfunc[m] = true;
    }


    for (int k = 0; k <= 9; ++k) {
        if (malfunc[k] == false) {
            dp[k] = 1;
        }
    }

    for (int i = 0; i <= INF; ++i) {
        if (dp[i] != INF) {
            //숫자
            for (int j = 0; j <= 9; ++j) {
                if (malfunc[j]) {
                    continue;
                }

                int next = i * 10 + j;
                if (next > INF) {
                    continue;
                }

                dp[next] = MIN(dp[next], dp[i] + 1);
            }


        }
    }

    dp[100] = 0;

    for (int i = 0; i < INF; ++i) {
        if (dp[i] == INF) { continue; }

        int dist = N - i;
        if (dist < 0) {
            dist = -dist;
        }

        dp[N] = MIN(dp[N], dp[i] + dist);
    }

    cout << dp[N];

    return 0;
}
