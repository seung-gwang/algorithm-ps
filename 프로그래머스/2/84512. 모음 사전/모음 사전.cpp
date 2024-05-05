#include <string>
#include <vector>

using namespace std;

int cnt = -1;
int answer = 0;
string target = "";
const string VOWELS  = "AEIOU";
const int MAX_LEN = 5;

void DFS(string word) {
     cnt++;
    
    if (word == target) {
        answer = cnt;
        return;
    }
    
    if (word.length() >= MAX_LEN) {
        return;
    }
    
    
    
    for (int i = 0; i < MAX_LEN; i++) {
        DFS(word + VOWELS[i]);
    }
}

int solution(string word) {   
    target = word;
    DFS("");
    return answer;
}