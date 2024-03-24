#include <iostream>
#define MIN(a, b) (((a) < (b)) ? (a) : (b))
#define MAX(a, b) (((a) > (b)) ? (a) : (b))

using namespace std;
int N;
char nums[100000][3];
int dp[100000][3];

void solve() {
    cin >> N;
    for (int i = 0; i < N; ++i) {
        cin >> nums[i][0] >> nums[i][1] >> nums[i][2];
        nums[i][0] -= '0';
        nums[i][1] -= '0';
        nums[i][2] -= '0';
    }

    dp[0][0] = nums[0][0];
    dp[0][1] = nums[0][1];
    dp[0][2] = nums[0][2];

    for (int i = 1; i < N; ++i) {
        dp[i][0] = nums[i][0] + MAX(dp[i - 1][0], dp[i - 1][1]);
        dp[i][1] = nums[i][1] + MAX(MAX(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
        dp[i][2] = nums[i][2] + MAX(dp[i - 1][1], dp[i - 1][2]);
    }

    int maxVal = MAX(MAX(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);

    for (int i = 1; i < N; ++i) {
        dp[i][0] = nums[i][0] + MIN(dp[i - 1][0], dp[i - 1][1]);
        dp[i][1] = nums[i][1] + MIN(MIN(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
        dp[i][2] = nums[i][2] + MIN(dp[i - 1][1], dp[i - 1][2]);
    }


    int minVal = MIN(MIN(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);

    cout << maxVal << " " << minVal << endl;
}

int main() {
    solve();
}