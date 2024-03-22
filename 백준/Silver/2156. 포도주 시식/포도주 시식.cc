#include <iostream>
#include <algorithm>
#define MAX_N (10000)
using namespace std;

int N;
int wines[MAX_N + 1];
int dp[MAX_N + 1];
int answer;

void solve() {
    cin >> N;

    for (int i = 1; i <= N; ++i) {
        cin >> wines[i];
    }

    if (N == 1) {
        cout << wines[1];
        return;
    }

    dp[1] = wines[1];
    dp[2] = dp[1] + wines[2];
    answer = max(dp[1], dp[2]);

    for (int i = 3; i <= N; ++i) {
        dp[i] = max(max(dp[i -2], dp[i-3] + wines[i-1]) + wines[i], dp[i-1]);
        answer = max(answer, dp[i]);
    }

    cout << answer;
}

int main() {
    solve();
    return 0;
}
