#include <string>
#include <vector>
using namespace std;

vector<vector<int>> gAnswer;

void hanoi(int n, int src, int path, int dst)
{
    if(n == 0) return;
    hanoi(n - 1, src, dst, path);
    gAnswer.push_back({src, dst});
    hanoi(n - 1, path, src, dst);
}

vector<vector<int>> solution(int n) {
    hanoi(n, 1,2,3);
    return gAnswer;
}