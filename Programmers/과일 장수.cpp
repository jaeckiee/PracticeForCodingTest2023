#include <string>
#include <vector>

using namespace std;

int solution(int k, int m, vector<int> score) {
    int answer = 0;
    int count[10];
    int scoreSize = score.size();
    for(int i = 0; i < 10; i++){
        count[i] = 0;
    }
    for(int i = 0; i < scoreSize; i++){
        int currScore = score[i];
        count[currScore] = count[currScore] + 1;
    }
    int index = 9;
    int tmpCount = m;
    while(index > 0){
        if(count[index] == 0){
            index--;
            continue;
        }
        tmpCount--;
        count[index] = count[index] - 1;
        if(tmpCount == 0){
            tmpCount = m;
            answer += index * m;
        }
    }
    return answer;
}