#include <iostream>
#include <algorithm>
using namespace std;
#define MAX 1500000

int n;
pair<int, int> tp[MAX];
int dp[MAX + 1];
int answer;
int numMax;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> tp[i].first >> tp[i].second;
	}
	for (int i = 0; i <= n; i++) {
		numMax = max(numMax, dp[i]);
		if (i + tp[i].first > n) continue;
		dp[i + tp[i].first] = max(dp[i + tp[i].first], numMax + tp[i].second);
		answer = max(answer, dp[i + tp[i].first]);
	}
	cout << answer << '\n';
	return 0;
}