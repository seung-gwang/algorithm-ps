#include <iostream>
#include <limits.h>
#define MAX_N (45)
using namespace std;

int n;

size_t fib[MAX_N];

void solve() {
    cin >> n;
    fib[0] = 0;
    fib[1] = 1;

    for (int i = 2; i <= n; ++i) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }

    cout << fib[n];
}

int main(void) {
    solve();
    return 0;
}
