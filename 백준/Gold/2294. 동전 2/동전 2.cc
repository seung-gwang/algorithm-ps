#include <iostream>
#include <vector>
#include <algorithm>
#define INF (1999999999)
using namespace std;

int N, K;

int dp[10000 + 1];

int main(void) {
    cin >> N >> K;
    vector<int> coins;
    for (int i = 0; i < N; ++i) {
        int v;
        cin >> v;
        coins.push_back(v);
    }

    sort(coins.begin(), coins.end());

    dp[0] = 0;
    for (int i = 1; i <= K; ++i) {
        dp[i] = INF;
    }

    for (int cur = 0; cur <= K; ++cur) {
        if (dp[cur] == INF) { continue; }
        for(const auto& val : coins) {
            int next = cur + val;
            if (next > K) { break; }
            dp[next] = min(dp[cur] + 1, dp[next]);
        }
    }

    int answer = -1;

    if (dp[K] != INF) {
        answer = dp[K];
    }

    cout << answer;
}