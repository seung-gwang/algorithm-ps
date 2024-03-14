#include <iostream>
#include <vector>
#include <algorithm>
#include <limits.h>

#define MAX_N (300)


using namespace std;

int N;
int point[MAX_N + 1];
int sum[MAX_N + 1];


int solve() {
    cin >> N;
    for (int i = 1; i <= N; ++i) {
        cin >> point[i];
        sum[i] = 0;
    }

    sum[1] = point[1];
    sum[2] = point[1] + point[2];
    sum[3] = max(point[1] + point[3], point[2] + point[3]);
    for (int i = 4; i <= N; ++i) {
        sum[i] = max(sum[i-2] + point[i], sum[i-3] + point[i-1] + point[i]);
    }

    return sum[N];


}

int main() {
    cout << solve();
}