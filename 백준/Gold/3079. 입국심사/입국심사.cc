#include <stdio.h>
#include <iostream>
#define MAX_N (100000)
#define INF (1000000000000000000LL)
using namespace std;

long long N, M;
long long K[MAX_N];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;
    
    for (int i = 0; i < N; ++i) {
        cin >> K[i];
    }

    long long l = 0;
    long long r = INF;

    long long answer = -1;
    while (l <= r) {
        long long mid = (l + r) / 2;

        long long cnt = 0;
        for (int i = 0; i < N; ++i) {
            cnt += mid / K[i];
            if (cnt >= M) {
                break;
            }
        }

        if (cnt < M) {
            l = mid + 1;
        }

        if (cnt >= M) {
            r = mid - 1;
            answer = mid;
        }
    }

    cout << answer;

    return 0;

}