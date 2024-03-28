#include <iostream>
#include <vector>

using namespace std;

vector<int> answers;

// 이진 트리 노드 구조체 정의
struct Node {
    int data;
    Node* left;
    Node* right;
};

// 후위 순회를 수행하는 함수
void postOrder(vector<int>& preorder, int start, int end) {
    if (start > end)
        return;

    // 루트 노드는 전위 순회에서 첫 번째 요소
    int root = preorder[start];

    // 왼쪽 서브트리의 마지막 노드를 찾는 과정
    int i;
    for (i = start + 1; i <= end; i++) {
        if (preorder[i] > root)
            break;
    }

    // 왼쪽 서브트리 후위 순회
    postOrder(preorder, start + 1, i - 1);

    // 오른쪽 서브트리 후위 순회
    postOrder(preorder, i, end);

    // 현재 노드 값 저장
    answers.push_back(root);
}

int main() {
    answers.clear();

    vector<int> preorder;
    while (true) {
        int a = -1;
        cin >> a;

        if (a == -1) {
            break;
        }

        preorder.push_back(a);
    }
    

    // 전위 순회 결과의 크기
    int size = preorder.size();
    postOrder(preorder, 0, size - 1);

    for (int i = 0; i < answers.size() - 1; ++i) {
        cout << answers[i] << '\n';
    }
    cout << answers.back();

    return 0;
}
