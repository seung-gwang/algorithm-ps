#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int N;

int main(void) {
    cin >> N;
    vector<int> answer(N, 0);

    stack<pair<int, int>> stack; //높이-번호
    
    for (int i = 1; i <= N; ++i) {
        int h;
        cin >> h;

        while (!stack.empty() && stack.top().first < h) {
            stack.pop();
        }

        if (!stack.empty()) {
            answer[i - 1] = stack.top().second;
        }
        stack.push(make_pair(h, i));
    }

    for (const auto& a : answer) {
        cout << a << " ";
    }
}