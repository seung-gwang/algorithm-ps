#include <string>
#include <vector>
#include <iostream>
using namespace std;
/*
짝수 -> 그냥 1 더함

홀수
왼쪽에서 처음으로 나오는 01을 10으로 바꿈

*/
long long to_decimal(string nstr) {
    long long pow2 = 1;
    long long ret = 0;
    for(int i = nstr.size() - 1; i >= 0; --i) {
        if(nstr[i] == '1') {
            ret += pow2;
        }
        pow2 *= 2;
    }   
    
    return ret;
}

string to_binary(long long n) {
    string ret = "";
    while(n > 0) {
        if(n % 2 == 0) {
            ret = "0" + ret;
        }
        else {
            ret = "1" + ret;
        }
        
        n /= 2;
    }
    
    return ret;
}

long long subsol(long long n) {
    if(n % 2 == 0) {
        return n + 1;
    }
    
    string binary = to_binary(n);
    binary = "0" + binary;
    
    for(int i = binary.size() - 1; i >= 1; --i) {
        if(binary[i] == '1' && binary[i - 1] == '0') {
            binary[i] = '0';
            binary[i - 1] = '1';
            break;
        }
    }

    return to_decimal(binary);
}

vector<long long> solution(vector<long long> numbers) {
    vector<long long> answer;
    for(const auto& n : numbers) {
        answer.push_back(subsol(n));
    }
    return answer;
}