#include <iostream>
#include <algorithm>
#include <limits.h>
#define MAX_N (10000)
#define MAX_M (1000000000)
using namespace std;

int N, M;
int req[MAX_N];
int budget;

int main() {
    cin >> N;
    int reqSum = 0;
    int maxReq = 0;
    for (int i = 0; i < N; ++i) {
        cin >> req[i];
        reqSum += req[i];
        maxReq = max(req[i], maxReq);
    }

    cin >> budget;

    sort(&req[0], &req[N - 1]);

    int l = 0;
    int r = INT_MAX;

    int minRemainSum = INT_MAX;
    int maxLimit = -1;

    int ans = req[0];
    while (l <= r) {
        int limit = (l + r) / 2;
        int sum = 0;

        for (int i = 0; i < N; ++i) {
            sum += min(req[i], limit);
        }

        if (budget < sum) {
            r = limit - 1;
        }

        if (budget >= sum) {
            ans = limit;
            l = limit + 1;
        }    
      
    }

    cout << min(maxReq, ans);

    return 0;
}