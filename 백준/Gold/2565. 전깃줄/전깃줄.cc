#include <iostream>
#include <vector>
#include <algorithm>
#define INF (999999999)
using namespace std;

int main() {
    int N;
    vector<pair<int, int>> lines;

    cin >> N;
    for (int i = 0; i < N; ++i) {
        int s, e;
        cin >> s >> e;
        lines.push_back({ s, e });
    }

    sort(lines.begin(), lines.end());
    vector<int> A;

    for (const auto& e : lines) {
        A.push_back(e.second);
    }

    vector<int> D(A.size(), INF);
   
    for (const int a : A) {
        int l = 0;
        int r = A.size() - 1;

        int idx = 0;
        while (l <= r) {
            int mid = (l + r) / 2;

            //a보다 큰 D[i]값 중 가장 작은 것 (가장 왼쪽에 있는 것)
            if (D[mid] >= a) {
                idx = mid;
                r = mid - 1;
                
            }
            else { //D[mid] < a
                l = mid + 1;
            }
        }

        D[idx] = D[idx] > a ? a : D[idx];
    }

    int incrementLen = 0;
    for (const int d : D) {
        if (d != INF) {
            incrementLen++;
        }
    }

    cout << N - incrementLen;

    return 0;
}