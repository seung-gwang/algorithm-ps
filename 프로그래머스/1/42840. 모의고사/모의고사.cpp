#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    
    const int LEN1 = 5;
    const int LEN2 = 8;
    const int LEN3 = 10;
    
    int pick1[] = {1,2,3,4,5};
    int pick2[] = {2,1,2,3,2,4,2,5};
    int pick3[] = {3,3,1,1,2,2,4,4,5,5};
    
    int first = 0;
    int second = 0;
    int third = 0;
    
    for(int i = 0; i < answers.size(); ++i) {
        int cur = answers[i];
        if(pick1[i % LEN1] == cur) {
            first++;
        }
        
        if(pick2[i % LEN2] == cur) {
            second++;
        }
        
        if(pick3[i % LEN3] == cur) {
            third++;
        }
    }
    
    int max = first > second ? first : second;
    max = max > third ? max : third;
    
    if(first == max) {
        answer.push_back(1);
    }
    
    if(second == max) {
        answer.push_back(2);
    }
    
    if(third == max) {
        answer.push_back(3);
    }
    
    return answer;
}