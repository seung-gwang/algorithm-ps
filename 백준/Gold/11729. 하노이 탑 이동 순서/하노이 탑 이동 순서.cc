#include <iostream>
#include <vector>
using namespace std;

int N;

void hanoi(const int N, const int src, const int path, const int dst, vector<vector<int>>& move) {
    if (N == 0) { return; }
    hanoi(N - 1, src, dst, path, move);
    move.push_back({ src, dst });
    hanoi(N - 1, path, src, dst, move);
}

int main(void) {
    cin >> N;
    vector<vector<int>> move;
    hanoi(N, 1,2,3, move);

    cout << move.size() << endl;
    for (const auto& m : move) {
        printf("%d %d\n", m[0], m[1]);
    }

    return 0;
}